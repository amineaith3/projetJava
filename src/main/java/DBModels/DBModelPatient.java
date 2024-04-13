package DBModels;

import DBConnector.*;

import classes.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelPatient {
    private static ObservableList<Patient> patients = null;

    public DBModelPatient() {
        patients = FXCollections.observableArrayList();
    }

    public ObservableList<Patient> getPatients() {
        return patients;
    }

    public static void getExistingPatients() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM patient";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patients.add(new Patient(rs.getString("cin"), rs.getString("prenom"), rs.getString("nom"), new StringBuffer(rs.getString("tel")), true, rs.getDate("dateNaissance"), new StringBuffer(rs.getString("adresse")), new StringBuffer(rs.getString("note")), new StringBuffer(rs.getString("mutuelle"))));
            }
            System.out.println("Patients Data Inserted");
        } catch (Exception e) {
            System.out.println("\n Data Not Inserted");
            System.out.println(e);
        }
        connection.close();
    }

    public static void getSearchedPatient(String nom, String prenom) throws SQLException {
        patients = FXCollections.observableArrayList();
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM patient WHERE nom = ? and prenom = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patients.add(new Patient(rs.getString("cin"), rs.getString("prenom"),
                        rs.getString("nom"), new StringBuffer(rs.getString("tel")), true, rs.getDate("dateNaissance"), new StringBuffer(rs.getString("adresse")), new StringBuffer(rs.getString("note")), new StringBuffer(rs.getString("mutuelle"))));
            }
            System.out.println("Patients Data Inserted");
        } catch (Exception e) {
            System.out.println("\n Data Not Inserted");
            System.out.println(e);
        }
        connection.close();
    }
}
