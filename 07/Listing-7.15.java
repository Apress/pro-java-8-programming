import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class FrozenColumnHeader extends JScrollPane {

  private JTable mainTable;
  private JTable headerTable;
  private int columnCount;

  public FrozenColumnHeader(JTable table, int columns) {
    super();
    mainTable = table;
    headerTable = new JTable(mainTable.getModel());
    getViewport().setView(headerTable);
    columnCount = columns;
  }

  public void addNotify() {
    TableColumn column;
    super.addNotify();
    TableColumnModel mainModel = mainTable.getColumnModel();
    TableColumnModel headerModel = new DefaultTableColumnModel();
    int frozenWidth = 0;
    for (int i = 0; i < columnCount; i++) {
      column = mainModel.getColumn(0);
      mainModel.removeColumn(column);
      headerModel.addColumn(column);
      frozenWidth += column.getPreferredWidth() + headerModel.getColumnMargin();
  }
  headerTable.setColumnModel(headerModel);
  Component columnHeader = getColumnHeader().getView();
  getColumnHeader().setView(null);
  JScrollPane mainScrollPane = (JScrollPane)SwingUtilities.getAncestorOfClass(
    JScrollPane.class, mainTable);
  mainScrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, columnHeader);
  headerTable.setPreferredScrollableViewportSize(
    new Dimension(frozenWidth, 0));
 }
}