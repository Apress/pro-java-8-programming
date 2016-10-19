import java.awt.*;
import javax.swing.*;

public class BoxTest {

  public static void main(String[] args) {
    JFrame f = new JFrame("Vertical BoxLayout-managed container");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = new BoxPanel();
    f.setContentPane(pane);
    BoxLayout bl = new BoxLayout(pane, BoxLayout.Y_AXIS);
    pane.setLayout(bl);
    for (float align = 0.0f; align <= 1.0f; align += 0.25f) {
      JButton button = new JButton("X Alignment = " + align);
      button.setAlignmentX(align);
      pane.add(button);
      pane.add(Box.createRigidArea(new Dimension(0, 15)));
    }
    f.setSize(400, 300);
    f.setVisible(true);
  }
}
