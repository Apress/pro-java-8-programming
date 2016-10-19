public synchronized void setStopped(boolean stop) {
  stopped = stop;
}

public synchronized boolean isStopped() {
  return stopped;
}

public void run() {
  int byteCount;
  Runnable progressUpdate = new Runnable() {
    public void run() {
      progressBar.setValue(bytesRead);
      completeLabel.setText(
          Integer.toString(
          bytesRead));
    }
  };
  while ((bytesRead < fileSize) && (!isStopped())) {
    try {
      if (isSleepScheduled()) {s
        try {
          Thread.sleep(SLEEP_TIME);
          setSleepScheduled(false);
        }
        catch (InterruptedException ie) {
        }
      }
      byteCount = inputStream.read(buffer);
      if (byteCount == -1) {
        setStopped(true);
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
      setStopped(true);
      JOptionPane.showMessageDialog(this,
           ioe.getMessage(),
           "I/O Error",
           JOptionPane.ERROR_MESSAGE);
      break;
    }
    synchronized (this) {
      if (isSuspended()) {
        try {
          this.wait();
          setSuspended(false);
        }
        catch (InterruptedException ie) {
        }
      }
    }
  }
    try {
       outputStream.close();
       inputStream.close();
    } catch (IOException ioe) {};
  }

}
