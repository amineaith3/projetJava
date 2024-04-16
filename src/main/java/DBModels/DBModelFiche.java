package DBModels;

import DBConnector.DBConnector;
import classes.Fiche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelFiche {
    private static ObservableList<Fiche> ficheList = null;

    public DBModelFiche() {
        ficheList = FXCollections.observableArrayList();
    }

    public ObservableList<Fiche> getFicheList() {
        return ficheList;
    }

    public static void getExistingFiches() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM fiche";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ficheList.add(new Fiche(rs.getString("fichier_path"), rs.getString("notes")));
            }
            System.out.println("Fiches Data Retrieved");
        } catch (Exception e) {
            System.out.println("\n Data Not Retrieved");
            System.out.println(e);
        }
        connection.close();
    }
}
