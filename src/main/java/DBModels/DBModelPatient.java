package DBModels;

import DBConnector.*;

import classes.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

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
        } finally{
            connection.close();
        }
    }

    public static ObservableList<Patient> SearchedPatientByFullName(String nom, String prenom) throws SQLException {
        patients = FXCollections.observableArrayList();
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM patient WHERE nom = ? and prenom = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patients.add(new Patient(rs.getString("cin"),
                        rs.getString("prenom"),
                        rs.getString("nom"),
                        new StringBuffer(rs.getString("tel")),
                        rs.getBoolean("sexe"),
                        rs.getDate("dateNaissance"),
                        new StringBuffer(rs.getString("adresse")),
                        new StringBuffer(rs.getString("note")),
                        new StringBuffer(rs.getString("mutuelle")
                        )));
            }
            System.out.println("Patients Data Found");
        } catch (Exception e) {
            System.out.println("\n Data Not Found");
            System.out.println(e);
        } finally {
            connection.close();
        }
        return patients;
    }


    public static ObservableList<Patient> searchPatientsByRDVDate(Date rdvDate) throws SQLException {
        ObservableList<Patient> patients = FXCollections.observableArrayList();
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT p.* " +
                    "FROM RDV r " +
                    "JOIN SESSION s ON r.ID_RENDER_VOUS = s.ID_SESSION " +
                    "JOIN PATIENT p ON s.ID_PATIENT = p.ID_PATIENT " +
                    "WHERE DATE(r.DATE_RENDEZ_VOUS) = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, rdvDate);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        new StringBuffer(resultSet.getString(4)),
                        resultSet.getBoolean(5),
                        resultSet.getDate(6),
                        new StringBuffer(resultSet.getString(7)),
                        new StringBuffer(resultSet.getString(8)),
                        new StringBuffer(resultSet.getString(9)));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return patients;
    }

    public static void addPatient(String cin, String prenom, String nom, StringBuffer tel, boolean sexe, Date dateNaissance, StringBuffer address, StringBuffer note, StringBuffer mutuelle) throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {

            String query = "INSERT INTO patient(CIN, PRENOM, NOM, TEL, SEXE, DATENAISSANCE, ADDRESS, NOTE, MUTUELLE) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cin);
            ps.setString(2, prenom);
            ps.setString(3, nom);
            ps.setString(4, tel.toString()); // Changed to use toString() method
            ps.setBoolean(5, sexe);
            ps.setDate(6, dateNaissance);
            ps.setString(7, address.toString()); // Changed to use toString() method
            ps.setString(8, note.toString()); // Changed to use toString() method
            ps.setString(9, mutuelle.toString()); // Changed to use toString() method

            ps.executeUpdate(); // Added to execute the query
            System.out.println("Patient Added Successfully");
        } catch (SQLException e) {
            System.out.println("Failed to add patient");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }


    public static void updatePatient(String oldCin, String newCin, String prenom, String nom, String tel, boolean sexe, Date dateNaissance, String address, String note, String mutuelle) throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "UPDATE patient SET PRENOM=?, NOM=?, TEL=?, SEXE=?, DATENAISSANCE=?, ADDRESS=?, NOTE=?, MUTUELLE=?, CIN = ? WHERE CIN=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, prenom);
            ps.setString(2, nom);
            ps.setString(3, tel);
            ps.setBoolean(4, sexe);
            ps.setDate(5, dateNaissance);
            ps.setString(6, address);
            ps.setString(7, note);
            ps.setString(8, mutuelle);
            ps.setString(9, newCin);
            ps.setString(10, oldCin);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Patient updated successfully");
            } else {
                System.out.println("No patient found with the given CIN");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update patient");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

}
