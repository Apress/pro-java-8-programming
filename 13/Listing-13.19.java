import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class EditPersonList extends JFrame {

  private Vector personList;
  private int currentIndex;

  private JButton addButton;
  private JButton deleteButton;
  private JButton clearButton;

  private JButton nextButton;
  private JButton previousButton;

  private PersonPanel personPanel;

  private JMenu localeMenu;

  private static ResourceBundle resources =
      ResourceBundle.getBundle("PeopleResources");

  public static void main(String[] args) throws Exception {
    EditPersonList epl = new EditPersonList(resources.getString("FrameTitle"));
    epl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    epl.setVisible(true);
  }

  public EditPersonList(String title) throws Exception {
    super(title);
    buildLayout();
    File f = new File("people.ser");
    if (f.exists()) {
      FileInputStream fis = new FileInputStream(f);
      ObjectInputStream ois = new ObjectInputStream(fis);
      personList = (Vector)(ois.readObject());
    }
    else {
      personList = new Vector();
    }
    currentIndex = 0;
    displayCurrentPerson();
    pack();
  }

  private void buildLayout() {
    JMenuItem menuItem;

    Container pane = getContentPane();
    personPanel = new PersonPanel();
    pane.add(personPanel, BorderLayout.CENTER);
    pane.add(getButtonPanel(), BorderLayout.SOUTH);

    JMenuBar jmb = new JMenuBar();
    localeMenu = new JMenu(resources.getString("Menu_Locale"));
    jmb.add(localeMenu);

    ButtonGroup group = new ButtonGroup();

    menuItem = new JRadioButtonMenuItem(
        Locale.ENGLISH.getDisplayName(Locale.ENGLISH), true);
    localeMenu.add(menuItem);
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        resources = ResourceBundle.getBundle(
            "PeopleResources", Locale.ENGLISH);
        updateLabels();
        pack();
      }
    });
    group.add(menuItem);

    menuItem = new JRadioButtonMenuItem(
        Locale.GERMAN.getDisplayName(Locale.GERMAN));
    localeMenu.add(menuItem);

    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        resources = ResourceBundle.getBundle(
            "PeopleResources", Locale.GERMAN);
        updateLabels();
        pack();
      }
    });
    group.add(menuItem);

    setJMenuBar(jmb);
  }

  private JPanel getButtonPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 5, 10, 0));

    addButton = new JButton(resources.getString("Button_Label_Add"));
    panel.add(addButton);
    clearButton = new JButton(resources.getString("Button_Label_Clear"));
    panel.add(clearButton);
    deleteButton = new JButton(resources.getString("Button_Label_Delete"));
    panel.add(deleteButton);

    nextButton = new JButton(resources.getString("Button_Label_Next"));
    panel.add(nextButton);
    previousButton = new JButton(resources.getString("Button_Label_Previous"));
    panel.add(previousButton);

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Person p = new Person();
        if (personPanel.updatePerson(p)) {
          personList.addElement(p);
          currentIndex = personList.size() - 1;
          displayCurrentPerson();
        }
        savePersonList();
      }
    });

    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        personPanel.clear();
      }
    });

    deleteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        personList.removeElementAt(currentIndex);
        if (currentIndex >= personList.size()) {
          currentIndex = personList.size() - 1;
        }
        savePersonList();
      displayCurrentPerson();
      }
    });

    nextButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        currentIndex++;
        displayCurrentPerson();
      }
    });

    previousButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        currentIndex--;
        displayCurrentPerson();
      }
    });

    return panel;
  }

  private void displayCurrentPerson() {
    if ((currentIndex >= 0) && (currentIndex < personList.size())) {
      personPanel.displayPerson((Person)
                 (personList.elementAt(currentIndex)));
    }
    else {
      personPanel.clear();
    }
    previousButton.setEnabled(currentIndex > 0);
    nextButton.setEnabled(currentIndex < personList.size() - 1);
  }

  private void savePersonList() {
    File f = new File("people.ser");
    try {
      FileOutputStream fos = new FileOutputStream(f);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(personList);
      oos.close();
    } catch (IOException ioe) {};
  }

  private void updateLabels() {
    setTitle(resources.getString("FrameTitle"));
    personPanel.updateLabelText();
    localeMenu.setText(resources.getString("Menu_Locale"));
    addButton.setText(resources.getString("Button_Label_Add"));
    clearButton.setText(resources.getString("Button_Label_Clear"));
    deleteButton.setText(resources.getString("Button_Label_Delete"));
    nextButton.setText(resources.getString("Button_Label_Next"));
    previousButton.setText(resources.getString(
        "Button_Label_Previous"));
  }

  class PersonPanel extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField addressField;
    private JTextField dobField;

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel addressLabel;
    private JLabel dateOfBirthLabel;

    public PersonPanel() {
      buildLayout();
    }

    private void buildLayout() {
//      JLabel label;
      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.weightx = 1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(5, 10, 5, 10);

      gbc.gridy = 0;
      firstNameLabel = new JLabel(resources.getString(
          "Label_Text_FirstName"), JLabel.LEFT);
      add(firstNameLabel, gbc);

      firstNameField = new JTextField(10);
      add(firstNameField, gbc);
      lastNameLabel = new JLabel(resources.getString(
          "Label_Text_LastName"), JLabel.LEFT);
      add(lastNameLabel, gbc);

      lastNameField = new JTextField(10);
      add(lastNameField, gbc);

      gbc.gridy++;
      addressLabel = new JLabel(resources.getString(
          "Label_Text_Address"), JLabel.LEFT);
      add(addressLabel, gbc);

      gbc.gridwidth = GridBagConstraints.REMAINDER;
      addressField = new JTextField(10);
      add(addressField, gbc);

      gbc.gridwidth = 1;
      gbc.gridy++;
      dateOfBirthLabel = new JLabel(resources.getString(
          "Label_Text_DOB"), JLabel.LEFT);
      add(dateOfBirthLabel, gbc);

      dobField = new JTextField(10);
      add(dobField, gbc);
    }

    public void clear() {
      firstNameField.setText("");
      lastNameField.setText("");
      addressField.setText("");
      dobField.setText("");
    }

    public void displayPerson(Person p) {
      firstNameField.setText(p.getFirstName());
      lastNameField.setText(p.getLastName());
      addressField.setText(p.getAddress());
      DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT);
      dobField.setText(formatter.format(p.getDateOfBirth()));
    }

    public boolean updatePerson(Person p) {
      String firstName = firstNameField.getText();
      String lastName = lastNameField.getText();
      String address = addressField.getText();
      Date dateOfBirth = null;
      DateFormat parser = DateFormat.getDateInstance(DateFormat.SHORT);
      try {
        dateOfBirth = parser.parse(dobField.getText());
      }
      catch (ParseException pe) {
        JOptionPane.showMessageDialog(this, pe.getMessage(),
            resources.getString("Dialog_Title_Invalid_Date"),
            JOptionPane.ERROR_MESSAGE);
        return false;
      }
      p.setFirstName(firstName);
      p.setLastName(lastName);
      p.setAddress(address);
      p.setDateOfBirth(dateOfBirth);
      return true;
    }

    public void updateLabelText() {
      firstNameLabel.setText(resources.getString("Label_Text_FirstName"));
      lastNameLabel.setText(resources.getString("Label_Text_LastName"));
      addressLabel.setText(resources.getString("Label_Text_Address"));
      dateOfBirthLabel.setText(resources.getString("Label_Text_DOB"));
    }

  }
}
