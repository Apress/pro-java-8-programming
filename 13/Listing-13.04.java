import java.util.*;
import javax.swing.*;

public class MyResources_de_CH extends ListResourceBundle {

  private static Object[][] resources = {
    {"FlagIcon", new ImageIcon("flags/switzerland.gif")}
  };

  public Object[][] getContents() {
    return resources;
  }
}
