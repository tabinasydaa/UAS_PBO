<<<<<<< HEAD
module com.example.uaslabpbo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens Struk to javafx.fxml;
    exports Struk;
}
=======
module MiniSociolla {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens login to javafx.fxml;
    opens main to javafx.fxml;
    exports login;
    exports main;
    exports main.model;


}
>>>>>>> 6375103081f943aff92fe216b866abf7d8d3e9cd
