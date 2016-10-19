import java.awt.*;
import javax.swing.*;

public class GridTest extends JFrame {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("You must enter a row count and a column count");
      return;
    }
    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);
    GridTest gt = new GridTest(rows, cols);
    gt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gt.pack();
    gt.setVisible(true);
  }

  public GridTest(int rows, int cols) {
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(rows, cols));
    for (int i = 0; i < 20; i++) {
      JButton button = new JButton(Integer.toString(i + 1));
      pane.add(button);
    }
  }

}
