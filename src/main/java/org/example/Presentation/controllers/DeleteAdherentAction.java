package org.example.Presentation.controllers;

import org.example.Business.DefaultServices;
import org.example.Presentation.Views.DeleteAdherentFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAdherentAction implements ActionListener {
    DeleteAdherentFrame deleteAdherentFrame;

    public DeleteAdherentAction(DeleteAdherentFrame deleteAdherentFrame) {
        this.deleteAdherentFrame = deleteAdherentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (deleteAdherentFrame.selectedAdherent== null) {
            JOptionPane.showMessageDialog(deleteAdherentFrame, "Veuillez sélectionner un adherent", "supprimer un adherent", JOptionPane.ERROR_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(deleteAdherentFrame, "êtes-vous sûr de vouloir supprimer l' adherent " + deleteAdherentFrame.selectedAdherent.nom, "supprimer un membre", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                if (DefaultServices.getInstance().deleteAdherent(deleteAdherentFrame.selectedAdherent) != null) {
                    JOptionPane.showMessageDialog(deleteAdherentFrame, "Adherent supprimé avec succès");
                    deleteAdherentFrame.updateTable();
                    deleteAdherentFrame.selectedAdherent = null;
                } else {
                    JOptionPane.showMessageDialog(deleteAdherentFrame, "Erreur lors de la suppression de l' adherent");
                }
            }
        }
    }
}
