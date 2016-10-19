private JPanel getAddURLPanel() {
  JPanel panel = new JPanel();
  JLabel label = new JLabel("URL:");
  final JTextField textField = new JTextField(20);
  JButton downloadButton = new JButton("Download");
  ActionListener actionListener = new ActionListener() {

   public void actionPerformed(ActionEvent event) {
     if (createDownloader(textField.getText())) {
       textField.setText("");
       revalidate();
     }
    }
  };
  textField.addActionListener(actionListener);
  downloadButton.addActionListener(actionListener);
  JButton clearAll = new JButton("Cancel All");
  clearAll.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent event) {
       Downloader.cancelAllAndWait();
       listPanel.removeAll();
       revalidate();
       repaint();
    }
  });
  panel.add(label);
  panel.add(textField);
  panel.add(downloadButton);
  panel.add(clearAll);
  return panel;
}
