import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Downloader extends JPanel {

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

  public static void main(String[] args) throws Exception {
    Downloader dl = null;
    if (args.length < 2) {
      System.out.println("You must specify the URL of the file " +
          "to download and the name of the local file to " +
          "which its contents will be written.");
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
    f.setSize(600, 400);
    f.setVisible(true);
    dl.performDownload();
  }
