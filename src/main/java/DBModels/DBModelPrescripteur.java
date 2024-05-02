package DBModels;

import DBConnector.*;

import classes.Patient;
import classes.Prescripteur;
import classes.RDV;
import classes.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;

public class DBModelPrescripteur {
    private static ObservableList<Prescripteur> prescripteurList = null;

    public DBModelPrescripteur() {
        prescripteurList = FXCollections.observableArrayList();
    }

    public ObservableList<Prescripteur> getRendezVousList() {
        return prescripteurList;
    }



    public static void getExistingRDVs() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM RDV";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prescripteurList.add(new Prescripteur(rs.getString("NOM"), rs.getString("PRENOM"), new StringBuffer(rs.getString("ADDRESS")),new StringBuffer(rs.getString("EMAIL")),new StringBuffer(rs.getString("NOTES"))));
            }
            System.out.println("RDVs Data Inserted");
        } catch (Exception e) {
            System.out.println("\n Data Not Inserted");
            System.out.println(e);
        }
        connection.close();
    }

    public static void addPrescripteur(String nom, String prenom, StringBuffer address, StringBuffer email ,StringBuffer Note) throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            if(!isPrescripteurExist(nom,)){

                String query = "INSERT INTO prescripteur(NOM, PRENOM , ADDRESS , EMAIL , NOTE ) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1,nom);
                ps.setString(2, prenom);
                ps.setString(3, address.toString());
                ps.setString(4, email.toString());
                ps.setString(5, Note.toString());

                ps.executeUpdate();
                System.out.println("Prescripteur Added Successfully");
            } else{
                System.out.println("Priscripteur Exists already");
            }
        } catch (SQLException e) {
            System.out.println("Failed to add Priscripteur");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static boolean isPrescripteurExist(String nom, String prenom, StringBuffer adress) throws SQLException {
        Connection connection = DBConnector.connectDB();
        String query = "SELECT * FROM prescripteur WHERE NOM = ? and PRENOM = ? and ADDRESS = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, nom);
        ps.setString(2, prenom);
        ps.setString(3, adress.toString());
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        connection.close();
        return exists;
    }
}
