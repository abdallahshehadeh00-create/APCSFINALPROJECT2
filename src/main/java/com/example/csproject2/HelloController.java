package com.example.csproject2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class HelloController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button closeButton;

    @FXML
    protected void handleLogin() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (user.equals("admin") && pass.equals("admin123")) {
            try {

                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.close();


                FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                Parent root = loader.load();
                Stage dashboardStage = new Stage();
                Scene scene = new Scene(root);


                scene.getStylesheets().add(getClass().getResource("/LoginDesign.css").toExternalForm());

                dashboardStage.setTitle("Pharmacy System - Dashboard");
                dashboardStage.setScene(scene);
                dashboardStage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Wrong username or password!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleClose() {
        System.exit(0);
    }
}