package com.modelbox.controllers.auth;

import com.modelbox.app;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * Provides a JavaFX controller implementation for the forgotPassword.fxml view
 */
public class forgotPasswordController {

    @FXML public TextField emailField;
    @FXML public AnchorPane forgotPassPane;
    @FXML public Button sendEmailLoginBtn;
    @FXML private Button loginBtn;
    @FXML public AnchorPane sendResetEmailPrompt;
    @FXML public AnchorPane passwordResetInstructions;
    @FXML public TextField forgotPasswordErrorField;
    @FXML public Text forgotPasswordHeading;
    @FXML public Text forgotPasswordSubHeading;
    @FXML public Text logInPromptText;

    /**
     * Handles resetting the user's password when the reset password button is clicked
     * @param event a JavaFX Event
     */
    @FXML
    private void resetPassBtnClicked(Event event) {
        resetUserPassword();
    }

    /**
     * Handles resetting the user's password when the enter key is pressed on the last field
     * @param event a JavaFX KeyEvent
     */
    @FXML
    private void resetPassEnterKeyPressed(KeyEvent event) {
        if(event.getCode().equals((KeyCode.ENTER))) {
            resetUserPassword();
        }
    }

    /**
     * Reset the user's password using the information provided and modifies the view accordingly
     */
    private void resetUserPassword() {
        try {
            String functionCall = String.format("ModelBox.Auth.sendPasswordResetEmail('%s');", emailField.getText());
            app.mongoApp.eval(functionCall);
        } catch(Exception exception){
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
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
