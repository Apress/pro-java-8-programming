import java.awt.*;
import javax.swing.*;

public class GridBagCellPanel extends JPanel {

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    LayoutManager manager = getLayout();
    if ((manager != null) && (manager instanceof GridBagLayout)) {
      GridBagLayout layout = (GridBagLayout)manager;
      g.setColor(getForeground());
      Point p = layout.getLayoutOrigin();
      int[][] sizes = layout.getLayoutDimensions();
      int[] colWidths = sizes[0];
      int[] rowHeights = sizes[1];
      int width, height;
      int xpos = p.x;
      int ypos;
      for (int x = 0; x < colWidths.length; x++) {
        ypos = p.y;
        width = colWidths[x];
        for (int y = 0; y < rowHeights.length; y++) {
          height = rowHeights[y];
          g.drawRect(xpos, ypos, width - 1, height - 1);
          g.drawRect(xpos + 1, ypos + 1, width - 3,
              height - 3);
          ypos += height;
        }
        xpos += width;
      }
    }
  }

}
