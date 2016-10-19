import java.awt.*;
import javax.swing.*;

public class Remainder {

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = f.getContentPane();
    pane.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    pane.add(new JButton("First row, first column"), constraints);
    pane.add(new JButton("First row, second column"), constraints);
    pane.add(new JButton("First row, third column"), constraints);
    constraints.gridx = 0;
    pane.add(new JButton("Second row"), constraints);
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    pane.add(new JButton(
      "Third row, gridwidth set to REMAINDER"), constraints);
    f.setSize(600, 300);
    f.setVisible(true);
  }

}
