module com.arhibale.contractlistclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arhibale.client to javafx.fxml;
    opens com.arhibale.client.controller to javafx.fxml;
    opens com.arhibale.client.dto to javafx.base;
    exports com.arhibale.client;
}