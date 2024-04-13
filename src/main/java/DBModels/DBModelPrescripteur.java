package DBModels;

import DBConnector.DBConnector;
import classes.Prescripteur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModelPrescripteur {
    private static ObservableList<Prescripteur> prescripteurs = null;

    public DBModelPrescripteur() {
        prescripteurs = FXCollections.observableArrayList();
    }

    public ObservableList<Prescripteur> getPrescripteurs() {
        return prescripteurs;
    }

    public static void getExistingPrescripteurs() throws SQLException {
        Connection connection = DBConnector.connectDB();
        try {
            String query = "SELECT * FROM prescripteur";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prescripteurs.add(new Prescripteur(rs.getString("codeDoc"), rs.getString("nom"), rs.getString("prenom"), new StringBuffer(rs.getString("adress")), new StringBuffer(rs.getString("email")), new StringBuffer(rs.getString("notes"))));
            }
            System.out.println("Prescripteurs Data Inserted");
        } catch (Exception e) {
            System.out.println("\n Data Not Inserted");
            System.out.println(e);
        }
        connection.close();
    }
}
