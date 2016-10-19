public class ExceptionSampler {

  /**
   *  Not declaring that this method can throw MyFirstException will
   *  cause the Java compiler to generate an error message when this
   *  class is compiled. However, declaring MySecondException is
   *  optional.
   */
  public void doSomething(boolean throwFirst) throws MyFirstException {
    if (throwFirst) {
      throw new MyFirstException();
    } else {
      throw new MySecondException();
    }
  }

  class MyFirstException extends Exception {
  }

  class MySecondException extends RuntimeException {
  }

}
