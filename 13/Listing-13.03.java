import java.util.*;
import javax.swing.*;

public class MyResources_de extends ListResourceBundle {

  private static Object[][] resources = {
      {"WhatIsJava", "Was ist Java?"},
      {"JavaIsLang", "Ist Java eine objektorientierte " +
          "Programmiersprache?"},
      {"LabelYes", "Ja"},
      {"LabelNo", "Nein"},
      {"FlagIcon", new ImageIcon("flags/germany.gif")}
  };

  public Object[][] getContents() {
    return resources;
  }
}
