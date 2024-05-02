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


    public static void updatePrescription(String oldData,String NewData) throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "UPDATE prescription SET DATA = ? WHERE DATA = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, NewData);
            ps.setString(2, oldData);

            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Prescription Updated Successfully");
            } else {
                System.out.println("Pres");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update prescription");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

}
