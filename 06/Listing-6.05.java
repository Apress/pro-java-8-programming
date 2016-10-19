import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class BorderSample extends JFrame {

  public static void main(String[] args) {
    BorderSample bs = new BorderSample();
    bs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = bs.getContentPane();
    pane.setLayout(new BorderLayout());
    Font f = new Font("Courier", Font.BOLD, 36);
    JLabel label = new JLabel("North", JLabel.CENTER);
    label.setFont(f);
    label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    pane.add(label, BorderLayout.NORTH);
    label = new JLabel("South", JLabel.CENTER);
    label.setFont(f);
    label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    pane.add(label, BorderLayout.SOUTH);
    label = new JLabel("East", JLabel.CENTER);
    label.setFont(f);
    label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    pane.add(label, BorderLayout.EAST);
    label = new JLabel("West", JLabel.CENTER);
    label.setFont(f);
    label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    pane.add(label, BorderLayout.WEST);
    label = new JLabel("Center", JLabel.CENTER);
    label.setFont(f);
    label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    pane.add(label, BorderLayout.CENTER);
    bs.setSize(400, 300);
    bs.setVisible(true);
  }

}
