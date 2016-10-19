import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class ToolTipTable extends JTable {

  private final Map<String, String> columnTips = new HashMap<String, String>();

  public ToolTipTable(TableValues model) {
    super(model);
    createToolTipListener();
  }

  private void createToolTipListener() {
    JTableHeader header = getTableHeader();
    header.addMouseMotionListener(new MouseAdapter() {
      public void mouseMoved(MouseEvent event) {
          JTableHeader source = (JTableHeader)(event.getSource());
          int viewIndex = source.columnAtPoint(event.getPoint());
          String columnName = getColumnName(viewIndex);
          String toolTipText = getColumnToolTip(columnName);
          source.setToolTipText(toolTipText);
      }
    });
  }

  public void setColumnToolTip(String columnName, String toolTipText) {
    columnTips.put(columnName, toolTipText);
  }

  public String getColumnToolTip(String columnName) {
    return columnTips.get(columnName);
  }

}
