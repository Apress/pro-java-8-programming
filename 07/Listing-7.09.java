import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

public class SimpleTableTest extends JFrame {

  private JTable table;

  public static void main(String[] args) {
    SimpleTableTest stt = new SimpleTableTest();
    stt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    stt.setSize(400, 200);
    stt.setVisible(true);
  }

  public SimpleTableTest() {
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
    TableValues tv = new TableValues();
    table = new JTable(tv);
    TableColumnModel tcm = table.getColumnModel();
    TableColumn tc = tcm.getColumn(TableValues.GENDER);
    tc.setCellRenderer(new GenderRenderer());
    tc.setCellEditor(new GenderEditor());
    table.setDefaultRenderer(Float.class, new CurrencyRenderer());
    JScrollPane jsp = new JScrollPane(table);
    pane.add(jsp, BorderLayout.CENTER);

    JPanel outerPanel = new JPanel();
    outerPanel.setLayout(new GridLayout(1, 2, 0, 0));
    JPanel innerPanel = new JPanel();
    innerPanel.setLayout(new FlowLayout());
    JCheckBox modeBox = new JCheckBox("Row", true);
    modeBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        JCheckBox box = (JCheckBox)(event.getSource());
        table.setRowSelectionAllowed(box.isSelected());
      }
    });
    innerPanel.add(modeBox);
    modeBox = new JCheckBox("Column");
    modeBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        JCheckBox box = (JCheckBox)(event.getSource());
        table.setColumnSelectionAllowed(box.isSelected());
      }
    });
    innerPanel.add(modeBox);
    modeBox = new JCheckBox("Cell");
    modeBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        JCheckBox box = (JCheckBox)(event.getSource());
        table.setCellSelectionEnabled(box.isSelected());
      }
    });
    innerPanel.add(modeBox);

    BevelBorder bb = new BevelBorder(BevelBorder.RAISED);
    TitledBorder tb = new TitledBorder(bb, "Table Selection Types");
    innerPanel.setBorder(tb);
    outerPanel.add(innerPanel);
    innerPanel = new JPanel();
    innerPanel.setLayout(new FlowLayout());
    JComboBox listModes = new JComboBox();
    listModes.addItem("Single Selection");
    listModes.addItem("Single Interval Selection");
    listModes.addItem("Multiple Interval Selections");
    listModes.setSelectedIndex(2);
    listModes.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        JComboBox box = (JComboBox)(event.getSource());
        int index = box.getSelectedIndex();
        switch (index) {
        case 0:
          table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          break;
        case 1:
          table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
          break;
        case 2:
          table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
          break;
        }
      }
    });
    innerPanel.add(listModes);
    bb = new BevelBorder(BevelBorder.RAISED);
    tb = new TitledBorder(bb, "List Selection Modes");
    innerPanel.setBorder(tb);
    outerPanel.add(innerPanel);

    pane.add(outerPanel, BorderLayout.SOUTH);
  }
}
