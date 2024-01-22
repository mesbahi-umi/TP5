package org.example.Presentation.Views;

import javax.swing.*;
import java.awt.*;

public class DatabaseManagementInterface {

    public static void main(String[] args) {
        // Create the frame.
        JFrame frame = new JFrame("Gestion d'une base de données");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        // Create labels and text fields for form inputs.
        JLabel nameLabel = new JLabel("Nom");
        nameLabel.setBounds(10, 10, 80, 25);
        frame.add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(100, 10, 160, 25);
        frame.add(nameTextField);

        // Repeat the above two steps for all form inputs...
        // For brevity, only one label and text field pair is shown.

        // Create checkboxes for the activities.
        JCheckBox tennisCheckBox = new JCheckBox("Tennis");
        tennisCheckBox.setBounds(300, 10, 100, 25);
        frame.add(tennisCheckBox);

        // Repeat for other checkboxes...

        // Create radio buttons for gender selection.
        JRadioButton maleRadioButton = new JRadioButton("Homme");
        maleRadioButton.setBounds(10, 200, 80, 25);
        frame.add(maleRadioButton);

        JRadioButton femaleRadioButton = new JRadioButton("Femme");
        femaleRadioButton.setBounds(100, 200, 80, 25);
        frame.add(femaleRadioButton);

        // Group the radio buttons.
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Create buttons for form operations.
        JButton addButton = new JButton("Ajouter energi");
        addButton.setBounds(10, 300, 140, 25);
        frame.add(addButton);

        // Repeat for other buttons...

        // Finally, make the frame visible.
        frame.setVisible(true);
    }
}

