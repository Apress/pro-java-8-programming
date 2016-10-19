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
  buildLayout();

  stopped = false;
}
