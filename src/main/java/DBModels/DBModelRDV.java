package DBModels;

import DBConnector.DBConnector;
import classes.Patient;
import classes.RDV;
import classes.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DBModelRDV {
    private static ObservableList<RDV> rdvs = null;

    public DBModelRDV() {
        rdvs = FXCollections.observableArrayList();
    }

    public ObservableList<RDV> getRDVs() {
        return rdvs;
    }

    public static void getExistingRDVs() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM rdv";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Get Patient object for RDV
                Patient patient = getPatientById(rs.getInt("patient_id"));
                // Get Session object for RDV
                Session session = getSessionById(rs.getInt("session_id"));
                rdvs.add(new RDV(patient, rs.getString("etat"), rs.getString("note"), session, rs.getString("motif"), rs.getDate("date_rdv"), rs.getDate("duree_rdv")));
            }
            System.out.println("RDVs Data Inserted");
        } catch (Exception e) {
            System.out.println("\n Data Not Inserted");
            System.out.println(e);
        }
        connection.close();
    }

    public static Patient getPatientById(int id) throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM patient WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Patient(rs.getString("cin"), rs.getString("prenom"), rs.getString("nom"), new StringBuffer(rs.getString("tel")), true, rs.getDate("dateNaissance"), new StringBuffer(rs.getString("adresse")), new StringBuffer(rs.getString("note")), new StringBuffer(rs.getString("mutuelle")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        connection.close();
        return null;
    }

    public static Session getSessionById(int id) throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM session WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Session(rs.getDate("dateDepart"), new StringBuffer(rs.getString("prescription")), rs.getInt("nombreSeance"), rs.getString("typeSession"), rs.getBoolean("etat"), new StringBuffer(rs.getString("dossierMedical")), new StringBuffer(rs.getString("notes")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        connection.close();
        return null;
    }
}
