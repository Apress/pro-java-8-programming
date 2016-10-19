import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class GridBagTester extends JFrame {

  protected Container container;
  protected GridBagLayout manager;
  protected ColumnPanel columnPanel;
  protected RowPanel rowPanel;
  protected ComponentPanel componentPanel;

  public final static int COMPONENT_NAME = 0;
  public final static int COMPONENT_X = 1;
  public final static int COMPONENT_Y = 2;
  public final static int COMPONENT_WIDTH = 3;
  public final static int COMPONENT_HEIGHT = 4;
  public final static int COMPONENT_MINSIZE = 5;
  public final static int COMPONENT_PREFSIZE = 6;
  public final static int GRIDX = 7;
  public final static int GRIDY = 8;
  public final static int GRIDWIDTH = 9;
  public final static int GRIDHEIGHT = 10;
  public final static int FILL = 11;
  public final static int ANCHOR = 12;
  public final static int IPADX = 13;
  public final static int IPADY = 14;
  public final static int WEIGHTX = 15;
  public final static int WEIGHTY = 16;
  public final static int INSETS_TOP = 17;
  public final static int INSETS_LEFT = 18;
  public final static int INSETS_BOTTOM = 19;
  public final static int INSETS_RIGHT = 20;

  public final static int COLUMN_COUNT = 21;

  public final static Object[][] FILL_VALUES = {{
      new Integer(GridBagConstraints.NONE),
      new Integer(GridBagConstraints.HORIZONTAL),
      new Integer(GridBagConstraints.VERTICAL),
      new Integer(GridBagConstraints.BOTH)},
      {"NONE", "HORIZONTAL", "VERTICAL", "BOTH"}};

  public final static Object[][] ANCHOR_VALUES = {{
      new Integer(GridBagConstraints.NORTH),
      new Integer(GridBagConstraints.NORTHEAST),
      new Integer(GridBagConstraints.EAST),
      new Integer(GridBagConstraints.SOUTHEAST),
      new Integer(GridBagConstraints.SOUTH),
      new Integer(GridBagConstraints.SOUTHWEST),
      new Integer(GridBagConstraints.WEST),
      new Integer(GridBagConstraints.NORTHWEST),
      new Integer(GridBagConstraints.CENTER)},
      {"NORTH", "NORTHEAST", "EAST", "SOUTHEAST",
      "SOUTH", "SOUTHWEST", "WEST", "NORTHWEST",
      "CENTER"}};

  public final static Object[][] SIZE_VALUES = {{
      new Integer(GridBagConstraints.RELATIVE),
      new Integer(GridBagConstraints.REMAINDER)},
      {"RELATIVE", "REMAINDER"}};

  public final static Object[][] POSITION_VALUES = {{
      new Integer(GridBagConstraints.RELATIVE)},
      {"RELATIVE"}};

  public final static int NUMERIC_VALUE = 0;
  public final static int STRING_VALUE = 1;

  public GridBagTester(Container cont) {
    super("GridBagLayout Tester");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    container = cont;
    manager = (GridBagLayout)(container.getLayout());
    manager.layoutContainer(container);
    buildLayout();
    pack();
    setVisible(true);
  }

  protected void buildLayout() {
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
    columnPanel = new ColumnPanel();
    pane.add(columnPanel, BorderLayout.NORTH);
    rowPanel = new RowPanel();
    pane.add(rowPanel, BorderLayout.WEST);
    componentPanel = new ComponentPanel();
    pane.add(componentPanel, BorderLayout.SOUTH);
    pane.add(container, BorderLayout.CENTER);
  }

  class ColumnPanel extends JPanel {

    protected ColumnModel columnModel;

    public ColumnPanel() {
      super();
      setBorder(BorderFactory.createTitledBorder(
          "Column Widths and Weights"));
      columnModel = new ColumnModel();
      setLayout(new BorderLayout());
      JTable table = new JTable(columnModel);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table.setPreferredScrollableViewportSize(
          new Dimension(10, 55));
      JScrollPane jsp = new JScrollPane(table);
      JTable hdrTable = new JTable(new ColumnHeaderModel());
      hdrTable.setPreferredScrollableViewportSize(
          new Dimension(75, 50));
      jsp.setRowHeaderView(hdrTable);
      add(jsp, BorderLayout.CENTER);
    }

    public void refreshTable() {
      columnModel.fireTableDataChanged();
    }

  }

  class ColumnHeaderModel extends AbstractTableModel {

    final String[] headers = {"Width", "weightX",
        "Percent"};

    public int getRowCount() {
      return 3;
    }

    public int getColumnCount() {
      return 1;
    }

    public Object getValueAt(int row, int column) {
      return headers[row];
    }
  }

  class ColumnModel extends AbstractTableModel {

    public final int COLUMN_WIDTH = 0;
    public final int COLUMN_WEIGHT = 1;
    public final int COLUMN_DISTRIBUTION_PERCENT = 2;

    public int getRowCount() {
      return 3;
    }

    public int getColumnCount() {
      int[][] dimensions = manager.getLayoutDimensions();
      return dimensions[0].length;
    }

    public Object getValueAt(int row, int column) {
      Object value = null;
      int[][] dimensions;
      double[][] weights;
      switch (row) {
        case COLUMN_WIDTH:
          dimensions =
            manager.getLayoutDimensions();
          value = new Integer(
            dimensions[0][column]);
          break;
        case COLUMN_WEIGHT:
          weights = manager.getLayoutWeights();
          value = new Double(weights[0][column]);
          break;
        case COLUMN_DISTRIBUTION_PERCENT:
          weights = manager.getLayoutWeights();
          int count = weights[0].length;
          double total = 0;
          for (int i = 0; i < count; i++) {
            total += weights[0][i];
          }
          double percent = weights[0][column] /
            total * 100;
          value = new Integer((int)percent);
          break;
      }
      return value;
    }

    public String getColumnName(int column) {
      return new Integer(column).toString();
    }

  }

  class RowPanel extends JPanel {

    protected RowModel rowModel;

    public RowPanel() {
      super();
      setBorder(BorderFactory.createTitledBorder(
          "Row Heights and Weights"));
      rowModel = new RowModel();
      setLayout(new BorderLayout());
      JTable table = new JTable(rowModel);
      table.setPreferredScrollableViewportSize(
          new Dimension(150, 10));
      JScrollPane jsp = new JScrollPane(table);
      JTable hdrTable = new JTable(new RowHeaderModel());
      hdrTable.setPreferredScrollableViewportSize(
          new Dimension(25, 10));
      jsp.setRowHeaderView(hdrTable);
      add(jsp, BorderLayout.CENTER);
    }

    public void refreshTable() {
      rowModel.fireTableDataChanged();
    }

  }

  class RowHeaderModel extends AbstractTableModel {

    public int getRowCount() {
      int[][] dimensions = manager.getLayoutDimensions();
      return dimensions[1].length;
    }

    public int getColumnCount() {
      return 1;
    }

    public Object getValueAt(int row, int column) {
      return new Integer(row);
    }

  }

  class RowModel extends AbstractTableModel {

    public final int ROW_HEIGHT = 0;
    public final int ROW_WEIGHT = 1;
    public final int ROW_DISTRIBUTION_PERCENT = 2;

    final String[] headers = {"Height", "weightY", "Percent"};

    public int getRowCount() {
      int[][] dimensions = manager.getLayoutDimensions();
      return dimensions[1].length;
    }

    public int getColumnCount() {
      return 3;
    }

    public Object getValueAt(int row, int column) {
      Object value = null;
      int[][] dimensions;
      double[][] weights;
      switch (column) {
        case ROW_HEIGHT:
          dimensions =
            manager.getLayoutDimensions();
          value = new Integer(dimensions[1][row]);
          break;
        case ROW_WEIGHT:
          weights = manager.getLayoutWeights();
          value = new Double(weights[1][row]);
          break;
        case ROW_DISTRIBUTION_PERCENT:
          weights = manager.getLayoutWeights();
          int count = weights[1].length;
          double total = 0;
          for (int i = 0; i < count; i++) {
            total += weights[1][i];
          }
          double percent = weights[1][row] /
            total * 100;
          value = new Integer((int)percent);
          break;
      }
      return value;
    }

    public String getColumnName(int column) {
      return headers[column];
    }

  }

  class ComponentPanel extends JPanel {

    protected ComponentModel componentModel;

    public ComponentPanel() {
      super();
      setBorder(BorderFactory.createTitledBorder(
          "Component Constraints"));
      componentModel = new ComponentModel();
      setLayout(new BorderLayout());
      JTable table = new JTable(componentModel);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table.setRowSelectionAllowed(false);
      table.setDefaultRenderer(Dimension.class,
        new DimensionCellRenderer());
      table.setDefaultEditor(Double.class,
        new DoubleCellEditor());
      table.setDefaultEditor(Integer.class,
        new IntegerCellEditor());
      TableColumnModel tcm = table.getColumnModel();
      ConstraintDataCellRenderer cdcr =
          new ConstraintDataCellRenderer();
      ComboBoxCellEditor cbce = new ComboBoxCellEditor();
      TableColumn tc = tcm.getColumn(FILL);
      tc.setCellRenderer(cdcr);
      tc.setCellEditor(cbce);
      tc = tcm.getColumn(ANCHOR);
      tc.setCellRenderer(cdcr);
      tc.setCellEditor(cbce);
      tc = tcm.getColumn(GRIDX);
      tc.setCellRenderer(cdcr);
      tc.setCellEditor(cbce);
      tc = tcm.getColumn(GRIDY);
      tc.setCellRenderer(cdcr);
      tc.setCellEditor(cbce);
      tc = tcm.getColumn(GRIDWIDTH);
      tc.setCellRenderer(cdcr);
      tc.setCellEditor(cbce);
      tc = tcm.getColumn(GRIDHEIGHT);
      tc.setCellRenderer(cdcr);
      tc.setCellEditor(cbce);
      table.setPreferredScrollableViewportSize(
          new Dimension(10, 105));
      JScrollPane jsp = new JScrollPane(table);
      add(jsp, BorderLayout.CENTER);
    }

    public void refreshTable() {
      componentModel.fireTableDataChanged();
    }

  }

  class ComponentModel extends AbstractTableModel {

    public final String[] headers = {"Name", "X", "Y",
        "width", "height", "minSize", "prefSize",
        "gridx", "gridy", "gridwidth", "gridheight",
        "fill", "anchor", "ipadx", "ipady", "weightx",
        "weighty", "top", "left", "bottom", "right"};

    public int getRowCount() {
      return container.getComponents().length;
    }

    public int getColumnCount() {
      return COLUMN_COUNT;
    }

    public boolean isCellEditable(int row, int column) {
      switch (column) {
        case COMPONENT_MINSIZE:
        case COMPONENT_PREFSIZE:
          return false;
      }
      return true;
    }

    public Object getValueAt(int row, int column) {
      Object value = null;
      Component comp = container.getComponents()[row];
      GridBagConstraints gbc = manager.getConstraints(comp);
      switch (column) {
        case COMPONENT_NAME:
          String name = comp.getName();
          if ((name == null) ||
              (name.length() == 0)) {
            Class cl = comp.getClass();
            name = cl.getName();
            int ind =
              name.lastIndexOf('.');
            value = name.substring(ind + 1);
          }
          else {
            value = name;
          }
          break;
        case COMPONENT_X:
          value = new Integer(comp.getLocation().x);
          break;
        case COMPONENT_Y:
          value = new Integer(comp.getLocation().y);
          break;
        case COMPONENT_WIDTH:
          value = new Integer(comp.getSize().width);
          break;
        case COMPONENT_HEIGHT:
          value = new Integer(comp.getSize().height);
          break;
        case COMPONENT_MINSIZE:
          value = comp.getMinimumSize();
          break;
        case COMPONENT_PREFSIZE:
          value = comp.getPreferredSize();
          break;
        case GRIDX:
          value = new Integer(gbc.gridx);
          break;
        case GRIDY:
          value = new Integer(gbc.gridy);
          break;
        case GRIDWIDTH:
          value = new Integer(gbc.gridwidth);
          break;
        case GRIDHEIGHT:
          value = new Integer(gbc.gridheight);
          break;
        case FILL:
          value = new Integer(gbc.fill);
          break;
        case ANCHOR:
          value = new Integer(gbc.anchor);
          break;
        case IPADX:
          value = new Integer(gbc.ipadx);
          break;
        case IPADY:
          value = new Integer(gbc.ipady);
          break;
        case WEIGHTX:
          value = new Double(gbc.weightx);
          break;
        case WEIGHTY:
          value = new Double(gbc.weighty);
          break;
        case INSETS_TOP:
          value = new Integer(gbc.insets.top);
          break;
        case INSETS_LEFT:
          value = new Integer(gbc.insets.left);
          break;
        case INSETS_BOTTOM:
          value = new Integer(gbc.insets.bottom);
          break;
        case INSETS_RIGHT:
          value = new Integer(gbc.insets.right);
          break;
      }
      return value;
    }

    public void setValueAt(Object value, int row, int column) {
      Component comp = container.getComponents()[row];
      GridBagConstraints gbc = manager.getConstraints(comp);
      switch (column) {
        case COMPONENT_NAME:
          comp.setName((String)value);
          break;
        case COMPONENT_X:
          comp.setLocation(((Integer)value).intValue(),
            comp.getLocation().y);
          break;
        case COMPONENT_Y:
          comp.setLocation(comp.getLocation().x,
            ((Integer)value).intValue());
          break;
        case COMPONENT_WIDTH:
          comp.setSize(((Integer)value).intValue(),
            comp.getSize().width);
          break;
        case COMPONENT_HEIGHT:
          comp.setSize(comp.getSize().height,
            ((Integer)value).intValue());
          break;
        case GRIDX:
          gbc.gridx = ((Integer)value).intValue();
          break;
        case GRIDY:
          gbc.gridy = ((Integer)value).intValue();
          break;
        case GRIDWIDTH:
          gbc.gridwidth =
            ((Integer)value).intValue();
          break;
        case GRIDHEIGHT:
          gbc.gridheight =
            ((Integer)value).intValue();
          break;
        case FILL:
          gbc.fill = ((Integer)value).intValue();
          break;
        case ANCHOR:
          gbc.anchor =
            ((Integer)value).intValue();
          break;
        case IPADX:
          gbc.ipadx = ((Integer)value).intValue();
          break;
        case IPADY:
          gbc.ipady = ((Integer)value).intValue();
          break;
        case WEIGHTX:
          gbc.weightx =
            ((Double)value).doubleValue();
          break;
        case WEIGHTY:
          gbc.weighty =
            ((Double)value).doubleValue();
          break;
        case INSETS_TOP:
          gbc.insets.top =
            ((Integer)value).intValue();
          break;
        case INSETS_LEFT:
          gbc.insets.left =
            ((Integer)value).intValue();
          break;
        case INSETS_BOTTOM:
          gbc.insets.bottom =
            ((Integer)value).intValue();
          break;
        case INSETS_RIGHT:
          gbc.insets.right =
            ((Integer)value).intValue();
          break;
      }
      manager.setConstraints(comp, gbc);
      refreshAllTables();
    }

    public String getColumnName(int column) {
      return headers[column];
    }

    public Class getColumnClass(int column) {
      Class dataType = Object.class;
      switch (column) {
        case COMPONENT_NAME:
          break;
        case COMPONENT_X:
        case COMPONENT_Y:
          dataType = Integer.class;
          break;
        case COMPONENT_WIDTH:
        case COMPONENT_HEIGHT:
          dataType = Integer.class;
          break;
        case COMPONENT_MINSIZE:
        case COMPONENT_PREFSIZE:
          dataType = Dimension.class;
          break;
        case GRIDX:
        case GRIDY:
          break;
        case GRIDWIDTH:
        case GRIDHEIGHT:
          break;
        case FILL:
          break;
        case ANCHOR:
          break;
        case IPADX:
        case IPADY:
          dataType = Integer.class;
          break;
        case WEIGHTX:
        case WEIGHTY:
          dataType = Double.class;
          break;
        case INSETS_TOP:
        case INSETS_LEFT:
        case INSETS_BOTTOM:
        case INSETS_RIGHT:
          dataType = Integer.class;
          break;
      }
      return dataType;
    }
  }

  class DoubleCellEditor extends DefaultCellEditor {

    public DoubleCellEditor() {
      super(new NumericTextField(5, true));
    }

    public Object getCellEditorValue() {
      NumericTextField ntf = (NumericTextField)getComponent();
      return new Double(ntf.getText());
    }

  }

  class IntegerCellEditor extends DefaultCellEditor {

    public IntegerCellEditor() {
      super(new NumericTextField(5, false));
    }

    public Object getCellEditorValue() {
      NumericTextField ntf = (NumericTextField)getComponent();
      return new Integer(ntf.getText());
    }

  }

  class DimensionCellRenderer extends DefaultTableCellRenderer {

    public void setValue(Object value) {
      Dimension size = (Dimension)value;
      super.setValue("(" + size.width + "," +
          size.height + ")");
    }

  }

  class ConstraintDataCellRenderer extends JLabel
      implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table,
        Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {
      Object cellText = getStringFromValue(column, value);
      if (cellText != null) value = cellText;
      if (value instanceof Number) {
        setHorizontalAlignment(RIGHT);
      }
      else {
        setHorizontalAlignment(CENTER);
      }
      setText(value.toString());
      return this;
    }

  }

  class ComboBoxCellEditor extends DefaultCellEditor {

    protected Object[][] editorValues;

    public ComboBoxCellEditor() {
      super(new JComboBox());
      JComboBox box = (JComboBox)(getComponent());
      box.setEditor(new NumericComboBoxEditor());
    }

    public Component getTableCellEditorComponent(JTable table,
        Object value, boolean isSelected,
        int row, int column) {
      JComboBox box = (JComboBox)(getComponent());
      Object selection;
      switch (column) {
        case GRIDX:
        case GRIDY:
          box.setEditable(true);
          break;
        case GRIDWIDTH:
        case GRIDHEIGHT:
          box.setEditable(true);
          break;
        case FILL:
          box.setEditable(false);
          break;
        case ANCHOR:
          box.setEditable(false);
          break;
      }
      editorValues = getValueArray(column);
      DefaultComboBoxModel dcbm = new DefaultComboBoxModel(
          editorValues[STRING_VALUE]);
      box.setModel(dcbm);
      Object boxValue = getStringFromValue(column, value);
      if (boxValue != null) {
        box.setSelectedItem(getStringFromValue(column,
            value));
      }
      else {
        ComboBoxEditor editor = box.getEditor();
        editor.setItem(value);
      }
      return box;
    }

    public Object getCellEditorValue() {
      Object value = null;
      JComboBox box = (JComboBox)(getComponent());
      int index = box.getSelectedIndex();
      if (index != -1) {
        return editorValues[0][index];
      }
      else {
        value = new Integer(
          box.getSelectedItem().toString());
      }
      return value;
    }

  }

  class NumericComboBoxEditor extends NumericTextField
      implements ComboBoxEditor {

    public NumericComboBoxEditor() {
      super(5, false);
    }

    public Component getEditorComponent() {
      return this;
    }

    public Object getItem() {
      return getText();
    }

    public void setItem(Object item) {
      if (item != null)
      setText(item.toString());
    }

  }

  protected Object getStringFromValue(int column, Object value) {
    Object result = null;
    Object[][] values = getValueArray(column);
    if (values != null) {
      for (int i = 0; i < values[NUMERIC_VALUE].length; i++) {
        if (values[NUMERIC_VALUE][i].equals(value)) {
          result = values[STRING_VALUE][i];
          break;
        }
      }
    }
    return result;
  }

  protected Object getValueFromString(int column, String value) {
    Object result = null;
    Object[][] values = getValueArray(column);
    for (int i = 0; i < values[STRING_VALUE].length; i++) {
      if (value.equals(values[STRING_VALUE][i])) {
        result = values[NUMERIC_VALUE][i];
        break;
      }
    }
    return result;
  }

  protected Object[][] getValueArray(int column) {
    Object[][] result = null;
    switch (column) {
      case FILL:
        result = FILL_VALUES;
        break;
      case ANCHOR:
        result = ANCHOR_VALUES;
        break;
      case GRIDX:
      case GRIDY:
        result = POSITION_VALUES;
        break;
      case GRIDWIDTH:
      case GRIDHEIGHT:
        result = SIZE_VALUES;
        break;
    }
    return result;
  }

  public void refreshAllTables() {
    container.invalidate();
    container.validate();
    container.repaint();
    columnPanel.refreshTable();
    rowPanel.refreshTable();
    componentPanel.refreshTable();
  }

}
