package org.example.Presentation.Views;

import org.example.Beans.Adherent;
import org.example.Business.DefaultServices;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

/*
CREATE TABLE IF NOT EXISTS Adherent (
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
public class ShowAllAdherentFrame extends JFrame {
    JFrame parentFrame;
    JTable adherentsTable;
    String[] columnNames = {"ID", "Nom", "Prenom", "Date Inscription", "Telephone", "Montant à payer", "Adresse", "Sexe", "Tennis", "Squash", "Natation", "Athletisme", "Randonnée", "Foot", "Basket", "Volley", "Pelanque"};
    JTable jTable;
    List<Adherent> adherentList;
    JButton exitButton;

    public ShowAllAdherentFrame(String title, JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setTitle(title);
        setSize(parentFrame.getSize());
        setLocation(parentFrame.getLocation());

        /* layout */
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        exitButton = new JButton("Fermer");

        adherentList = DefaultServices.getInstance().getAllAdherents();

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        jTable = new JTable(tableModel);

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
        JScrollPane scrollPane = new JScrollPane(jTable);

        add(scrollPane);
        add(exitButton);
//        center the button
        exitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        exitButton.addActionListener(this::closeWindow);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);

    }

    private void closeWindow(ActionEvent e) {
        dispose();
        parentFrame.setVisible(true);
    }

}
