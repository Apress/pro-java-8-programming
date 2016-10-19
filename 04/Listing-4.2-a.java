public class ThreadShare implements Runnable {

  public static void main(String[] args) {
    ThreadShare ts = new ThreadShare();
    Thread t1 = new Thread(ts);
    Thread t2 = new Thread(ts);
    t1.start();
    t2.start();
  }

  public void run() {
    int nonSharedValue = 100;
    nonSharedValue += 100;
    System.out.println("Value: " + nonSharedValue);
  }

}
