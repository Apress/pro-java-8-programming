import java.util.*;
import javax.swing.*;

public class JavaQuestion {

  private static ResourceBundle resources =
      ResourceBundle.getBundle("MyResources");

  public static void main(String[] args) {
    ImageIcon flagIcon = (ImageIcon)(resources.getObject(
        "FlagIcon"));
    String[] options =
      {resources.getString("LabelYes"), resources.getString("LabelNo")};
    JOptionPane pane = new JOptionPane(
        resources.getString("JavaIsLang"),
        JOptionPane.QUESTION_MESSAGE,
        0, flagIcon, options);
    JDialog dlg = pane.createDialog(null,
        resources.getString("WhatIsJava"));
    dlg.setModal(true);
    dlg.setVisible(true);
    String selection = (String)(pane.getValue());
    boolean selectedYes = (selection == options[0]);
  }
}
