module com.lab_pbo.proyekminisociolla {
    requires javafx.controls;
    requires javafx.fxml;

    opens AddAddress to javafx.fxml;
    exports AddAddress;
}