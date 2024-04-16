package DBModels;

import DBConnector.DBConnector;
import classes.Objectif;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelObjectif {
    private static ObservableList<Objectif> objectifList = null;

    public DBModelObjectif() {
        objectifList = FXCollections.observableArrayList();
    }

    public ObservableList<Objectif> getObjectifList() {
        return objectifList;
    }

    public static void getExistingObjectifs() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM objectif";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objectifList.add(new Objectif(rs.getString("notes")));
            }
            System.out.println("Objectifs Data Retrieved");
        } catch (Exception e) {
            System.out.println("\n Data Not Retrieved");
            System.out.println(e);
        }
        connection.close();
    }
}
