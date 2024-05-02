package DBModels;

import DBConnector.DBConnector;
import classes.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelPrescription {
    private static ObservableList<Prescription> prescriptionList = null;

    public DBModelPrescription() {
        prescriptionList = FXCollections.observableArrayList();
    }

    public ObservableList<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public static void getExistingPrescriptions() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM prescription";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prescriptionList.add(new Prescription(rs.getString("data")));
            }
            System.out.println("Prescriptions Data Retrieved");
        } catch (Exception e) {
            System.out.println("\n Data Not Retrieved");
            System.out.println(e);
        }
        connection.close();
    }

    public static void addPrescription(String data){
        Connection connection = DBConnector.connectDB();
        try {
            if(!isPrescriptionExist(data)) {
                String query = "INSERT INTO Prescription(DATA) values(?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, data);
                ps.executeQuery();
            }
            else {
                System.out.println("prescription deja exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean isPrescriptionExist(String data) throws SQLException {
        Connection connection = DBConnector.connectDB();
        String query = "SELECT * FROM prescription WHERE data = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, data);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        connection.close();
        return exists;
    }


    public static void updatePrescription(int idpatient, String notes, String dossierMedical, int nbrSeances, String stat) throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "UPDATE Session SET NOTES = ?, DOSSIER_MEDICAL = ?, NBR_SEANCE = ?, STAT = ? WHERE ID_PATIENT = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, notes);
            ps.setString(2, dossierMedical);
            ps.setInt(3, nbrSeances);
            ps.setString(4, stat);
            ps.setInt(5, idpatient);

            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Session Updated Successfully");
            } else {
                System.out.println("No session found with patient id: " + idpatient);
            }
        } catch (SQLException e) {
            System.out.println("Failed to update session");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

}
