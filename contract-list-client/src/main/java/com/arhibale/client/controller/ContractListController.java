package com.arhibale.client.controller;

import com.arhibale.client.dto.ContractDto;
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
import java.util.ResourceBundle;

public class ContractListController implements Initializable {
    private final ObservableList<ContractDto> contractsOList = FXCollections.observableArrayList();

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
        initData();
        initColumn();
    }

    private void initData() {
        ContractDto contractDto = new ContractDto()
                .setId(1L)
                .setDate(LocalDateTime.now())
                .setContractNumber(228)
                .setLastUpdate(LocalDateTime.now())
                .setRelevance(true);
        contractsOList.add(contractDto);
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

    }
}
