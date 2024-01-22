package org.example.Presentation.controllers;

import org.example.Beans.Adherent;
import org.example.Business.DefaultServices;
import org.example.Presentation.Views.DatabaseManagementInterface;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAdherentAction implements ActionListener {
    DatabaseManagementInterface databaseManagementInterface;
    public AddAdherentAction(DatabaseManagementInterface databaseManagementInterface) {
        this.databaseManagementInterface = databaseManagementInterface;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!databaseManagementInterface.inputsValide()){
            databaseManagementInterface.showMessageDialog("All fields are required");
            return ;
        }
        Adherent adherent = new Adherent();
        adherent.nom = databaseManagementInterface.getNom();
        adherent.prenom = databaseManagementInterface.getPrenom();
        // change DateInscription from string to Date
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        String dateInString = databaseManagementInterface.getDateInscription();
        DateTime dateTime = DateTime.parse(dateInString, formatter);
        adherent.dateInscription = dateTime.toDate();

        adherent.login = databaseManagementInterface.getLogin();
        adherent.motDePasse = databaseManagementInterface.getPassword();
        adherent.montantAPayer = Double.parseDouble(databaseManagementInterface.montantAPayerTextField.getText());
        adherent.telephone = databaseManagementInterface.getTel();
        adherent.adresse = databaseManagementInterface.getAddresse();
        adherent.sexe = databaseManagementInterface.getSexe();

        adherent.athletisme = databaseManagementInterface.athletiesmeCheckBox.isSelected();
        adherent.basket = databaseManagementInterface.basketCheckBox.isSelected();
        adherent.foot = databaseManagementInterface.footCheckBox.isSelected();
        adherent.natation = databaseManagementInterface.natationCheckBox.isSelected();
        adherent.pelanque = databaseManagementInterface.pelanqueCheckBox.isSelected();
        adherent.squash = databaseManagementInterface.squashCheckBox.isSelected();
        adherent.tennis = databaseManagementInterface.tennisCheckBox.isSelected();
        adherent.randonnee = databaseManagementInterface.randomneeCheckBox.isSelected();
        adherent.volley = databaseManagementInterface.volleyCheckeBox.isSelected();
        adherent.randonnee = databaseManagementInterface.randomneeCheckBox.isSelected();

        if(DefaultServices.getInstance().addAdherent(adherent) != null){
            // show a success message dialog
            databaseManagementInterface.showMessageDialog("Adherent added successfully");
            // reset all fields
            databaseManagementInterface.resetAllFields();

        } else {
            // show an error message dialog
            databaseManagementInterface.showMessageDialog("Error while adding adherent");

        }

    }
}
