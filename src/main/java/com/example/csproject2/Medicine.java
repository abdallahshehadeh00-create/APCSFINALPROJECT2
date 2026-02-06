package com.example.csproject2;

import javafx.beans.property.*;

public class Medicine {
    // We use 'transient' so Gson ignores the JavaFX Property objects
    private transient IntegerProperty idProp;
    private transient StringProperty nameProp;
    private transient IntegerProperty stockProp;
    private transient DoubleProperty priceProp;

    // These are simple types that Gson can save easily
    private int id;
    private String name;
    private int stock;
    private double price;

    public Medicine(int id, String name, int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        initializeProperties();
    }

    // This helper connects the simple data to the TableView properties
    public void initializeProperties() {
        this.idProp = new SimpleIntegerProperty(id);
        this.nameProp = new SimpleStringProperty(name);
        this.stockProp = new SimpleIntegerProperty(stock);
        this.priceProp = new SimpleDoubleProperty(price);
    }

    // Getters for the TableView (Logic: if property is null, rebuild it)
    public IntegerProperty idProperty() {
        if (idProp == null) initializeProperties();
        return idProp;
    }
    public StringProperty nameProperty() {
        if (nameProp == null) initializeProperties();
        return nameProp;
    }
    public IntegerProperty stockProperty() {
        if (stockProp == null) initializeProperties();
        return stockProp;
    }
    public DoubleProperty priceProperty() {
        if (priceProp == null) initializeProperties();
        return priceProp;
    }

    // Standard Getters for logic
    public int getId() { return id; }
    public String getName() { return name; }
}