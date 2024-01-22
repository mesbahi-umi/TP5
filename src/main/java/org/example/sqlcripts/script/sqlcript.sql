-- SQL script to create a database and the 'Adherent' table
CREATE DATABASE IF NOT EXISTS ClubDatabase;
USE ClubDatabase;

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
