package com.example.csproject2;

import javafx.beans.property.*;

public class Medicine {
    
    private transient IntegerProperty idProp;
    private transient StringProperty nameProp;
    private transient IntegerProperty stockProp;
    private transient DoubleProperty priceProp;

    
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


    public void initializeProperties() {
        this.idProp = new SimpleIntegerProperty(id);
        this.nameProp = new SimpleStringProperty(name);
        this.stockProp = new SimpleIntegerProperty(stock);
        this.priceProp = new SimpleDoubleProperty(price);
    }


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


    public int getId() { return id; }
    public String getName() { return name; }
}