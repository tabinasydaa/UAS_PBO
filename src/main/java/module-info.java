
module tess {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.desktop;

    opens login to javafx.fxml;
    opens main to javafx.fxml;
    opens KeranjangCheckout to javafx.fxml;
    opens AddAddress to javafx.fxml;

    exports main;
    exports main.model;
    exports login;
    exports AddAddress;
    exports KeranjangCheckout;

//    exports model;/
    opens main.model to javafx.fxml;
}
