Listing 9-3. Enhancing ImageSelection
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.image.*;
import java.io.*;
import com.sun.image.codec.jpeg.*;

public class ImageSelection implements Transferable, ClipboardOwner{

  private ImageData imageData;

  public final static DataFlavor IMAGE_DATA_FLAVOR =
    new DataFlavor (ImageData.class, "Image Data");

  public final static DataFlavor JPEG_MIME_FLAVOR =
    new DataFlavor ("image/jpeg", "JPEG Image Data");

  private final static DataFlavor [] flavors = {
    JPEG_MIME_FLAVOR, IMAGE_DATA_FLAVOR
  };

  public ImageSelection(ImageData data) {
    imageData = data;
  }

  public Object getTransferData(DataFlavor flavor)
          throws java.io.IOException, UnsupportedFlavorException {
    if (flavor.equals(IMAGE_DATA_FLAVOR)) {
      return imageData;
    } else if (flavor.equals(JPEG_MIME_FLAVOR)) {
      return getJPEGInputStream();
    }
    throw new UnsupportedFlavorException(flavor);
  }

  private InputStream getJPEGInputStream() throws IOException {
    int width = imageData.getWidth();
    int height = imageData.getHeight();
    MemoryImageSource mis = new MemoryImageSource(width, height,
            imageData.getPixelData(), 0, width);
    BufferedImage bi =
      new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
    Graphics2D g2d = bi.createGraphics();
    Image img = Toolkit.getDefaultToolkit().createImage(mis);
    g2d.drawImage(img, 0, 0, null);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    JPEGImageEncoder jie = JPEGCodec.createJPEGEncoder(baos);
    jie.encode(bi);
    baos.close();
    return new ByteArrayInputStream(baos.toByteArray());
  }

  public DataFlavor [] getTransferDataFlavors() {
    return flavors;
  }

  public boolean isDataFlavorSupported(DataFlavor flavor) {
    for (int i = 0; i < flavors.length; i++) {
      if (flavor.equals(flavors[i])) {
        return true;
      }
    }
    return false;
  }

  public void lostOwnership(Clipboard cb, Transferable t) {}

}