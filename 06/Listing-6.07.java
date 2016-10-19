import java.awt.*;
import javax.swing.*;

public class RelativeX {

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = f.getContentPane();
    pane.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridy = 0;
    pane.add(new JButton("First row"), constraints);
    constraints.gridx = GridBagConstraints.RELATIVE;
    constraints.gridy = 1;
    pane.add(new JButton("Second row, first column"), constraints);
    pane.add(new JButton("Second row, second column"), constraints);
    pane.add(new JButton("Second row, third column"), constraints);
    constraints.gridy = 2;
    pane.add(new JButton("Third row"), constraints);
    f.setSize(600, 300);
    f.setVisible(true);
  }

}
