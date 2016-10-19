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

    public static void main(String[] args) throws Exception {
      EditPersonList epl = new EditPersonList("Edit List");
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
      Container pane = getContentPane();
      personPanel = new PersonPanel();
      pane.add(personPanel, BorderLayout.CENTER);
      pane.add(getButtonPanel(), BorderLayout.SOUTH);
    }
  
    private JPanel getButtonPanel() {
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(1, 5, 10, 0));
      addButton = new JButton("Add");
      panel.add(addButton);
      clearButton = new JButton("Clear");
      panel.add(clearButton);
      deleteButton = new JButton("Delete");
      panel.add(deleteButton);
  
      nextButton = new JButton("Next");
      panel.add(nextButton);
      previousButton = new JButton("Previous");
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
  
    class PersonPanel extends JPanel {
      private JTextField firstNameField;
      private JTextField lastNameField;
      private JTextField addressField;
      private JTextField dobField;
  
      public PersonPanel() {
        buildLayout();
      }
  
    private void buildLayout() {
      JLabel label;
      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.weightx = 1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(5, 10, 5, 10);
  
      gbc.gridy = 0;
      label = new JLabel("First name:", JLabel.LEFT);
      add(label, gbc);
  
      firstNameField = new JTextField(10);
      add(firstNameField, gbc);
  
      label = new JLabel("Last name:", JLabel.LEFT);
      add(label, gbc);
  
      lastNameField = new JTextField(10);
      add(lastNameField, gbc);
  
      gbc.gridy++;
      label = new JLabel("Address:", JLabel.LEFT);
      add(label, gbc);
  
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      addressField = new JTextField(10);
      add(addressField, gbc);
  
      gbc.gridwidth = 1;
      gbc.gridy++;
      label = new JLabel("Date of Birth:", JLabel.LEFT);
      add(label, gbc);
  
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
            "Invalid Date",
            JOptionPane.ERROR_MESSAGE);
        return false;
      }
      p.setFirstName(firstName);
      p.setLastName(lastName);
      p.setAddress(address);
      p.setDateOfBirth(dateOfBirth);
      return true;
    }
  }
}
