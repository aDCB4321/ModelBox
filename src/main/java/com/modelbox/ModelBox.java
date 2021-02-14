package com.modelbox;

import com.modelbox.controllers.dashboardController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class ModelBox extends Application {
    public void start(Stage stage) throws Exception {
        dashboardController dashController = new dashboardController();
        FXMLLoader dashboardLoader = new FXMLLoader();
        dashboardLoader.setController(dashController);

        Parent root = dashboardLoader.load(getClass().getResource("/views/dashboard.fxml"));
        stage.setScene(new Scene(root, 1000, 650));
        stage.setMinWidth(1000);
        stage.setMinHeight(650);
        stage.show();
    }
}
