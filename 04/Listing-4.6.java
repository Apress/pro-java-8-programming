import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test {

  private JFrame frame;
  public static void main(String[] args) {
    Test t = new Test();
  }

  public Test() {
    frame = new JFrame("Hello World");
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        frame.setVisible(false);
        frame.removeWindowListener(this);
        frame.dispose();
        frame = null;
     }
    });
    Container pane = frame.getContentPane();
    pane.setLayout(new FlowLayout());
    pane.add(new JLabel("Hello world."));
    frame.setSize(400, 300);
    frame.setVisible(true);
  }

}
