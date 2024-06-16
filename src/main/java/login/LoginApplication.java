package login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/login.fxml"));
            AnchorPane pane = loader.load();  // Casting to AnchorPane since the root element in FXML is AnchorPane
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login - Mini Sociolla");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
