package org.example.Beans;

import java.util.Date;

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
public class Adherent {
    public int adherentID;
    public String nom;
    public String prenom;
    public Date dateNaissance;
    public String telephone;
    public String login;
    public String motDePasse;
    public double montantAPayer;
    public String adresse;
    public String sexe;
    public boolean tennis;
    public boolean squash;
    public boolean natation;
    public boolean athletisme;
    public boolean randonnee;
    public boolean foot;
    public boolean basket;
    public boolean volley;
    public boolean pelanque;

    public Adherent() {
    }
    public Adherent(int adherentID, String nom, String prenom, Date dateNaissance, String telephone,
                    String login, String motDePasse, double montantAPayer, String adresse, String sexe) {
        this.adherentID = adherentID;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.login = login;
        this.motDePasse = motDePasse;
        this.montantAPayer = montantAPayer;
        this.adresse = adresse;
        this.sexe = sexe;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
