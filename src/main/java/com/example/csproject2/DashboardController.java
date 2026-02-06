package com.example.csproject2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

public class DashboardController {

    @FXML private TableView<Medicine> medicineTable;
    @FXML private TableColumn<Medicine, Integer> col_id;
    @FXML private TableColumn<Medicine, String> col_name;
    @FXML private TableColumn<Medicine, Integer> col_stock;
    @FXML private TableColumn<Medicine, Double> col_price;

    @FXML private TextField addName;
    @FXML private TextField addStock;
    @FXML private TextField addPrice;
    @FXML private TextField searchField; // We'll add this to FXML in a second!

    private ObservableList<Medicine> medicineList = FXCollections.observableArrayList();

    public void initialize() {
        // Map Table Columns
        col_id.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        col_name.setCellValueFactory(data -> data.getValue().nameProperty());
        col_stock.setCellValueFactory(data -> data.getValue().stockProperty().asObject());
        col_price.setCellValueFactory(data -> data.getValue().priceProperty().asObject());

        // Load data from JSON
        medicineList.addAll(JsonHandler.loadItems());

        // Setup Filtering (Excellent Pass: Efficient Algorithms)
        FilteredList<Medicine> filteredData = new FilteredList<>(medicineList, p -> true);

        if (searchField != null) {
            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(medicine -> {
                    if (newValue == null || newValue.isEmpty()) return true;
                    String lowerCaseFilter = newValue.toLowerCase();
                    return medicine.getName().toLowerCase().contains(lowerCaseFilter);
                });
            });
        }

        medicineTable.setItems(filteredData);
    }

    @FXML
    public void addMedicine() {
        if (addName.getText().isEmpty() || addStock.getText().isEmpty() || addPrice.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "All fields are required.");
            return;
        }

        try {
            int id = medicineList.isEmpty() ? 1 : medicineList.get(medicineList.size() - 1).getId() + 1;
            String name = addName.getText();
            int stock = Integer.parseInt(addStock.getText());
            double price = Double.parseDouble(addPrice.getText());

            Medicine newMed = new Medicine(id, name, stock, price);
            medicineList.add(newMed);

            // Save to JSON
            JsonHandler.saveItems(new ArrayList<>(medicineList));

            addName.clear(); addStock.clear(); addPrice.clear();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Stock and Price must be numbers.");
        }
    }

    @FXML
    public void deleteMedicine() {
        Medicine selected = medicineTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            medicineList.remove(selected);
            JsonHandler.saveItems(new ArrayList<>(medicineList));
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Selection", "Select an item to delete.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}