import java.util.*;
import javax.swing.*;

public class ToolTipTable extends JTable {

  private final Map<String, String> columnTips = new HashMap<String, String>();

  public ToolTipTable(TableValues model) {
    super(model);
  }

  public void setColumnToolTip(String columnName, String toolTipText) {
    columnTips.put(columnName, toolTipText);
  }

  public String getColumnToolTip(String columnName) {
    return columnTips.get(columnName);
  }

}
