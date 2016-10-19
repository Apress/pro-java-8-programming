import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Downloader extends JPanel implements Runnable {

  private URL downloadURL;
  private InputStream inputStream;

  private OutputStream outputStream;
  private byte[] buffer;

  private int fileSize;
  private int bytesRead;

  private JLabel urlLabel;
  private JLabel sizeLabel;
  private JLabel completeLabel;
  private JProgressBar progressBar;

  public final static int BUFFER_SIZE = 1000;

  private boolean stopped;
  private boolean sleepScheduled;

  public final static int SLEEP_TIME = 5 * 1000; // 5 seconds

  private Thread thisThread;

  public static void main(String[] args) throws Exception {
    Downloader dl = null;
    if (args.length < 2) {
      System.out.println("You must specify the URL of the file to download and "+
        "the name of the local file to which its contents will be written.");
      System.exit(0);
    }
    URL url = new URL(args[0]);
    FileOutputStream fos = new FileOutputStream(args[1]);
    try {
      dl = new Downloader(url, fos);
    } catch (FileNotFoundException fnfe) {
      System.out.println("File '" + args[0] + "' does not exist");
      System.exit(0);
    }
    JFrame f = new JFrame();
    f.getContentPane().add(dl);
    f.setSize(400, 300);
    f.setVisible(true);
    dl.thisThread.start();
  }

  public Downloader(URL url, OutputStream os) throws IOException {
    downloadURL = url;
    outputStream = os;
    bytesRead = 0;
    URLConnection urlConnection = downloadURL.openConnection();
    fileSize = urlConnection.getContentLength();
    if (fileSize == -1) {
      throw new FileNotFoundException(url.toString());
    }
    inputStream = new BufferedInputStream(
        urlConnection.getInputStream());
    buffer = new byte[BUFFER_SIZE];
    thisThread = new Thread(this);
    buildLayout();

    stopped = false;
    sleepScheduled = false;
  }

  private void buildLayout() {
    JLabel label;
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.insets = new Insets(5, 10, 5, 10);

    constraints.gridx = 0;
    label = new JLabel("URL:", JLabel.LEFT);
    add(label, constraints);

    label = new JLabel("Complete:", JLabel.LEFT);
    add(label, constraints);

    label = new JLabel("Downloaded:", JLabel.LEFT);
    add(label, constraints);

    constraints.gridx = 1;
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    constraints.weightx = 1;
    urlLabel = new JLabel(downloadURL.toString());
    add(urlLabel, constraints);

    progressBar = new JProgressBar(0, fileSize);
    progressBar.setStringPainted(true);
    add(progressBar, constraints);

    constraints.gridwidth = 1;
    completeLabel = new JLabel(Integer.toString(bytesRead));
    add(completeLabel, constraints);

    constraints.gridx = 2;
    constraints.weightx = 0;
    constraints.anchor = GridBagConstraints.EAST;
    label = new JLabel("Size:", JLabel.LEFT);
    add(label, constraints);

    constraints.gridx = 3;
    constraints.weightx = 1;
    sizeLabel = new JLabel(Integer.toString(fileSize));
    add(sizeLabel, constraints);
  }

  public void startDownload() {
    thisThread.start();
  }

  public synchronized void setSleepScheduled(boolean doSleep) {
    sleepScheduled = doSleep;
  }

  public synchronized boolean isSleepScheduled() {
    return sleepScheduled;
  }

  public void run() {
    performDownload();
  }

  public void performDownload() {
    int byteCount;
    Runnable progressUpdate = new Runnable() {
      public void run() {
        progressBar.setValue(bytesRead);
        completeLabel.setText(
             Integer.toString(
             bytesRead));
      }
    };
    while ((bytesRead < fileSize) && (!stopped)) {
      try {
        if (isSleepScheduled()) {
         try {
           Thread.sleep(SLEEP_TIME);
           setSleepScheduled(false);
         }
         catch (InterruptedException ie) {
         }
       }
    byteCount = inputStream.read(buffer);
    if (byteCount == -1) {
      stopped = true;
      break;
    }
    else {
      outputStream.write(buffer, 0,
          byteCount);
      bytesRead += byteCount;
      SwingUtilities.invokeLater(
          progressUpdate);
    }
  } catch (IOException ioe) {
    stopped = true;
    JOptionPane.showMessageDialog(this,
        ioe.getMessage(),
        "I/O Error",
        JOptionPane.ERROR_MESSAGE);
      break;
    }
  }
  try {
    outputStream.close();
    inputStream.close();
  } catch (IOException ioe) {};
 }

}
