package com.arhibale.client.controller;

import com.arhibale.client.dto.ContractDto;
import com.arhibale.client.util.deserializer.ContractDeserializer;
import com.arhibale.client.util.http.HttpConnect;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class ContractListController implements Initializable {
    private ObservableList<ContractDto> contractsOList;
    private HttpConnect httpConnect;

    @FXML
    private TableView<ContractDto> contractTable;

    @FXML
    private TableColumn<ContractDto, Long> idColumn;
    @FXML
    private TableColumn<ContractDto, LocalDateTime> dateColumn;
    @FXML
    private TableColumn<ContractDto, Integer> numberColumn;
    @FXML
    private TableColumn<ContractDto, LocalDateTime> updateColumn;
    @FXML
    private TableColumn<ContractDto, Boolean> relevanceColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contractsOList = FXCollections.observableArrayList();
        httpConnect = new HttpConnect();

        initData();
        initColumn();
    }

    private void initData() {
        List<ContractDto> list = httpConnect.getListContracts();
        if (list == null) {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Список контрактов");
                alert.setHeaderText("Список контрактов пуст");
                alert.setContentText("Ошибка при получении данных");
                alert.show();
            });
        } else {
            contractsOList.addAll(list);
        }
    }

    private void initColumn() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("contractNumber"));
        updateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        relevanceColumn.setCellValueFactory(new PropertyValueFactory<>("relevance"));
        relevanceColumn.setCellFactory(cv -> new CheckBoxTableCell<>());
        contractTable.setItems(contractsOList);
    }

    @FXML
    private void onRefresh(ActionEvent actionEvent) {
        contractsOList.clear();
        initData();
    }
}