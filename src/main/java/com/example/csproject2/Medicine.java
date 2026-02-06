package com.example.csproject2;

import javafx.beans.property.*;

public class Medicine {
    private final IntegerProperty id;
    private final StringProperty name;
    private final IntegerProperty stock;
    private final DoubleProperty price;

    public Medicine(int id, String name, int stock, double price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.stock = new SimpleIntegerProperty(stock);
        this.price = new SimpleDoubleProperty(price);
    }

    // Getters for TableView to read data
    public IntegerProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public IntegerProperty stockProperty() { return stock; }
    public DoubleProperty priceProperty() { return price; }
}