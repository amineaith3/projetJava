package DBModels;

import DBConnector.*;

import classes.Patient;
import classes.RDV;
import classes.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;

public class DBModelRDV {
    private static ObservableList<RDV> rendezVousList = null;

    public DBModelRDV() {
        rendezVousList = FXCollections.observableArrayList();
    }

    public ObservableList<RDV> getRendezVousList() {
        return rendezVousList;
    }



    public static void getExistingRDVs() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM RDV";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rendezVousList.add(new RDV(rs.getInt("ID_SESSION"), rs.getString("ETATS"), rs.getString("NOTE"), rs.getString("MOTIF"), rs.getTimestamp("DATE_RENDEZ_VOUS")));
            }
            System.out.println("RDVs Data Inserted");
        } catch (Exception e) {
            System.out.println("\n Data Not Inserted");
            System.out.println(e);
        }
        connection.close();
    }

    public static void addRDV(int idSession, String etats, String note, String motif, Timestamp dateRendezVous) throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            if(!isRDVExist(dateRendezVous)){

                String query = "INSERT INTO RDV(ID_SESSION, ETATS, NOTE, MOTIF, DATE_RENDEZ_VOUS) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, idSession);
                ps.setString(2, etats);
                ps.setString(3, note);
                ps.setString(4, motif);
                ps.setTimestamp(5, dateRendezVous);

                ps.executeUpdate();
                System.out.println("RDV Added Successfully");
            } else{
                System.out.println("RDV Exists already");
            }
        } catch (SQLException e) {
            System.out.println("Failed to add RDV");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static boolean isRDVExist(Timestamp date) throws SQLException {
        Connection connection = DBConnector.connectDB();
        String query = "SELECT * FROM RDV WHERE DATE_RENDEZ_VOUS = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setTimestamp(1, date);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        connection.close();
        return exists;
    }
}
