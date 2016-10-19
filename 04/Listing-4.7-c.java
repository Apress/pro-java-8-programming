public void performDownload() {
  int byteCount;
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
        progressBar.setValue(bytesRead);
        completeLabel.setText(
            Integer.toString(
            bytesRead));
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
