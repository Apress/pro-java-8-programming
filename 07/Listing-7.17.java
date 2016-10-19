import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.Vector;

public class RowAdder extends JFrame {

  private SimpleModel tableData;
  private JTable table;
  private JTextField textField;

  public static void main(String[] args) {
    RowAdder ra = new RowAdder();
    ra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ra.setSize(400, 300);
    ra.setVisible(true);
  }

  public RowAdder() {
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
    tableData = new SimpleModel();
    table = new JTable(tableData);
    table.getColumnModel().getColumn(0).setPreferredWidth(300);
    JScrollPane jsp = new JScrollPane(table);
    pane.add(jsp, BorderLayout.CENTER);
    textField = new JTextField();
    textField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        addLineToTable();
      }
    });
    pane.add(textField, BorderLayout.SOUTH);
  }

  private void addLineToTable() {
    tableData.addText(textField.getText());
    textField.setText("");
  }

  class SimpleModel extends AbstractTableModel {

    private Vector textData = new Vector();

    public void addText(String text) {
      textData.addElement(text);
      fireTableDataChanged();
    }

    public int getRowCount() {
      return textData.size();
    }

    public int getColumnCount() {
      return 1;
    }

    public Object getValueAt(int row, int column) {
      return textData.elementAt(row);
    }

  }

}
