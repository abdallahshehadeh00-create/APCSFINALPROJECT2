package com.example.csproject2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DashboardController {

    @FXML private TableView<Medicine> medicineTable;
    @FXML private TableColumn<Medicine, Integer> col_id;
    @FXML private TableColumn<Medicine, String> col_name;
    @FXML private TableColumn<Medicine, Integer> col_stock;
    @FXML private TableColumn<Medicine, Double> col_price;

    public void initialize() {
        // 1. Tell the columns which data to look for
        col_id.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        col_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        col_stock.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        col_price.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        // 2. Add some sample data
        ObservableList<Medicine> list = FXCollections.observableArrayList(
                new Medicine(1, "Paracetamol", 100, 5.50),
                new Medicine(2, "Amoxicillin", 50, 12.00),
                new Medicine(3, "Ibuprofen", 75, 8.25)
        );

        medicineTable.setItems(list);
    }
}