package main;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import main.model.Product;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainController {

    @FXML
    private VBox chosenProductCard;

    @FXML
    private Label productNameLabel;

    @FXML
    private Label productPriceLabel;

    @FXML
    private Label productDescriptionLabel;

    @FXML
    private ImageView productImg;

    @FXML
    private GridPane gridProduct;

    @FXML
    private Label recommendedTitleLabel;  // Label for "Our Recommended" title

    @FXML
    private ChoiceBox<String> categoryChoiceBox;

    @FXML
    private Spinner<Integer> quantitySpinner;

    @FXML
    private ScrollPane scrollPane;  // Reference to the ScrollPane

    private List<Product> products;
    private List<Product> recommendedProducts;

    @FXML
    private void initialize() {
        chosenProductCard.setVisible(false);
        scrollPane.setVisible(true);  // Ensure the ScrollPane is visible initially

        categoryChoiceBox.getItems().addAll("Makeup", "Skincare", "Bodycare");
        categoryChoiceBox.setOnAction(e -> loadProducts(categoryChoiceBox.getValue()));

        products = List.of(
                // Makeup products
                new Product("Skintific", 167800, "Makeup", getResource("/main/image/skintific.png"), "Cover All Perfect Cushion"),
                new Product("YOU Beauty", 166500, "Makeup", getResource("/main/image/YOU (makeup).png"), "YOU Noutriwear+ Flawless Cushion Foundation"),
                new Product("Make Over", 205000, "Makeup", getResource("/main/image/makeover.jpg"), "Powerstay Matte Powder Foundation"),
                new Product("Instaperfect", 95000, "Makeup", getResource("/main/image/instaperfect (makeup).png"), "Instaperfect Blur Mattifying Primer"),
                new Product("Esqa", 94500, "Makeup", getResource("/main/image/esqa (makeup).png"), "Powder Blush"),
                new Product("Wardah", 51500, "Makeup", getResource("/main/image/wardah (makeup).jpg"), "EyeXpert Eyeshadow Nude"),
                new Product("Lavie Lash", 190000, "Makeup", getResource("/main/image/lavie lash (makeup).jpg"), "EyeXpert Eyeshadow Nude"),
                new Product("Loreal Paris", 174500, "Makeup", getResource("/main/image/loreal paris (makeup).png"), "Rouge Signature Liquid Matte Lipstick"),
                new Product("Barenbliss", 65500, "Makeup", getResource("/main/image/barenbliss.png"), "Peach Makes Perfect Lip Tint"),
                new Product("Focallure", 36100, "Makeup", getResource("/main/image/focallure (makeup).png"), "CREAMY LIP & CHEEK DUO"),
                new Product("Dear Me Beauty", 49000, "Makeup", getResource("/main/image/dear  me beauty (makeup).png"), "Serum Lip Tint"),
                new Product("Mother Of Pearl", 94050, "Makeup", getResource("/main/image/mother of pearl (makeup).png"), "AM to PM Colorfast Hypertint"),
                new Product("Espoir", 455000, "Makeup", getResource("/main/image/espoir (makeup).png"), "REAL EYE PALETTE ALL NEW"),
                new Product("Romand", 128700, "Makeup", getResource("/main/image/romand (makeup).png"), "Back Me Tone Up Cream"),
                new Product("O.TWO.O", 59000, "Makeup", getResource("/main/image/otwoo (makeup).png"), "Lash Bold Volume Lifting Mascara"),
                new Product("Dazzle Me", 37900, "Makeup", getResource("/main/image/dazzle me (makeup).png"), "Get a Grip! Makeup Setting Spray"),
                new Product("Rose All Day", 107500, "Makeup", getResource("/main/image/rad (makeup).png"), "Berry Kiss Holiday Bundle"),
                new Product("Nama Beauty", 119000, "Makeup", getResource("/main/image/nama (makeup).png"), "Play All Day Matte Lipcream"),

                // Skincare products
                new Product("Avoskin", 148800, "Skincare", getResource("/main/image/avoskin (skincare).png"), "Intensive Nourishing Eye Cream Alpha Arbutin"),
                new Product("COSRX", 339000, "Skincare", getResource("/main/image/cosrx (skincare).png"), "Advanced Snail Hydrogel Eye Patch"),
                new Product("Heimish", 191400, "Skincare", getResource("/main/image/heimish (skincare).png"), "Matcha Biome Hydrogel Eye Patch"),
                new Product("Npure", 93000, "Skincare", getResource("/main/image/npure (skincare).png"), "Centella Asiatica Acne Clear Hydrating & Calming Toner"),
                new Product("Lacoco", 198000, "Skincare", getResource("/main/image/lacoco (skincare).png"), "Dark Spot Essence"),
                new Product("Whitelab", 39000, "Skincare", getResource("/main/image/whtelab (skincare).png"), "Brightening Face Toner"),
                new Product("Skintific", 167400, "Skincare", getResource("/main/image/skintific (skincare).png"), "5X Ceramide Serum Sun Screen Twinpack"),
                new Product("Bioderma", 465000, "Skincare", getResource("/main/image/bioderma.png"), "Bioderma Atoderm Creme Ultra"),
                new Product("Cetaphil", 180000, "Skincare", getResource("/main/image/cetaphil (skincare).png"), "Moisturizing Lotion"),
                new Product("Studio Tropik", 109500, "Skincare", getResource("/main/image/studio tropik (skincare).jpg"), "Flawless Priming Water"),
                new Product("Bio-Essence", 249000, "Skincare", getResource("/main/image/bio-essence (skincare).png"), "Bio Water B5 MOIST IN GEL 50"),
                new Product("Scarlett Whitening", 67500, "Skincare", getResource("/main/image/scarlett.png"), "Scarlett Whitening Brightly Ever After Day Cream"),
                new Product("Hada Labo", 125000, "Skincare", getResource("/main/image/hada labo (skincare).png"), "Perfect 3D Gel"),
                new Product("Erha", 84500, "Skincare", getResource("/main/image/erha.png"), "ERHA 2 Facial Wash For Oily Skin"),
                new Product("ElsheSkin", 45500, "Skincare", getResource("/main/image/elsheskin (skincare).png"), "Soothing Cleanser Wash"),
                new Product("Safi", 80000, "Skincare", getResource("/main/image/safi.jpg"), "White Expert Make Up Remover"),
                new Product("Pyungkang Yul", 169000, "Skincare", getResource("/main/image/pyungkang (skincare).png"), "Mist Toner"),
                new Product("Acwell", 148500, "Skincare", getResource("/main/image/acwell.png"), "Licorice pH Balancing Cleansing Toner"),

                // Bodycare products
                new Product("Bio-Oil", 152000, "Bodycare", getResource("/main/image/bio oil (bodycare).jpg"), "Bio-Oil"),
                new Product("Sukin", 160000, "Bodycare", getResource("/main/image/sukin (bodycare).png"), "Botanical Body Wash Signature Scent"),
                new Product("Nivea", 107000, "Bodycare", getResource("/main/image/nivea (bodycare).png"), "NIVEA Body Lotion Intensive Lotion Set"),
                new Product("Vaseline", 28500, "Bodycare", getResource("/main/image/vaseline (bodycare).png"), "Multi Purpose Repairing Jelly Aloe"),
                new Product("Perspirex", 260000, "Bodycare", getResource("/main/image/perspirex (bodycare).png"), "Perspirex antiperspirant comfort"),
                new Product("Precious Skin", 30200, "Bodycare", getResource("/main/image/precious skin (bodycare).png"), "Alpha Arbutin Soap"),
                new Product("Grace and Glow", 53100, "Bodycare", getResource("/main/image/grace and glow (bodycare).png"), "Anti Acne Solution Body Wash"),
                new Product("Barenbliss", 75000, "Bodycare", getResource("/main/image/barenbliss (bodycare).png"), "Into Glow! Mon Paris Brightening Body Wash"),
                new Product("Innisfree", 148500, "Bodycare", getResource("/main/image/innisfree (bodycare).png"), "My Perfumed Body Green Tangerine Cleanser"),
                new Product("Lavajoy", 94500, "Bodycare", getResource("/main/image/lavajoy.png"), "Bubble Up Shower Mousse Magical Duet"),
                new Product("Kahf", 25200, "Bodycare", getResource("/main/image/kahf (bodycare).png"), "Everyday Multipurpose Refreshing Spray"),
                new Product("Iswhite", 123100, "Bodycare", getResource("/main/image/iswhite.png"), "Whitening Ultimate Body Mask"),
                new Product("Dear Me Beauty", 71100, "Bodycare", getResource("/main/image/dmb (bodycare).png"), "Acne Care Body Spray"),
                new Product("Beauty Secrets", 69000, "Bodycare", getResource("/main/image/beauty secrets.png"), "Japanese Cherry B Shower Gel"),
                new Product("Buttered", 95000, "Bodycare", getResource("/main/image/buttered.png"), "Almond Shower Oil"),
                new Product("Etude", 240000, "Bodycare", getResource("/main/image/etude.png"), "Soon Jung Panthensoside Moisture Lotion"),
                new Product("Dew It", 110500, "Bodycare", getResource("/main/image/dewit.png"), "Dew It In The Shower - Radiant Body Wash"),
                new Product("Dove", 40250, "Bodycare", getResource("/main/image/dove.png"), "Women Antiperspirant Aerosol Soft Feel 150Ml")
        );

        recommendedProducts = List.of(
                products.get(0), // Example recommended products
                products.get(1),
                products.get(2)
        );

        // Initialize Spinner
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        quantitySpinner.setValueFactory(valueFactory);

        loadRecommendedProducts();
    }

    private String getResource(String resourcePath) {
        URL resource = getClass().getResource(resourcePath);
        return resource != null ? resource.toExternalForm() : "";
    }

    private void loadRecommendedProducts() {
        recommendedTitleLabel.setVisible(true);  // Show the "Our Recommended" title
        gridProduct.getChildren().clear();
        int column = 0;
        int row = 0;

        for (Product product : recommendedProducts) {
            VBox productCard = createProductCard(product);
            gridProduct.add(productCard, column++, row);

            if (column == 3) {
                column = 0;
                row++;
            }
        }
    }

    private void loadProducts(String category) {
        recommendedTitleLabel.setVisible(false);  // Hide the "Our Recommended" title
        gridProduct.getChildren().clear();
        int column = 0;
        int row = 0;

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                VBox productCard = createProductCard(product);
                gridProduct.add(productCard, column++, row);

                if (column == 3) {
                    column = 0;
                    row++;
                }
            }
        }
    }

    private VBox createProductCard(Product product) {
        VBox productCard = new VBox();
        productCard.setAlignment(Pos.CENTER);
        productCard.setPadding(new Insets(10));
        productCard.setSpacing(10);
        productCard.getStyleClass().add("product-card");

        ImageView imgView = new ImageView();
        try {
            if (!product.getImagePath().isEmpty()) {
                Image img = new Image(product.getImagePath(), true);
                imgView.setImage(img);
                imgView.setFitHeight(150);
                imgView.setFitWidth(150);
                imgView.setPreserveRatio(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Label nameLabel = new Label(product.getName());
        nameLabel.getStyleClass().add("product-name");

        Label priceLabel = new Label("Rp. " + product.getPrice());
        priceLabel.getStyleClass().add("product-price");

        productCard.getChildren().addAll(imgView, nameLabel, priceLabel);
        productCard.setOnMouseClicked(event -> showProductDetails(product));

        return productCard;
    }

    private void showProductDetails(Product product) {
        productNameLabel.setText(product.getName());
        productPriceLabel.setText("Rp. " + product.getPrice());
        productDescriptionLabel.setText(product.getDescription());
        try {
            if (!product.getImagePath().isEmpty()) {
                productImg.setImage(new Image(product.getImagePath(), true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        chosenProductCard.setVisible(true);
    }

    @FXML
    private void addToCart() {
        int quantity = quantitySpinner.getValue();
        // Logic for adding the product to the cart with the specified quantity
        System.out.println("Added to cart: " + quantity + " items of " + productNameLabel.getText());
    }

    @FXML
    private void playNow() {
        try {
            SnakeGame snakeGame = new SnakeGame();
            Stage snakeStage = new Stage();
            snakeGame.start(snakeStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
