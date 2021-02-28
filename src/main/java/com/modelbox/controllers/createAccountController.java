package com.modelbox.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class createAccountController {

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passField;
    @FXML private PasswordField confirmPassField;
    @FXML private Button createAccountBtn;
    @FXML private Button loginBtn;

    /**
     * Creates a new ModelBox user using the facilities provided from the auth package and redirects the UI
     * to the dashboard. The dashboard.fxml document is loaded and set as the root node of the current scene.
     * <p>
     * Note: The database is not yet connected to the application. Therefore, no actual account creation occurs.
     *
     * @param  e    a JavaFX event with the properties and methods of the element that triggered the event
     * @return      nothing of value is returned
     */
    @FXML
    private void createAccountBtnClicked(Event e) {
        // Load and show the login fxml document if the user already has an account
        loginController signInController = new loginController();
        FXMLLoader loginLoader = new FXMLLoader();
        loginLoader.setController(signInController);

        try {
            Parent root = loginLoader.load(getClass().getResource("/views/login.fxml"));
            loginBtn.getScene().setRoot(root);
        } catch (Exception fxmlLoadException){
            // Handle exception if fxml document fails to load and show properly
        }
    }

    /**
     * The application UI is redirected to the login view by loading and setting the login.fxml document as
     * the root node of the current scene.
     *
     * @param  e    a JavaFX event with the properties and methods of the element that triggered the event
     * @return      nothing of value is returned
     */
    @FXML
    private void loginBtnClicked(Event e) {
        // Load and show the login fxml document if the user already has an account
        loginController signInController = new loginController();
        FXMLLoader loginLoader = new FXMLLoader();
        loginLoader.setController(signInController);

        try {
            Parent root = loginLoader.load(getClass().getResource("/views/login.fxml"));
            loginBtn.getScene().setRoot(root);
        } catch (Exception fxmlLoadException){
            // Handle exception if fxml document fails to load and show properly
        }
    }
}
