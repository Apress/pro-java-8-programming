import java.awt.*;
import javax.swing.*;

public class BoxPanel extends JPanel {

  public void paintChildren(Graphics g) {
    super.paintChildren(g);
    Dimension size = getSize();
    LayoutManager manager = getLayout();
    if ((manager != null) && (manager instanceof BoxLayout)) {
      BoxLayout layout = (BoxLayout)manager;
      //  There's currently no accessor method that allows
      //  us to determine the orientation (vertical or
      //  horizontal) used by a BoxLayout, so we'll hard-code
      //  this class to assume vertical orientation
      boolean vertical = true;
      if (vertical) {
        int axis = (int)(layout.getLayoutAlignmentX(this) *
            size.width);
        g.fillRect(axis - 1, 0, 3, size.height);
      }
      else {
        int axis = (int)(layout.getLayoutAlignmentY(this) *
            size.height);
        g.fillRect(0, axis - 1, size.width, 3);
      }
    }
  }

}
