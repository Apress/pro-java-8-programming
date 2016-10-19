import java.awt.*;
import javax.swing.*;

public class Fill {

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = f.getContentPane();
    pane.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.gridy = GridBagConstraints.RELATIVE;
    pane.add(new JButton("This button’s preferred width " +
      "is large because its text is long"),
      constraints);
    pane.add(new JButton("Small centered button"), constraints);
    constraints.fill = GridBagConstraints.HORIZONTAL;
    pane.add(new JButton("Expands to fill column width"), constraints);
    f.setSize(400, 300);
    f.setVisible(true);
  }

}
