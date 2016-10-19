public static void cancelAllAndWait() {
  int count = downloaderGroup.activeCount();
  Thread[] threads = new Thread[count];
  count = downloaderGroup.enumerate(threads);
  downloaderGroup.interrupt();
}
