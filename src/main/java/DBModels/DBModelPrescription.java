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
}
