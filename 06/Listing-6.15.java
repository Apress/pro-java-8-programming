import java.awt.*;
import javax.swing.*;

public class SimplePanel extends JPanel {

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new SimplePanel());
    f.setSize(400, 300);
    f.setVisible(true);
  }

  public SimplePanel() {
    super();
    GridBagConstraints constraints = new GridBagConstraints();
    GridBagLayout layout = new GridBagLayout();
    setLayout(layout);

    constraints.anchor = GridBagConstraints.WEST;

    constraints.gridy = 0;
    JLabel label = new JLabel("First name:");
    add(label, constraints);

    JTextField tf = new JTextField(8);
    add(tf, constraints);

    label = new JLabel("Last name:");
    add(label, constraints);

    tf = new JTextField(8);
    add(tf, constraints);

    constraints.gridy = 1;
    label = new JLabel("Address:");
    add(label, constraints);

    tf = new JTextField(10);
    add(tf, constraints);
  }

}
