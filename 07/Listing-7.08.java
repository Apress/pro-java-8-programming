import java.awt.Component;
import java.util.EventObject;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class GenderEditor extends JComboBox implements TableCellEditor {

  private EventListenerList listenerList = new EventListenerList();
  private ChangeEvent changeEvent = new ChangeEvent(this);

  public GenderEditor() {
    super();
    addItem("Male");
    addItem("Female");
    addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        fireEditingStopped();
      }
    });
  }

  public void addCellEditorListener(CellEditorListener listener) {
    listenerList.add(CellEditorListener.class, listener);
  }

  public void removeCellEditorListener(CellEditorListener listener) {
    listenerList.remove(CellEditorListener.class, listener);
  }

  private void fireEditingStopped() {
    CellEditorListener listener;
    Object[] listeners = listenerList.getListenerList();
    for (int i = 0; i < listeners.length; i++) {
      if (listeners[i] == CellEditorListener.class) {
      listener = (CellEditorListener)listeners[i + 1];
      listener.editingStopped(changeEvent);
    }
  }
}

  private void fireEditingCanceled() {
    CellEditorListener listener;
    Object[] listeners = listenerList.getListenerList();
    for (int i = 0; i < listeners.length; i++) {
      if (listeners[i] == CellEditorListener.class) {
        listener = (CellEditorListener)listeners[i + 1];
        listener.editingCanceled(changeEvent);
    }
  }
}

  public void cancelCellEditing() {
    fireEditingCanceled();
  }

  public boolean stopCellEditing() {
    fireEditingStopped();
    return true;
  }

  public boolean isCellEditable(EventObject event) {
    return true;
  }

  public boolean shouldSelectCell(EventObject event) {
    return true;
  }

  public Object getCellEditorValue() {
    return new Boolean(getSelectedIndex() == 0 ? true : false);
  }

  public Component getTableCellEditorComponent(JTable table,
          Object value, boolean isSelected, int row, int column) {
    boolean isMale = ((Boolean)value).booleanValue();
    setSelectedIndex(isMale ? 0 : 1);
    return this;
  }

}