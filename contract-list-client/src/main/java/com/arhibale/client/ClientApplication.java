package com.arhibale.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ClientApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(new Scene(
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/contract-list-view.fxml")))
        ));
        stage.setTitle("Contracts List");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}