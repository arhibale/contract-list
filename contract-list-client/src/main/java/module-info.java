module com.arhibale.contractlistclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arhibale.contractlistclient to javafx.fxml;
    exports com.arhibale.contractlistclient;
}