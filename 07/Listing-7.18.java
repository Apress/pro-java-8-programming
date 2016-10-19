public RowAdder() {
  Container pane = getContentPane();
  pane.setLayout(new BorderLayout());
  tableData = new SimpleModel();
  table = new JTable(tableData);
  table.getColumnModel().getColumn(0).setPreferredWidth(300);
  table.addComponentListener(new TableScroller());
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
class TableScroller extends ComponentAdapter {

  public void componentResized(ComponentEvent event) {
    int lastRow = tableData.getRowCount() - 1;
    int cellTop = table.getCellRect(lastRow, 0, true).y;
    JScrollPane jsp = (JScrollPane)SwingUtilities.getAncestorOfClass(
      JScrollPane.class, table);
    JViewport jvp = jsp.getViewport();
    int portHeight = jvp.getSize().height;
    int position = cellTop - (portHeight - table.getRowHeight() -
        table.getRowMargin());
    if (position >= 0) {
      jvp.setViewPosition(new Point(0, position));
    }
  }
}
