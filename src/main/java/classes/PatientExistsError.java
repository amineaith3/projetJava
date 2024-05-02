package classes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class PatientExistsError extends Application {
    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Patient Already Exists");
        alert.setContentText("A patient with the provided CIN already exists in the database.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
