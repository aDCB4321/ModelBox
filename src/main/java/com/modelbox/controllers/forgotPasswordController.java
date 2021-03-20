package com.modelbox.controllers;

import com.modelbox.auth.forgotPassword;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class forgotPasswordController {

    public static forgotPassword activeForgotPassword;
    @FXML private TextField emailField;
    @FXML private Button resetPassBtn;
    @FXML private TextField forgotPasswordErrorField;

    /**
     * Handles resetting the user's password when the reset password button is clicked
     *
     * @param  event a JavaFX Event
     */
    @FXML
    private void resetPassBtnClicked(Event event) {
        resetUserPassword();
    }

    /**
     * Handles resetting the user's password when the enter key is pressed on the last field
     *
     * @param  event  a JavaFX KeyEvent
     */
    @FXML
    private void resetPassEnterKeyPressed(KeyEvent event) {
        if(event.getCode().equals((KeyCode.ENTER))) {
            resetUserPassword();
        }
    }

    /**
     * Attempts to reset the user's password using the information provided in the forgotPassword view
     * and modifies the view accordingly to handle errors
     *
     */
    private void resetUserPassword() {
        try {
            activeForgotPassword = new forgotPassword();
            activeForgotPassword.setEmailAddress(emailField == null ? "" : emailField.getText());

            if (activeForgotPassword.didVerificationsPass()) {
                forgotPasswordErrorField.setVisible(false);

                // Attempt to reset the user's password
                if (activeForgotPassword.sendPasswordResetEmail() == 0) {

                    // Redirect to the login
                    FXMLLoader loginLoader = new FXMLLoader();
                    Parent root = loginLoader.load(getClass().getResource("/views/resetpasswordSent.fxml"));
                    resetPassBtn.getParent().getScene().setRoot(root);

                } else {
                    forgotPasswordErrorField.setText("Attempt to reset password was unsuccessful. Try again!");
                    forgotPasswordErrorField.setVisible(true);

                    // Clear the form and let the user try again
                    emailField.setText("");
                }
            } else {
                forgotPasswordErrorField.setText(activeForgotPassword.getForgotPasswordErrorMessage());
                forgotPasswordErrorField.setVisible(true);
            }
        } catch(Exception exception){
            // Handle errors
            exception.printStackTrace();
        }
    }

}
