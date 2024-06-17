module com.example.uaslabpbo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens Struk to javafx.fxml;
    exports Struk;
}
