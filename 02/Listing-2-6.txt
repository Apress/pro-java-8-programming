public class FontPropertiesFrame extends SampleTextFrame {

  public static void main(String[] args) {
    FontPropertiesFrame fpf = new FontPropertiesFrame();
    fpf.setVisible(true);
  }

  public FontPropertiesFrame() {
    super();
    FontPropertiesPanel fontPanel = (FontPropertiesPanel)propertiesPanel;
    displayArea.setFont(fontPanel.getSelectedFont());
    fontPanel.setFontListener(this);
  }

  protected void createComponents() {
    propertiesPanel = new FontPropertiesPanel();
    super.createComponents ();
  }

}
