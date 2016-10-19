import java.awt.*;
import javax.swing.*;

public class SelectorTest extends JPanel {

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = f.getContentPane();
    pane.setLayout(new BorderLayout());
    Object[] values = {"Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday"};
    SelectorPanel sp = new SelectorPanel(values);
    sp.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    pane.add(sp);
    f.setSize(400, 300);
    f.setVisible(true);
  }

}
