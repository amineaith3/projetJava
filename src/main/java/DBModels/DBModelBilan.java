package DBModels;

import DBConnector.DBConnector;
import classes.Bilan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelBilan {
    private static ObservableList<Bilan> bilanList = null;

    public DBModelBilan() {
        bilanList = FXCollections.observableArrayList();
    }

    public ObservableList<Bilan> getBilanList() {
        return bilanList;
    }

    public static void getExistingBilans() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM bilan";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bilanList.add(new Bilan(rs.getString("notes")));
            }
            System.out.println("Bilans Data Retrieved");
        } catch (Exception e) {
            System.out.println("\n Data Not Retrieved");
            System.out.println(e);
        }
        connection.close();
    }
}
