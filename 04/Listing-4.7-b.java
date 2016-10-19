private void buildLayout() {
  JLabel label;
  setLayout(new GridBagLayout());
  GridBagConstraints constraints = new GridBagConstraints();
  constraints.fill = GridBagConstraints.HORIZONTAL;
  constraints.insets = new Insets(5, 10, 5, 10);

  constraints.gridx = 0;
  label = new JLabel("URL:", JLabel.LEFT);
  add(label, constraints);

  label = new JLabel("Complete:", JLabel.LEFT);
  add(label, constraints);

  label = new JLabel("Downloaded:", JLabel.LEFT);
  add(label, constraints);

  constraints.gridx = 1;
  constraints.gridwidth = GridBagConstraints.REMAINDER;
  constraints.weightx = 1;
  urlLabel = new JLabel(downloadURL.toString());
  add(urlLabel, constraints);

  progressBar = new JProgressBar(0, fileSize);
  progressBar.setStringPainted(true);
  add(progressBar, constraints);

  constraints.gridwidth = 1;
  completeLabel = new JLabel(Integer.toString(bytesRead));
  add(completeLabel, constraints);

  constraints.gridx = 2;
  constraints.weightx = 0;
  constraints.anchor = GridBagConstraints.EAST;
  label = new JLabel("Size:", JLabel.LEFT);
  add(label, constraints);

  constraints.gridx = 3;
  constraints.weightx = 1;
  sizeLabel = new JLabel(Integer.toString(fileSize));
  add(sizeLabel, constraints);
}
