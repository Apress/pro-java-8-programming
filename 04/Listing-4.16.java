public class Test {

  public static void main(String[] args) {
    Test t = new Test();
  }

  public Test() {
    Runnable runner = new MyRunnable("First");
    Thread t = new Thread(runner);
    t.setPriority(Thread.MIN_PRIORITY);
    t.start();
    runner = new MyRunnable("Second");
    t = new Thread(runner);
    t.setPriority(Thread.MAX_PRIORITY);
    t.start();
  }

  class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String tn) {
      name = tn;
    }

    public void run() {
      while (true) {
        System.out.println(name);
      }
    }
  }

}
