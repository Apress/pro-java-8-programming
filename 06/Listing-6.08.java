import java.awt.*;
import javax.swing.*;

public class RelativeY {

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = f.getContentPane();
    pane.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    pane.add(new JButton("First column"), constraints);
    constraints.gridx = 1;
    constraints.gridy = GridBagConstraints.RELATIVE;
    pane.add(new JButton("Second column, first row"), constraints);
    pane.add(new JButton("Second column, second row"), constraints);
    pane.add(new JButton("Second column, third row"), constraints);
    constraints.gridx = 2;
    pane.add(new JButton("Third column"), constraints);
    f.setSize(500, 300);
    f.setVisible(true);
  }

}
