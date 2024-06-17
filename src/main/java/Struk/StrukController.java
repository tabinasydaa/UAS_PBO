package Struk;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class StrukController {

    @FXML
    private Hyperlink KunjungiToko;

    @FXML
    private Button TombolSave;

    @FXML
    private Button TombolPrint;

    @FXML
    private Label Judul;

    @FXML
    private void handleKunjungiTokoClick() {
        try {
            Desktop.getDesktop().browse(new URI("http://www.yourstorelink.com")); // replace with the actual URL
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSaveAction() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Receipt");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File file = fileChooser.showSaveDialog(new Stage());
            if (file != null) {
                FileWriter writer = new FileWriter(file);
                writer.write("Receipt details go here...");
                writer.close();
                System.out.println("Receipt saved to " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePrintAction() {
        // Implement print functionality here
        System.out.println("Print button clicked!");
        // For simplicity, this example just prints to the console.
        // Implement actual print logic according to your needs.
    }
}
