package org.example.Presentation.Views;

import org.example.Presentation.controllers.AddAdherentAction;

import javax.swing.*;
import java.awt.*;

/* CREATE TABLE IF NOT EXISTS Adherent (
    AdherentID INT AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(255),
    Prenom VARCHAR(255),
    DateInscription DATE,
    Telephone VARCHAR(20),
    Login VARCHAR(255),
    MotDePasse VARCHAR(255),
    MontantAPayer DECIMAL(10, 2),
    Adresse TEXT,
    Sexe ENUM('Homme', 'Femme'),
    -- Assuming the sports are boolean indicating whether a member is interested in them
    Tennis BOOLEAN,
    Squash BOOLEAN,
    Natation BOOLEAN,
    Athletiesme BOOLEAN,
    Randomnee BOOLEAN,
    Foot BOOLEAN,
    Basket BOOLEAN,
    Volley BOOLEAN,
    pelanque BOOLEAN
);
 */
public class DatabaseManagementInterface extends JFrame {

    /* text fields*/
    public JTextField nomTextField, prenomTextField, dateInscriptionTextField;
    public JTextField telTextField, loginTextField,montantAPayerTextField;
    public JPasswordField passwordTextField;
    public JTextArea addressTextArea;

    /* checkboxes */
    public JCheckBox tennisCheckBox, squashCheckBox, natationCheckBox, athletiesmeCheckBox;
    public JCheckBox randomneeCheckBox, footCheckBox, basketCheckBox, volleyCheckeBox, pelanqueCheckBox; // Add more as needed

    /* radiobutton */
    public JRadioButton maleRadioButton, femaleRadioButton;
    public ButtonGroup genderGroup;

    /* buttons */
    public JButton addAdherentButton, addTableButton, updateAdherentButton;
    public JButton deleteAdherentButton, showAdherentTableWithPreStatmButton, exitButton;

    public JPanel leftPanel;
    public JPanel inputsPanle;
    public JPanel rightPanel;
    public JPanel genderPanel;
    public JPanel buttonsPanel;


    public DatabaseManagementInterface() {
        // Set up the window
        setTitle("Gestion d'une base de données");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 400); // Adjust the size as needed


        // Initialize the components

        /* text Fields*/
        nomTextField = new JTextField("mesbahi");
        prenomTextField = new JTextField("mohamed");
        dateInscriptionTextField = new JTextField();
        dateInscriptionTextField.setToolTipText("dd/mm/yyyy");
        dateInscriptionTextField.setText("01/01/2020");
        telTextField = new JTextField("0666666666");
        loginTextField = new JTextField("mesbahi");
        passwordTextField = new JPasswordField("123456");
        montantAPayerTextField = new JTextField("100");
        addressTextArea = new JTextArea("MLY IDRISS 2, Rue 2, Tanger");

        /* checkBoxes */
        tennisCheckBox = new JCheckBox("Tennis");
        squashCheckBox = new JCheckBox("Squash");
        natationCheckBox = new JCheckBox("Natation");
        athletiesmeCheckBox = new JCheckBox("Athletiesme");
        randomneeCheckBox = new JCheckBox("Randomnée");
        footCheckBox = new JCheckBox("Foot");
        basketCheckBox = new JCheckBox("Basket");
        volleyCheckeBox = new JCheckBox("Volley");
        pelanqueCheckBox = new JCheckBox("Pelanque");


        /* radioButtons */
        maleRadioButton = new JRadioButton("Homme");
        femaleRadioButton = new JRadioButton("Femme");

        /* buttons */
        addAdherentButton = new JButton("Ajouter enregistrement");
        addTableButton = new JButton("Ajouter une table");
        updateAdherentButton = new JButton("Modifier");
        deleteAdherentButton = new JButton("Supprimer");
        showAdherentTableWithPreStatmButton = new JButton("Afficher table avec Pre sta");
        exitButton = new JButton("Fermer");

        // Create the panels
        leftPanel = new JPanel();
        inputsPanle = new JPanel();
        rightPanel = new JPanel();
        genderPanel = new JPanel();
        buttonsPanel = new JPanel();

        // Configure the components (set their bounds and add them to the frame)
        configureComponents();

        // Center the window and make it visible
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configureComponents() {
        // Set the layout of the main frame to GridBagLayout
        setLayout(new GridBagLayout());

        // set resizable to false
        setResizable(false);
        // Create GridBagConstraints for leftPanel
        GridBagConstraints leftPanelConstraints = new GridBagConstraints();
        leftPanelConstraints.gridx = 0; // Start at column 0
        leftPanelConstraints.gridy = 0; // Start at row 0
        leftPanelConstraints.weightx = 0.75; // 75% of width
        leftPanelConstraints.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically

        // Add leftPanel to the frame with constraints
        add(leftPanel, leftPanelConstraints);

        // Create GridBagConstraints for rightPanel
        GridBagConstraints rightPanelConstraints = new GridBagConstraints();
        rightPanelConstraints.gridx = 1; // Start at column 1
        rightPanelConstraints.gridy = 0; // Start at row 0
        rightPanelConstraints.weightx = 0.25; // 25% of width
        rightPanelConstraints.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically

        // Add rightPanel to the frame with constraints
        add(rightPanel, rightPanelConstraints);

        // add BoxLayout layout to the panels
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        inputsPanle.setLayout(new GridLayout(13,1));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        genderPanel.setLayout(new FlowLayout());
        buttonsPanel.setLayout(new FlowLayout());


        // add labels and text fields to the left panel
        inputsPanle.add(new JLabel("Nom"));
        inputsPanle.add(nomTextField);
        inputsPanle.add(new JLabel("Prenom"));
        inputsPanle.add(prenomTextField);
        inputsPanle.add(new JLabel("Date d'inscription"));
        inputsPanle.add(dateInscriptionTextField);
        inputsPanle.add(new JLabel("Telephone"));
        inputsPanle.add(telTextField);
        inputsPanle.add(new JLabel("Login"));
        inputsPanle.add(loginTextField);
        inputsPanle.add(new JLabel("Mot de passe"));
        inputsPanle.add(passwordTextField);
        inputsPanle.add(new JLabel("Adresse"));
        addressTextArea.setPreferredSize(new Dimension(200, 100));
        leftPanel.add(inputsPanle);
        leftPanel.add(addressTextArea);

        // Group the radio buttons
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        maleRadioButton.setSelected(true);
        // add to genderPanel
        genderPanel.add(new JLabel("Sexe"));
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);

        // add genderPanel to the left panel
        leftPanel.add(genderPanel);

        // add buttons
        buttonsPanel.add(addAdherentButton);
        buttonsPanel.add(addTableButton);
        buttonsPanel.add(updateAdherentButton);
        buttonsPanel.add(deleteAdherentButton);
        buttonsPanel.add(showAdherentTableWithPreStatmButton);
        buttonsPanel.add(exitButton);

        // add buttonsPanel to the left panel
        leftPanel.add(buttonsPanel);

        // add checkboxes to the right panel
        rightPanel.add(tennisCheckBox);
        rightPanel.add(squashCheckBox);
        rightPanel.add(natationCheckBox);
        rightPanel.add(athletiesmeCheckBox);
        rightPanel.add(randomneeCheckBox);
        rightPanel.add(footCheckBox);
        rightPanel.add(basketCheckBox);
        rightPanel.add(volleyCheckeBox);
        rightPanel.add(pelanqueCheckBox);

        configureActions();

    }
    private void configureActions() {
        addAdherentButton.addActionListener(new AddAdherentAction(this));
    }

    public static void main(String[] args) {
        new DatabaseManagementInterface();
    }

    public String getNom() {
        return nomTextField.getText();
    }
    public String getPrenom() {
        return prenomTextField.getText();
    }
    public String getDateInscription() {
        return dateInscriptionTextField.getText();
    }
    public String getTel() {
        return telTextField.getText();
    }
    public String getLogin() {
        return loginTextField.getText();
    }
    public String getPassword() {
        return passwordTextField.getText();
    }
    public String getAddresse() {
        return addressTextArea.getText();
    }


    public String getSexe() {
        if (maleRadioButton.isSelected()) {
            return "Homme";
        } else if (femaleRadioButton.isSelected()) {
            return "Femme";
        } else {
            return null;
        }
    }

    public void showMessageDialog(String adherentAddedSuccessfully) {
        JOptionPane.showMessageDialog(this, adherentAddedSuccessfully);
    }

    public void resetAllFields() {
        nomTextField.setText("");
        prenomTextField.setText("");
        dateInscriptionTextField.setText("");
        telTextField.setText("");
        loginTextField.setText("");
        passwordTextField.setText("");
        montantAPayerTextField.setText("");
        addressTextArea.setText("");

        tennisCheckBox.setSelected(false);
        squashCheckBox.setSelected(false);
        natationCheckBox.setSelected(false);
        athletiesmeCheckBox.setSelected(false);
        randomneeCheckBox.setSelected(false);
        footCheckBox.setSelected(false);
        basketCheckBox.setSelected(false);
        volleyCheckeBox.setSelected(false);
        pelanqueCheckBox.setSelected(false);

    }

    public boolean inputsValide() {
        return !nomTextField.getText().equals("") &&
                !prenomTextField.getText().equals("") &&
                !dateInscriptionTextField.getText().equals("") &&
                !telTextField.getText().equals("") &&
                !loginTextField.getText().equals("") &&
                !passwordTextField.getText().equals("") &&
                !montantAPayerTextField.getText().equals("") &&
                !addressTextArea.getText().equals("");
    }
}