package DBModels;

import DBConnector.DBConnector;
import classes.Protocole;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelProtocole {
    private static ObservableList<Protocole> protocoleList = null;

    public DBModelProtocole() {
        protocoleList = FXCollections.observableArrayList();
    }

    public ObservableList<Protocole> getProtocoleList() {
        return protocoleList;
    }

    public static void getExistingProtocoles() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM protocole";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                protocoleList.add(new Protocole(rs.getString("notes")));
            }
            System.out.println("Protocoles Data Retrieved");
        } catch (Exception e) {
            System.out.println("\n Data Not Retrieved");
            System.out.println(e);
        }
        connection.close();
    }
}
