public SimpleTableTest() {
  Container pane = getContentPane();
  pane.setLayout(new BorderLayout());
  TableValues tv = new TableValues();
  table = new JTable(tv);
  table.setRowSelectionAllowed(false);
  table.setColumnSelectionAllowed(true);
  TableColumnModel tcm = table.getColumnModel();
  TableColumn tc = tcm.getColumn(TableValues.GENDER);
  tc.setCellRenderer(new GenderRenderer());
  tc.setCellEditor(new GenderEditor());
  MultiLineHeaderRenderer mlhr = new MultiLineHeaderRenderer();
  tc = tcm.getColumn(TableValues.ACCOUNT_BALANCE);
  tc.setHeaderRenderer(mlhr);
  JTableHeaderToolTips jthtt =
      new JTableHeaderToolTips(table.getColumnModel());
  jthtt.setToolTips(new String[] {"Customer's First Name",
      "Customer's Last Name", "Customer's Date of Birth",
      "Customer's Account Balance", "Customer's Gender"});
  table.setTableHeader(jthtt);
  table.setDefaultRenderer(Float.class, new CurrencyRenderer());
  JScrollPane jsp = new JScrollPane(table);
  JViewport jvp = new JViewport();
  jvp.setView(new RowNumberHeader(table));
  jsp.setRowHeader(jvp);
  pane.add(jsp, BorderLayout.CENTER);
  addHeaderListener();
}
