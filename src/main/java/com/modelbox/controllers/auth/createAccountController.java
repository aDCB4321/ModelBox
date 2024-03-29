package com.modelbox.controllers.auth;

import com.modelbox.app;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.util.prefs.Preferences;

/**
 * Provides a JavaFX controller implementation for the createAccount.fxml view
 */
public class createAccountController {

    @FXML public TextField firstNameField;
    @FXML public TextField lastNameField;
    @FXML public TextField emailField;
    @FXML public PasswordField passField;
    @FXML public PasswordField confirmPassField;
    @FXML public AnchorPane createAccountForm;
    @FXML public AnchorPane createAccountInstructions;
    @FXML public TextField createAccountErrorField;
    @FXML public Text confirmSubHeading1;
    @FXML public Text confirmSubHeading2;
    @FXML private Button loginBtn;

    /**
     * Handles the creation of a user account when the create account button is clicked
     * @param event a JavaFX Event
     */
    @FXML
    private void createAccountBtnClicked(Event event) {
        createNewUserAccount();
    }

    /**
     * Handles the creation of a user account when the enter key is pressed on the last field
     * @param event a JavaFX KeyEvent
     */
    @FXML
    private void createAccountEnterKeyPressed(KeyEvent event) {
        if (event.getCode().equals((KeyCode.ENTER))) {
            createNewUserAccount();
        }
    }

    /**
     * Creates a new user account using the information provided and modifies the view accordingly
     */
    private void createNewUserAccount() {
        try {
            // Save the other create account fields so they can be added to the users custom_data object
            Preferences prefs = Preferences.userRoot().node("/com/modelbox");
            prefs.put("displayName", firstNameField.getText() + " " + lastNameField.getText());
            prefs.put("firstName", firstNameField.getText());
            prefs.put("lastName", lastNameField.getText());

            String functionCall = String.format("ModelBox.Auth.registerNewUser('%s', '%s', '%s', '%s', '%s');",
                    firstNameField.getText(), lastNameField.getText(), emailField.getText(), passField.getText(), confirmPassField.getText());
            app.mongoApp.eval(functionCall);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Handles the UI redirect to the 'Log In' view
     * @param event a JavaFX Event
     */
    @FXML
    private void loginBtnClicked(Event event) {
        try {
            app.viewLoader = new FXMLLoader(getClass().getResource("/views/auth/login.fxml"));
            Parent root = app.viewLoader.load();
            app.loginView = app.viewLoader.getController();
            loginBtn.getScene().setRoot(root);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
