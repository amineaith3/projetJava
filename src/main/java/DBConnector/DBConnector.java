package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    public static Connection connectDB( ){
        Connection connection = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Establish connection to SQLite database
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/database/GetionnaireAvocatSqlite.db");
            System.out.println("Connected Data Base");

        } catch (Exception e) {
            System.out.println("\n Error in Connection");
            System.out.println(e);
        }
        return connection;
    }
}
