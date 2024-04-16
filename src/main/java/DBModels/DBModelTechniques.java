package DBModels;

import DBConnector.DBConnector;
import classes.Techniques;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelTechniques {
    private static ObservableList<Techniques> techniquesList = null;

    public DBModelTechniques() {
        techniquesList = FXCollections.observableArrayList();
    }

    public ObservableList<Techniques> getTechniquesList() {
        return techniquesList;
    }

    public static void getExistingTechniques() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM techniques";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                techniquesList.add(new Techniques(rs.getString("notes")));
            }
            System.out.println("Techniques Data Retrieved");
        } catch (Exception e) {
            System.out.println("\n Data Not Retrieved");
            System.out.println(e);
        }
        connection.close();
    }
}
