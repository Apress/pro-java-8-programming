import java.awt.*;
import javax.swing.*;

public class Embedded extends JFrame {

  public static void main(String[] args) {
    Embedded e = new Embedded();
    e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    e.setSize(400, 300);
    e.setVisible(true);
  }

  public Embedded() {
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
    pane.add(getHeader(), BorderLayout.NORTH);
    pane.add(getTextArea(), BorderLayout.CENTER);
    pane.add(getButtonPanel(), BorderLayout.SOUTH);
  }

  private JComponent getHeader() {
    JLabel label = new JLabel("Embedded Layout Manager Test",
    			       JLabel.CENTER);
    label.setFont(new Font("Courier", Font.BOLD, 24));
    return label;
  }

  private JComponent getTextArea() {
    return new JTextArea(10, 10);
  }

  private JComponent getButtonPanel() {
    JPanel inner = new JPanel();
    inner.setLayout(new GridLayout(1, 2, 10, 0));
    inner.add(new JButton("Ok"));
    inner.add(new JButton("Cancel"));
    return inner;
  }

}
