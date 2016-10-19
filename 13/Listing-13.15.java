import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class IteratorTest extends JPanel {

  private JComboBox localeButton;

  private JTextArea textArea;

  private JRadioButton charButton;
  private JRadioButton wordButton;
  private JRadioButton lineButton;
  private JRadioButton sentButton;

  private JLabel countLabel;
  private JButton refreshButton;

  private JList itemList;
  // Create a window for the Iterator test
  // and make sure that later components will fit
  public static void main(String[] args) {
    JFrame f = new JFrame("Iterator Test");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(new IteratorTest());
    f.pack();
    f.setVisible(true);
  }

  public IteratorTest() {
    buildLayout();
    refreshDisplay();
  }

  private void buildLayout() {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    // Set up the contents of the Locale combo box
    gbc.gridx = 0;
    gbc.gridy = 0;
    localeButton = new JComboBox(Locale.getAvailableLocales());
    localeButton.setRenderer(new LocaleListCellRenderer());
    localeButton.setSelectedItem(Locale.getDefault());
    add(localeButton, gbc);

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 1;

    // Set up the input area panel
    gbc.gridy++;
    gbc.weighty = 1;
    textArea = new JTextArea(5, 20);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    JScrollPane jsp = new JScrollPane(textArea,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    add(jsp, gbc);

    // Add a panel for the choice buttons
    gbc.gridy++;
    gbc.weighty = 0;
    add(getTypePanel(), gbc);

    // Add a panel for the refresh button and the count label
    gbc.gridy++;
    add(getCountPanel(), gbc);

    // Add a panel for the parsed output
    gbc.gridy++;
    gbc.weighty = 1;
    itemList = new JList();
    add(new JScrollPane(itemList), gbc);
  }

  // Create the panel for the choice buttons
  private JPanel getTypePanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 2, 20, 0));
    charButton = new JRadioButton("Character", true);
    panel.add(charButton);
    wordButton = new JRadioButton("Word");
    panel.add(wordButton);
    lineButton = new JRadioButton("Line");
    panel.add(lineButton);
    sentButton = new JRadioButton("Sentence");
    panel.add(sentButton);

    // Add the buttons to a group
    ButtonGroup group = new ButtonGroup();
    group.add(charButton);
    group.add(wordButton);
    group.add(lineButton);
    group.add(sentButton);
    return panel;
  }

  // Create a panel for the refresh button and the count label
  private JPanel getCountPanel() {
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Count:", JLabel.RIGHT);
    panel.add(label);
    countLabel = new JLabel("", JLabel.LEFT);
    Dimension size = panel.getPreferredSize();
    size.width = Math.min(size.width, 100);
    countLabel.setPreferredSize(size);
    panel.add(countLabel);

    // Add the refresh button
    refreshButton = new JButton("Refresh");
    refreshButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        refreshDisplay();
      }
    });
    panel.add(refreshButton);
    return panel;
  }

  private void refreshDisplay() {
    int startIndex, nextIndex;
    Vector items = new Vector();
    // Get the input text
    String msgText = textArea.getText();
    // Set the locale and prepare the iterator
    Locale locale = (Locale)(localeButton.getSelectedItem());
    BreakIterator iterator = null;
    // Work out which button is selected and set the iterator
    if (charButton.isSelected()) {
      iterator = BreakIterator.getCharacterInstance(locale);
    }
    else if (wordButton.isSelected()) {
      iterator = BreakIterator.getWordInstance(locale);
    }
    else if (lineButton.isSelected()) {
      iterator = BreakIterator.getLineInstance(locale);
    }
    else if (sentButton.isSelected()) {
      iterator = BreakIterator.getSentenceInstance(locale);
    }
    iterator.setText(msgText);
    startIndex = iterator.first();
    nextIndex = iterator.next();

    // Find the breaks in the input text
    // and add the substrings for output
    while (nextIndex != BreakIterator.DONE) {
      items.addElement(msgText.substring(startIndex, nextIndex));
      startIndex = nextIndex;
      nextIndex = iterator.next();
    }
    countLabel.setText(Integer.toString(items.size()));
    itemList.setListData(items);          // Output the parsed input
  }

  // Combo box to select the available locales
  class LocaleListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(
        JList list, Object value, int index,
        boolean isSelected, boolean hasFocus) {
      Locale locale = (Locale)(value);
      return super.getListCellRendererComponent(
          list, locale.getDisplayName(),
          index, isSelected, hasFocus);
    }
  }
}
