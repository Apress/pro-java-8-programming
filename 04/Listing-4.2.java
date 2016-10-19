import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPress extends JFrame {

public static void main(String[] args) {
  ButtonPress bp = new ButtonPress();
  bp.setSize(400, 300);
  bp.setVisible(true);
}

public ButtonPress() {
  JMenuBar jmb = new JMenuBar();
  JMenu menu = new JMenu("Execute");
  jmb.add(menu);
  JMenuItem jmi = new JMenuItem("Database Query");
  menu.add(jmi);
  jmi.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
      SwingWorker<Object,Object> worker =
              new SwingWorker<Object,Object>() {
        public Object doInBackground() {
          return performDatabaseQuery();
        }
     };
     Thread t = new Thread(worker);
     t.start();
    }
  });
  setJMenuBar(jmb);
}

private Object performDatabaseQuery() {


  // Simulate long-running database query
  try {
    Thread.sleep(50000);
  } catch (Exception e) {}
  ;
  return null;
}

}
