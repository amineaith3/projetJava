package DBModels;

import DBConnector.*;
import classes.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;

public class DBModelSession {
    private static ObservableList<Session> sessionList = null;

    public DBModelSession() {
        sessionList = FXCollections.observableArrayList();
    }

    public ObservableList<Session> getSessionList() {
        return sessionList;
    }

    public static void getExistingSessions() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM Session";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sessionList.add(new Session(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        new StringBuffer(rs.getString(8)),
                        new StringBuffer(rs.getString(9)))
                );
            }
            System.out.println("Sessions Data Retrieved");
        } catch (SQLException e) {
            System.out.println("Failed to retrieve sessions data");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void addSession(int ID_Prescription, int ID_Patient, int ID_Prescripteur, Timestamp Date_DEPART,
                                  String TYPE_SESSION, int NBR_SEANCES, String STAT, StringBuffer DOSSIER_MEDICAL, StringBuffer NOTES) throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "INSERT INTO Session(ID_PRESCRIPTION, ID_PATIENT, ID_PRESCRIPTEUR, DATE_DEPART, TYPE_DE_SESSION, NBR_SEANCE, STAT, DOSSIER_MEDICAL, NOTES) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ID_Prescription);
            ps.setInt(2, ID_Patient);
            ps.setInt(3, ID_Prescripteur);
            ps.setTimestamp(4, Date_DEPART);
            ps.setString(5, TYPE_SESSION);
            ps.setInt(6, NBR_SEANCES);
            ps.setString(7, STAT);
            ps.setString(8, DOSSIER_MEDICAL.toString());
            ps.setString(9, NOTES.toString());

            ps.executeUpdate();
            System.out.println("Session Added Successfully");
        } catch (SQLException e) {
            System.out.println("Failed to add session");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }


    public static void updateSession(int idpatient, String notes, String dossierMedical, int nbrSeances, String stat) throws SQLException {
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
