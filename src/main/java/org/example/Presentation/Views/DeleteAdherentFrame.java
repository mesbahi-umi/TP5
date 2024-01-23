package org.example.Presentation.Views;

import org.example.Beans.Adherent;
import org.example.Business.DefaultServices;
import org.example.Presentation.controllers.DeleteAdherentAction;
import org.example.Constants.AdherentColumns;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteAdherentFrame extends CustomedJFrame {
    // 1 - table to list all the adherents
    // 2 - user select a row and click on delete
    // 3 - table updated after the deletion
    // 4 - user can close the window
    JTable adherentsTable;
    public Adherent selectedAdherent;
    JButton deleteBtn;
    JButton closeBtn;
    public List<Adherent> adherentList;
    JPanel buttonsPanel;

    public DeleteAdherentFrame(String title, JFrame parentFrame) {
        super(title, parentFrame);
        adherentsTable = new JTable();
        buttonsPanel = new JPanel();
        deleteBtn = new JButton("Supprimer");
        closeBtn = new JButton("Fermer");

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
        buttonsPanel.add(deleteBtn);
        buttonsPanel.add(closeBtn);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
        add(buttonsPanel);
    }

    private void configureActions() {
        adherentsTable.setRowSelectionAllowed(true);
        ListSelectionModel select = adherentsTable.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                int row = adherentsTable.getSelectedRow();
                selectedAdherent = new Adherent();
                selectedAdherent.adherentID = (int) adherentsTable.getValueAt(row, 0);
                selectedAdherent.nom = (String) adherentsTable.getValueAt(row, 1);
                selectedAdherent.prenom = (String) adherentsTable.getValueAt(row, 2);
            }
        });
        deleteBtn.addActionListener(new DeleteAdherentAction(this));
        closeBtn.addActionListener(this::closeWindow);
    }

    public void updateTable() {
        // filter the old list
        adherentList = adherentList.stream().filter(adherent -> adherent.adherentID != selectedAdherent.adherentID).collect(Collectors.toList());
        // update the table
        int row = adherentsTable.getSelectedRow();
        // Convert the row index in case the table is sorted or filtered
        int modelRow = adherentsTable.convertRowIndexToModel(row);

        // Remove row from the model
        ((DefaultTableModel) adherentsTable.getModel()).removeRow(modelRow);
    }
}
