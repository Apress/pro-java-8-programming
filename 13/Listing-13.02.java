import java.util.*;
import javax.swing.*;

public class MyResources extends ListResourceBundle {

  private static Object[][] resources = {
      {"WhatIsJava", "What is Java?"},
      {"JavaIsLang", "Is Java an object-oriented " +
          "programming language"},
      {"LabelYes", "Yes"},
      {"LabelNo", "No"},
      {"FlagIcon", new ImageIcon("flags/unitedstates.gif")}
  };

  public Object[][] getContents() {
    return resources;
  }

}
