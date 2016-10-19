import java.util.*;
import javax.swing.*;

public class JavaQuestion {

  public static void main(String[] args) {
    ImageIcon flagIcon = new ImageIcon("flags/unitedstates.gif");
    String[] options = {"Yes", "No"};
    JOptionPane pane = new JOptionPane(
        "Is Java an object-oriented programming language?",
        JOptionPane.QUESTION_MESSAGE, 0, flagIcon, options);
    JDialog dlg = pane.createDialog(null, "Java Question");
    dlg.setModal(true);
    dlg.setVisible(true);
    String selection = (String)(pane.getValue());
    boolean selectedYes = (selection == options[0]);
  }
}
