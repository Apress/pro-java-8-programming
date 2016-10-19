import java.awt.*;
import javax.swing.*;

public class ZOrder extends JPanel {

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(new ZOrder());
    f.setSize(400, 300);
    f.setVisible(true);
  }

  public ZOrder() {
    setLayout(null);
    JButton first = new JButton("This button is added first");
    first.setBounds(20, 50, 200, 30);
    add(first);
    JButton second = new JButton("This button is added second");
    second.setBounds(120, 65, 200, 30);
    add(second);
  }

}
