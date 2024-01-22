package org.example.Dao;

import org.example.Beans.Adherent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdherentDaoJdbc implements AdherentDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ClubDatabase?useSSL=false";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

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
    @Override
    public Adherent save(Adherent adherent) {
        try {
            String query = "INSERT INTO Adherent (Nom, Prenom, DateInscription, Telephone, Login," +
                    " MotDePasse, MontantAPayer, Adresse, Sexe, Tennis, Squash, Natation, Athletiesme," +
                    " Randomnee, Foot, Basket, Volley, pelanque)" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, adherent.nom);
            statement.setString(2, adherent.prenom);
            statement.setDate(3, new java.sql.Date(adherent.dateInscription.getTime()));
            statement.setString(4, adherent.telephone);
            statement.setString(5, adherent.login);
            statement.setString(6, adherent.motDePasse);
            statement.setDouble(7, adherent.montantAPayer);
            statement.setString(8, adherent.adresse);
            statement.setString(9, adherent.sexe);
            statement.setBoolean(10, adherent.tennis);
            statement.setBoolean(11, adherent.squash);
            statement.setBoolean(12, adherent.natation);
            statement.setBoolean(13, adherent.athletisme);
            statement.setBoolean(14, adherent.randonnee);
            statement.setBoolean(15, adherent.foot);
            statement.setBoolean(16, adherent.basket);
            statement.setBoolean(17, adherent.volley);
            statement.setBoolean(18, adherent.pelanque);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new adherent was inserted successfully!");
                return adherent;
            }
        } catch (SQLException e) {
            System.out.println("Error while saving adherent");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Adherent findById(String login) {
        return null;
    }

    @Override
    public List<Adherent> getAll() {
        List<Adherent> adherents = new ArrayList<>();
        try {
            String query = "SELECT * FROM Adherent";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Adherent adherent = new Adherent();
                adherent.adherentID = resultSet.getInt("AdherentID");
                adherent.nom = resultSet.getString("Nom");
                adherent.prenom = resultSet.getString("Prenom");
                adherent.dateInscription = resultSet.getDate("DateInscription");
                adherent.telephone = resultSet.getString("Telephone");
                adherent.login = resultSet.getString("Login");
                adherent.motDePasse = resultSet.getString("MotDePasse");
                adherent.montantAPayer = resultSet.getDouble("MontantAPayer");
                adherent.adresse = resultSet.getString("Adresse");
                adherent.sexe = resultSet.getString("Sexe");
                adherent.tennis = resultSet.getBoolean("Tennis");
                adherent.squash = resultSet.getBoolean("Squash");
                adherent.natation = resultSet.getBoolean("Natation");
                adherent.athletisme = resultSet.getBoolean("Athletiesme");
                adherent.randonnee = resultSet.getBoolean("Randomnee");
                adherent.foot = resultSet.getBoolean("Foot");
                adherent.basket = resultSet.getBoolean("Basket");
                adherent.volley = resultSet.getBoolean("Volley");
                adherent.pelanque = resultSet.getBoolean("pelanque");
                adherents.add(adherent);
            }
        } catch (SQLException e) {
            System.out.println("Error while getting all adherents");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        return adherents;
    }

    @Override
    public Adherent update(Adherent adherent) {
        try{
            String query = "UPDATE Adherent SET Nom = ?, Prenom = ?, DateInscription = ?, Telephone = ?, Login = ?," +
                    " MotDePasse = ?, MontantAPayer = ?, Adresse = ?, Sexe = ?, Tennis = ?, Squash = ?, Natation = ?," +
                    " Athletiesme = ?, Randomnee = ?, Foot = ?, Basket = ?, Volley = ?, pelanque = ? WHERE AdherentID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, adherent.nom);
            statement.setString(2, adherent.prenom);
            statement.setDate(3, new java.sql.Date(adherent.dateInscription.getTime()));
            statement.setString(4, adherent.telephone);
            statement.setString(5, adherent.login);
            statement.setString(6, adherent.motDePasse);
            statement.setDouble(7, adherent.montantAPayer);
            statement.setString(8, adherent.adresse);
            statement.setString(9, adherent.sexe);
            statement.setBoolean(10, adherent.tennis);
            statement.setBoolean(11, adherent.squash);
            statement.setBoolean(12, adherent.natation);
            statement.setBoolean(13, adherent.athletisme);
            statement.setBoolean(14, adherent.randonnee);
            statement.setBoolean(15, adherent.foot);
            statement.setBoolean(16, adherent.basket);
            statement.setBoolean(17, adherent.volley);
            statement.setBoolean(18, adherent.pelanque);
            statement.setInt(19, adherent.adherentID);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing adherent was updated successfully!");
                return adherent;
            }
        } catch (SQLException e) {
            System.out.println("Error while updating adherent");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Adherent delete(Adherent adherent) {
        try {
            String query = "DELETE FROM Adherent WHERE AdherentID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, adherent.adherentID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A adherent was deleted successfully!");
                return adherent;
            }
        } catch (SQLException e) {
            System.out.println("Error while deleting adherent");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
