import java.awt.*;
import javax.swing.*;

public class FlowTest extends JFrame {

  public static void main(String[] args) {
    FlowTest ft = new FlowTest();
    ft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ft.setSize(400, 300);
    ft.setVisible(true);
  }

  public FlowTest() {
    super();
    Container pane = getContentPane();
    pane.setLayout(new FlowLayout(FlowLayout.LEFT));
    pane.add(new JLabel("This is a test"));
    pane.add(new JButton("of a FlowLayout"));
    pane.add(new JTextField(30));
    pane.add(new JTextArea("This is a JTextArea", 3, 10));
    pane.add(new JLabel("This is a FlowLayout test with a long string"));
  }
}
