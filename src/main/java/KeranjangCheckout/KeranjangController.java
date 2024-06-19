package KeranjangCheckout;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import login.LoginDatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;




public class KeranjangController implements Initializable {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBox;

    @FXML
    private VBox cartItemsVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Mengatur style class untuk ScrollPane untuk mengaplikasikan CSS
        scrollPane.getStyleClass().add("scroll-pane");

        // Muat item keranjang untuk pengguna yang sedang login
        String username = "currentLoggedInUser"; // Ganti dengan cara mendapatkan username pengguna saat ini
        loadCartItems(username);
    }

    private void loadCartItems(String username) {
        Connection connection = LoginDatabaseConnection.getConnection();
        if (connection != null) {
            String sql = "SELECT p.name, p.price, p.image_path, c.quantity FROM cart c JOIN products p ON c.product_id = p.id JOIN users u ON c.user_id = u.id WHERE u.username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String productName = resultSet.getString("name");
                    double productPrice = resultSet.getDouble("price");
                    String imagePath = resultSet.getString("image_path");
                    int quantity = resultSet.getInt("quantity");

                    HBox cartItem = createCartItem(productName, productPrice, imagePath, quantity);
                    cartItemsVBox.getChildren().add(cartItem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Koneksi ke database gagal");
        }
    }

    private HBox createCartItem(String name, double price, String imagePath, int quantity) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);

        ImageView imageView = new ImageView();
        try {
            if (!imagePath.isEmpty()) {
                Image img = new Image(imagePath, true);
                imageView.setImage(img);
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                imageView.setPreserveRatio(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Label nameLabel = new Label(name);
        nameLabel.setPrefWidth(200);

        Label priceLabel = new Label("Rp. " + price);
        priceLabel.setPrefWidth(100);

        Label quantityLabel = new Label("Qty: " + quantity);
        quantityLabel.setPrefWidth(50);

        hBox.getChildren().addAll(imageView, nameLabel, priceLabel, quantityLabel);

        return hBox;
    }

    @FXML
    private void handleCheckout() {
        System.out.println("Checkout button clicked"); // Debug statement
        try {
            Stage stage = (Stage) scrollPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddAddress/AddAddress.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Add Address");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
