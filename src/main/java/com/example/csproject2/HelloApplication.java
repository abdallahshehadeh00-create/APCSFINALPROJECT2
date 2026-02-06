package com.example.csproject2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Load CSS from the root of resources
        if (getClass().getResource("/LoginDesign.css") != null) {
            scene.getStylesheets().add(getClass().getResource("/LoginDesign.css").toExternalForm());
        }

        stage.setTitle("Pharmacy Management System - Login");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}