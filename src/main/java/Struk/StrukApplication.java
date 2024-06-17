package Struk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StrukApplication extends Application {
    public StrukApplication() {
    }

    public void start(Stage stage) throws Exception {
        // Ensure the path is correct and that Struk.fxml is in src/main/resources/Struk
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Struk/Struk.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Receipt");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
