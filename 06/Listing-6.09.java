import java.awt.*;
import javax.swing.*;

public class RelativeXY {

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = f.getContentPane();
    pane.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 1;
    constraints.gridy = GridBagConstraints.RELATIVE;
    pane.add(new JButton("First row, first column"), constraints);
    pane.add(new JButton("Second row"), constraints);
    pane.add(new JButton("Third row"), constraints);
    constraints.gridx = GridBagConstraints.RELATIVE;
    pane.add(new JButton("First row, second column"), constraints);
    f.setSize(500, 300);
    f.setVisible(true);
  }

}
