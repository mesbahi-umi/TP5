package org.example.Presentation.Views;

import javax.swing.*;
import java.awt.*;

public class DatabaseManagementInterface extends JFrame {

    public JTextField nameTextField, prenomTextField, dateTextField, telTextField;
    public JCheckBox tennisCheckBox, squashCheckBox; // Add more as needed
    public JRadioButton maleRadioButton, femaleRadioButton;
    public JButton addButton; // Add more buttons if needed
    public ButtonGroup genderGroup;
    public JPanel leftPanel;
    public JPanel rightPanel;


    public DatabaseManagementInterface() {
        // Set up the window
        setTitle("Gestion d'une base de données");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500); // Adjust the size as needed

        // Create the panels
        leftPanel = new JPanel();
        rightPanel = new JPanel();

        // Initialize the components
        nameTextField = new JTextField();
        prenomTextField = new JTextField();
        dateTextField = new JTextField();
        telTextField = new JTextField();

        tennisCheckBox = new JCheckBox("Tennis");
        squashCheckBox = new JCheckBox("Squash"); // Initialize more checkboxes as needed
        maleRadioButton = new JRadioButton("Homme");
        femaleRadioButton = new JRadioButton("Femme");
        addButton = new JButton("Ajouter energi"); // Initialize more buttons as needed


        // Configure the components (set their bounds and add them to the frame)
        configureComponents();

        // Center the window and make it visible
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configureComponents() {
        // Set the layout of the main frame to GridBagLayout
        setLayout(new GridBagLayout());

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
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        // black background for left panel
        leftPanel.setBackground(Color.BLACK);
        // yellow background for right panel
        rightPanel.setBackground(Color.YELLOW);

        // add labels and text fields to the left panel
        leftPanel.add(new JLabel("Nom"));
        leftPanel.add(nameTextField);
        leftPanel.add(new JLabel("Prenom"));
        leftPanel.add(prenomTextField);
        leftPanel.add(new JLabel("Date de naissance"));
        leftPanel.add(dateTextField);
        leftPanel.add(new JLabel("Telephone"));
        leftPanel.add(telTextField);

        genderGroup = new ButtonGroup(); // Group the radio buttons
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        leftPanel.add(maleRadioButton);
        leftPanel.add(femaleRadioButton);
        leftPanel.add(addButton);


        // add checkboxes to the right panel
        rightPanel.add(tennisCheckBox);
        rightPanel.add(squashCheckBox);


    }

    public static void main(String[] args) {
        new DatabaseManagementInterface();
    }
}