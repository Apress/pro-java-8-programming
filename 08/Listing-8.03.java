import javax.swing.*;
import javax.swing.tree.*;

public class TreeTest extends JFrame {

  private final static String[] questions = {
      "Green Kryptonite is only deadly " +
      "to beings from Krypton with superpowers",
      "Red Kryptonite’s effects are permanent",
      "Gold Kryptonite permanently enhances superpowers",
      "Blue Kryptonite affects only Bizarros",
      "White Kryptonite affects only marine life",
      "Jewel Kryptonite was formed from Krypton’s " +
      "Jewel Mountains"};

  public static void main(String[] args) {
    TreeTest tt = new TreeTest();
    tt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    tt.setSize(500, 200);
    tt.setVisible(true);
  }

  public TreeTest() {
    super("Smallville University Final Exam");
    JTree tree = new JTree(getRootNode());
    JScrollPane jsp = new JScrollPane(tree);
    getContentPane().add(jsp);
  }

  private MutableTreeNode getRootNode() {
    DefaultMutableTreeNode root, child;
    TrueFalseQuestion question;
    root = new DefaultMutableTreeNode(
      "Kryptonite Questions -- Check all " +
      "of the following that are true " +
      "statements");
    for (int i = 0; i < questions.length; i++) {
      question = new TrueFalseQuestion(questions[i]);
      child = new DefaultMutableTreeNode(question);
      root.add(child);
    }
    return root;
  }
}
