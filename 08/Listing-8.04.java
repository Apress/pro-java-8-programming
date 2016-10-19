import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class QuestionCellRenderer extends DefaultTreeCellRenderer {

  private JCheckBox questionRenderer = new JCheckBox();

  public Component getTreeCellRendererComponent(JTree tree,
      Object value, boolean selected, boolean expanded,
      boolean leaf, int row, boolean hasFocus) {
    if (value instanceof DefaultMutableTreeNode) {
      DefaultMutableTreeNode node =
          (DefaultMutableTreeNode)value;
      Object userObject = node.getUserObject();
      if (userObject instanceof TrueFalseQuestion) {
        TrueFalseQuestion question =
            (TrueFalseQuestion)userObject;
        prepareQuestionRenderer(question, selected);
        return questionRenderer;
       }
    }
    return super.getTreeCellRendererComponent(tree, value,
        selected, expanded, leaf, row, hasFocus);
  }

  private void prepareQuestionRenderer(TrueFalseQuestion tfq,
      boolean selected) {
    questionRenderer.setText(tfq.getQuestion());
    questionRenderer.setSelected(tfq.getAnswer());
    if (selected) {
      questionRenderer.setForeground(
          getTextSelectionColor());
      questionRenderer.setBackground(
          getBackgroundSelectionColor());
    }
    else {
      questionRenderer.setForeground(
          getTextNonSelectionColor());
      questionRenderer.setBackground(
          getBackgroundNonSelectionColor());
    }
  }

}
