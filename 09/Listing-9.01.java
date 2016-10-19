import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class ImageEditor extends JPanel {

  public final static int LINE_WIDTH = 2;

  private ImageIcon icon;
  private Point start = new Point(0, 0);
  private Point finish = new Point(0, 0);
  private Point pastePoint;

  private JPopupMenu popupMenu;
  private AbstractAction cutAction;
  private AbstractAction copyAction;
  private AbstractAction pasteAction;

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("You must specify the name of an image file");
      return;
    }
    ImageEditor editor = new ImageEditor(args[0]);
    JFrame f = new JFrame(args[0]);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(editor);
    f.setSize(400, 300);
    f.setVisible(true);
  }

  public ImageEditor(String name) {
    super();
    buildPopupMenu();
    setBackground(Color.black);
    setLayout(new GridLayout(1, 1, 0, 0));
    icon = new ImageIcon(name);
    JLabel label = new JLabel(icon);
    label.setHorizontalAlignment(SwingConstants.LEFT);
    label.setVerticalAlignment(SwingConstants.TOP);
    label.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent event) {
        handleMouseDown(event);
      }
    });
    label.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent event) {
        handleMouseDrag(event);
      }
    });
    JScrollPane jsp = new JScrollPane(label);
    add(jsp);
  }

  private void handleMouseDown(MouseEvent event) {
    if ((event.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
      start = event.getPoint();
      finish = event.getPoint();
    }
    else if ((event.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
      displayPopupMenu(event.getPoint());
      pastePoint = event.getPoint();
    }
  }

  private void handleMouseDrag(MouseEvent event) {
    finish = event.getPoint();
    repaint();
  }

  private void buildPopupMenu() {
    popupMenu = new JPopupMenu();
    copyAction = new AbstractAction("Copy") {
      public void actionPerformed(ActionEvent event) {
        performCopy();
      }
    };
    popupMenu.add(copyAction);
    cutAction = new AbstractAction("Cut") {
      public void actionPerformed(ActionEvent event) {
        performCut();
      }
    };
    popupMenu.add(cutAction);
    pasteAction = new AbstractAction("Paste") {
      public void actionPerformed(ActionEvent event) {
        performPaste();
      }
    };
    popupMenu.add(pasteAction);
  }

  private void displayPopupMenu(Point p) {
    Clipboard cb = getToolkit().getSystemClipboard();
    Transferable t = cb.getContents(this);
    boolean isSelected = !(start.equals(finish));
    cutAction.setEnabled(isSelected);
    copyAction.setEnabled(isSelected);
    popupMenu.show(this, p.x, p.y);
  }

  private void performCopy() {
  }

  private void performCut() {
  }

  private void performPaste() {
  }

  private Rectangle getSelectedArea() {
    int width = finish.x - start.x;
    int height = finish.y - start.y;
    return new Rectangle(start.x, start.y, width, height);
  }

  private int[] getPixels(Rectangle area) {
    int[] pixels = new int[area.width * area.height];
    PixelGrabber pg = new PixelGrabber(icon.getImage(), area.x,
                                       area.y, area.width,
                                       area.height, pixels, 0,
                                       area.width);
    try {
      pg.grabPixels();
    } catch (Exception e) {};
    return pixels;
  }

  private void setPixels(int[] newPixels, Rectangle area) {
    int pixel;
    Image image = icon.getImage();
    int imageWidth = icon.getIconWidth();
    int imageHeight = icon.getIconHeight();
    int[] oldPixels = new int[imageWidth * imageHeight];
    PixelGrabber pg = new PixelGrabber(image, 0, 0, imageWidth,
                                       imageHeight, oldPixels, 0,
                                       imageWidth);
    try {
      pg.grabPixels();
    } catch (Exception e) {};
    for (int y = 0; y < area.height; y++) {
      if (imageHeight <= area.y + y) {
        break;
      }
      for (int x = 0; x < area.width; x++) {
        if (imageWidth <= area.x + x) {
          break;
        }
        oldPixels[((area.y + y) * imageWidth) + area.x + x] =
          newPixels[(area.width * y) + x];
      }
    }
    MemoryImageSource mis = new MemoryImageSource(imageWidth,
            imageHeight, oldPixels, 0, imageWidth);
    icon.setImage(createImage(mis));
    repaint();
  }

  public void paint(Graphics g) {
    super.paint(g);
    int width = finish.x - start.x;
    int height = finish.y - start.y;
    if ((width > 0) && (height > 0)) {
      g.setColor(Color.blue);
      for (int i = 0; i < LINE_WIDTH; i++) {
        g.drawRect(start.x + i, start.y + i, width, height);
      }
    }
  }

}