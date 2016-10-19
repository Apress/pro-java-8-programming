public class ImageData implements java.io.Serializable {

  private int width;
  private int height;
  private int[] pixelData;

  public ImageData(int width, int height, int[] pixels) {
    this.width = width;
    this.height = height;
    pixelData = pixels;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int[] getPixelData() {
    return pixelData;
  }

}