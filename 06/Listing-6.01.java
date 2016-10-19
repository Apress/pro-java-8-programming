import java.awt.*;
import javax.swing.*;

public class CardTest extends JFrame {

  private CardLayout layout;

  public static void main(String[] args) {
    CardTest ct = new CardTest();
    ct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ct.displayTab("Green Tab");
    ct.setSize(400, 300);
    ct.setVisible(true);
  }

  public CardTest() {
    JPanel tab;
    Container pane = getContentPane();
    layout = new CardLayout();
    pane.setLayout(layout);
    tab = new JPanel();
    tab.setBackground(Color.red);
    pane.add(tab, "Red Tab");
    tab = new JPanel();
    tab.setBackground(Color.green);
    pane.add(tab, "Green Tab");
    tab = new JPanel();
    tab.setBackground(Color.blue);
    pane.add(tab, "Blue Tab");
  }
  public void displayTab(String name) {
    layout.show(this.getContentPane(), name);
  }

}