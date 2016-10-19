import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GenderRenderer extends JComboBox implements TableCellRenderer {

  public GenderRenderer() {
    super();
    addItem("Male");
    addItem("Female");
  }

  public Component getTableCellRendererComponent(JTable table,
          Object value, boolean isSelected, boolean hasFocus,
          int row, int column) {

    if (isSelected) {
      setForeground(table.getSelectionForeground());
      super.setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }

    boolean isMale = ((Boolean)value).booleanValue();
    setSelectedIndex(isMale ? 0 : 1);
    return this;
    }

  }
