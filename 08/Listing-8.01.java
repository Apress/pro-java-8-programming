import javax.swing.*;

public class SimpleTreeTest extends JFrame {

  public static void main(String[] args) {
    SimpleTreeTest stt = new SimpleTreeTest();
    stt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    stt.setSize(250, 250);
    stt.setVisible(true);
  }
  public SimpleTreeTest() {
    Object[] genealogy = {"Jeff", "Joseph", "Pearl", "Owen", "Sarah",
        "John"};
    JTree tree = new JTree(genealogy);
    JScrollPane jsp = new JScrollPane(tree);
    getContentPane().add(jsp);
  }

}
