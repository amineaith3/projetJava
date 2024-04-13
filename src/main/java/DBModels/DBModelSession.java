package DBModels;

import DBConnector.DBConnector;
import classes.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelSession {
    private static ObservableList<Session> sessions = null;

    public DBModelSession() {
        sessions = FXCollections.observableArrayList();
    }

    public ObservableList<Session> getSessions() {
        return sessions;
    }

    public static void getExistingSessions() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM session";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sessions.add(new Session(rs.getDate("dateDepart"), new StringBuffer(rs.getString("prescription")), rs.getInt("nombreSeance"), rs.getString("typeSession"), rs.getBoolean("etat"), new StringBuffer(rs.getString("dossierMedical")), new StringBuffer(rs.getString("notes"))));
            }
            System.out.println("Sessions Data Inserted");
        } catch (Exception e) {
            System.out.println("\n Data Not Inserted");
            System.out.println(e);
        }
        connection.close();
    }
}
