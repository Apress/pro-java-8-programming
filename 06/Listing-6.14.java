import java.awt.*;
import javax.swing.*;

public class GridHeight {

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = f.getContentPane();
    pane.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    pane.add(new JButton("First row, first column"), constraints);
    pane.add(new JButton("First row, second column"), constraints);
    constraints.gridheight = GridBagConstraints.REMAINDER;
    constraints.fill = GridBagConstraints.VERTICAL;
    pane.add(new JButton("First row, third column"), constraints);
    constraints.gridx = 0;
    constraints.gridheight = 1;
    constraints.fill = GridBagConstraints.NONE;
    pane.add(new JButton("Second row"), constraints);
    pane.add(new JButton("Third row"), constraints);
    f.setSize(600, 300);
    f.setVisible(true);
  }

}
