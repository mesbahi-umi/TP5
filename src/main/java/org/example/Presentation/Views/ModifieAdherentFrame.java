package org.example.Presentation.Views;

import org.example.Beans.Adherent;
import org.example.Business.DefaultServices;
import org.example.Constants.AdherentColumns;
import org.example.Presentation.controllers.ModifieAdherentAction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class ModifieAdherentFrame extends CustomedJFrame{
    // 1 - table to list all the adherents
    // 2 - user select a row and click on delete
    // 3 - table updated after the deletion
    // 4 - user can close the window
    JTable adherentsTable;
    public Adherent selectedAdherent;

    public JTextField nomTextField, prenomTextField, dateInscriptionTextField;
    public JTextField telTextField, loginTextField, montantAPayerTextField;
    public JPasswordField passwordTextField;
    public JTextArea addressTextArea;

    /* checkboxes */
    public JCheckBox tennisCheckBox, squashCheckBox, natationCheckBox, athletiesmeCheckBox;
    public JCheckBox randomneeCheckBox, footCheckBox, basketCheckBox, volleyCheckeBox, pelanqueCheckBox; // Add more as needed

    /* radiobutton */
    public JRadioButton maleRadioButton, femaleRadioButton;
    public ButtonGroup genderGroup;

    /* buttons */

    public JPanel leftPanel;
    public JPanel inputsPanle;
    public JPanel rightPanel;
    public JPanel genderPanel;
    public JPanel buttonsPanel;

    JButton modifyBtn;
    JButton closeBtn;
    public List<Adherent> adherentList;

    public ModifieAdherentFrame(String title, JFrame parentFrame) {
        super(title, parentFrame);
        setSize(800, 600);
        adherentsTable = new JTable();
        buttonsPanel = new JPanel();
        modifyBtn = new JButton("Modifier");
        closeBtn = new JButton("Fermer");

        /* text Fields*/
        nomTextField = new JTextField();
        prenomTextField = new JTextField();
        dateInscriptionTextField = new JTextField();
        dateInscriptionTextField.setToolTipText("dd/mm/yyyy");
        telTextField = new JTextField();
        loginTextField = new JTextField();
        passwordTextField = new JPasswordField();
        montantAPayerTextField = new JTextField();
        addressTextArea = new JTextArea();

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

        // Create the panels
        leftPanel = new JPanel();
        inputsPanle = new JPanel();
        rightPanel = new JPanel();
        genderPanel = new JPanel();
        buttonsPanel = new JPanel();

        configureUI();
        configureActions();

    }

    private void configureUI() {
        adherentList = DefaultServices.getInstance().getAllAdherents();
        DefaultTableModel tableModel = new DefaultTableModel(AdherentColumns.columnNames, 0);
        adherentsTable = new JTable(tableModel);
        for (Adherent member : adherentList) {
            Object[] rowData = {
                    member.adherentID,
                    member.nom,
                    member.prenom,
                    member.dateInscription,
                    member.telephone,
                    member.montantAPayer,
                    member.adresse,
                    member.sexe,
                    member.tennis,
                    member.squash,
                    member.natation,
                    member.athletisme,
                    member.randonnee,
                    member.foot,
                    member.basket,
                    member.volley,
                    member.pelanque
            };
            tableModel.addRow(rowData);
        }
        JScrollPane scrollPane = new JScrollPane(adherentsTable);
        add(scrollPane);
        // make the table uneditable
        adherentsTable.setDefaultEditor(Object.class, null);
        // center
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(modifyBtn);
        buttonsPanel.add(closeBtn);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
        add(buttonsPanel);

        JPanel container = new JPanel();
        // Set the layout of the container frame to GridBagLayout
        container.setLayout(new GridBagLayout());
        // Create GridBagConstraints for leftPanel
        GridBagConstraints leftPanelConstraints = new GridBagConstraints();
        leftPanelConstraints.gridx = 0; // Start at column 0
        leftPanelConstraints.gridy = 0; // Start at row 0
        leftPanelConstraints.weightx = 0.75; // 75% of width
        leftPanelConstraints.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically

        // Add leftPanel to the frame with constraints
        container.add(leftPanel, leftPanelConstraints);

        // Create GridBagConstraints for rightPanel
        GridBagConstraints rightPanelConstraints = new GridBagConstraints();
        rightPanelConstraints.gridx = 1; // Start at column 1
        rightPanelConstraints.gridy = 0; // Start at row 0
        rightPanelConstraints.weightx = 0.25; // 25% of width
        rightPanelConstraints.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically

        // Add rightPanel to the frame with constraints
        container.add(rightPanel, rightPanelConstraints);
        // add BoxLayout layout to the panels
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        inputsPanle.setLayout(new GridLayout(13, 1));
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
        inputsPanle.add(new JLabel("Adresse"));
        inputsPanle.add(addressTextArea);
        leftPanel.add(inputsPanle);

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
        buttonsPanel.add(modifyBtn);
        buttonsPanel.add(closeBtn);

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

        add(container);
    }

    private void configureActions() {
        adherentsTable.setRowSelectionAllowed(true);
        ListSelectionModel select = adherentsTable.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                int row = adherentsTable.getSelectedRow();
                // populate the text fields and checkboxes
                nomTextField.setText((String) adherentsTable.getValueAt(row, 1));
                prenomTextField.setText((String) adherentsTable.getValueAt(row, 2));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Define the date format
                String formattedDate = dateFormat.format(adherentsTable.getValueAt(row, 3)); // Format the date as a string
                dateInscriptionTextField.setText(formattedDate);
                telTextField.setText((String) adherentsTable.getValueAt(row, 4));
                montantAPayerTextField.setText(adherentsTable.getValueAt(row, 5).toString());
                addressTextArea.setText((String) adherentsTable.getValueAt(row, 6));
                if (adherentsTable.getValueAt(row, 7).equals("Homme")) {
                    maleRadioButton.setSelected(true);
                } else {
                    femaleRadioButton.setSelected(true);
                }
                tennisCheckBox.setSelected((boolean) adherentsTable.getValueAt(row, 8));
                squashCheckBox.setSelected((boolean) adherentsTable.getValueAt(row, 9));
                natationCheckBox.setSelected((boolean) adherentsTable.getValueAt(row, 10));
                athletiesmeCheckBox.setSelected((boolean) adherentsTable.getValueAt(row, 11));
                randomneeCheckBox.setSelected((boolean) adherentsTable.getValueAt(row, 12));
                footCheckBox.setSelected((boolean) adherentsTable.getValueAt(row, 13));
                basketCheckBox.setSelected((boolean) adherentsTable.getValueAt(row, 14));
                volleyCheckeBox.setSelected((boolean) adherentsTable.getValueAt(row, 15));
                pelanqueCheckBox.setSelected((boolean) adherentsTable.getValueAt(row, 16));

            }
        });
        modifyBtn.addActionListener(new ModifieAdherentAction(this));
        closeBtn.addActionListener(this::closeWindow);
    }

    public void updateTable() {

    }
}
