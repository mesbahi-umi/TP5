package org.example.Presentation.controllers;

import org.example.Beans.Adherent;
import org.example.Business.DefaultServices;
import org.example.Presentation.Views.AddAdherentFrame;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAdherentAction implements ActionListener {
    AddAdherentFrame addAdherentFrame;

    public AddAdherentAction(AddAdherentFrame addAdherentFrame) {
        this.addAdherentFrame = addAdherentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!addAdherentFrame.inputsValide()){
            addAdherentFrame.showMessageDialog("All fields are required");
            return ;
        }
        Adherent adherent = new Adherent();
        adherent.nom = addAdherentFrame.getNom();
        adherent.prenom = addAdherentFrame.getPrenom();
        // change DateInscription from string to Date
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        String dateInString = addAdherentFrame.getDateInscription();
        DateTime dateTime = DateTime.parse(dateInString, formatter);
        adherent.dateInscription = dateTime.toDate();

        adherent.login = addAdherentFrame.getLogin();
        adherent.motDePasse = addAdherentFrame.getPassword();
        adherent.montantAPayer = Double.parseDouble(addAdherentFrame.montantAPayerTextField.getText());
        adherent.telephone = addAdherentFrame.getTel();
        adherent.adresse = addAdherentFrame.getAddresse();
        adherent.sexe = addAdherentFrame.getSexe();

        adherent.athletisme = addAdherentFrame.athletiesmeCheckBox.isSelected();
        adherent.basket = addAdherentFrame.basketCheckBox.isSelected();
        adherent.foot = addAdherentFrame.footCheckBox.isSelected();
        adherent.natation = addAdherentFrame.natationCheckBox.isSelected();
        adherent.pelanque = addAdherentFrame.pelanqueCheckBox.isSelected();
        adherent.squash = addAdherentFrame.squashCheckBox.isSelected();
        adherent.tennis = addAdherentFrame.tennisCheckBox.isSelected();
        adherent.randonnee = addAdherentFrame.randomneeCheckBox.isSelected();
        adherent.volley = addAdherentFrame.volleyCheckeBox.isSelected();
        adherent.randonnee = addAdherentFrame.randomneeCheckBox.isSelected();

        if(DefaultServices.getInstance().addAdherent(adherent) != null){
            // show a success message dialog
            addAdherentFrame.showMessageDialog("Adherent added successfully");
            // reset all fields
//            addAdherentFrame.resetAllFields();

        } else {
            // show an error message dialog
            addAdherentFrame.showMessageDialog("Error while adding adherent");

        }

    }
}
