package main;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import main.model.Product;

public class MainController {
    @FXML
    private VBox chosenFruitCard;

    @FXML
    private Label fruitNameLable;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private ImageView fruitimg;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    @FXML
    private ListView<Product> productList;

    @FXML
    private Button addToCartButton;

    @FXML
    private Button playGameButton;

    @FXML
    private TextField pointsField;

    @FXML
    private void handleAddToCart() {
        Product selectedProduct = productList.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            // Add product to cart
        }
    }

    @FXML
    private void handlePlayGame() {
        // Handle tic-tac-toe game
        // Add points if the user wins
        int points = Integer.parseInt(pointsField.getText());
        points += 5;  // Assuming user wins the game
        pointsField.setText(String.valueOf(points));
    }
}
