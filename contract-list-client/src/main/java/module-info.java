module com.arhibale.contractlistclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    opens com.arhibale.client to javafx.fxml;
    opens com.arhibale.client.controller to javafx.fxml;
    opens com.arhibale.client.dto to javafx.base, com.fasterxml.jackson.databind;
    exports com.arhibale.client;
}