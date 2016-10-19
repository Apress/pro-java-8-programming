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
