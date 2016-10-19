public class SimpleTableTest extends JFrame {

  private ToolTipTable table;

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
    table = new ToolTipTable(tv);
    table.setColumnToolTip("Date of Birth", "Date on which the person was born");
