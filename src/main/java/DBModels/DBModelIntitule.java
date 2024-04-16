package DBModels;

import DBConnector.DBConnector;
import classes.Intitule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelIntitule {
    private static ObservableList<Intitule> intituleList = null;

    public DBModelIntitule() {
        intituleList = FXCollections.observableArrayList();
    }

    public ObservableList<Intitule> getIntituleList() {
        return intituleList;
    }

    public static void getExistingIntitules() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM intitule";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intituleList.add(new Intitule(rs.getString("data")));
            }
            System.out.println("Intitules Data Retrieved");
        } catch (Exception e) {
            System.out.println("\n Data Not Retrieved");
            System.out.println(e);
        }
        connection.close();
    }
}
