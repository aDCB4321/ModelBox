package com.modelbox.controllers.account;

import com.modelbox.app;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import java.util.prefs.Preferences;

/**
 * Provides a JavaFX controller implementation for the settings.fxml view
 */
public class settingsController {

    @FXML public AnchorPane settingsAnchorPane;
    @FXML public Button deleteAccountTabBtn;
    @FXML public Button changePasswordTabBtn;
    @FXML public Button changeEmailTabBtn;
    @FXML public TextField displayNameTextField;
    @FXML public AnchorPane deleteAccountAnchorPane;
    @FXML public AnchorPane changePasswordAnchorPane;
    @FXML public AnchorPane changeEmailAnchorPane;
    @FXML public Circle settingsPictureCircle;
    @FXML public HBox settingsPictureHBox;
    @FXML public ImageView settingsPictureImageView;
    @FXML public TextField changeAccountEmailField;
    @FXML public PasswordField changeEmailPasswordField;
    @FXML public TextField changeEmailErrorField;
    @FXML public TextField deleteAccountEmailField;
    @FXML public TextField deleteAccountErrorField;
    @FXML public AnchorPane settingsContentAnchorPane;
    @FXML public AnchorPane loadingAnchorPane;
    @FXML public AnchorPane deleteConfirmationPopUp;

    /**
     * Sets the change email pane as visible
     * @param event a JavaFX Event
     */
    @FXML
    private void changeEmailTabBtnClicked(Event event) {
        changePasswordAnchorPane.setVisible(false);
        deleteAccountAnchorPane.setVisible(false);
        changeEmailAnchorPane.setVisible(true);
        changeEmailErrorField.setVisible(false);
        deleteAccountErrorField.setVisible(false);
        changeAccountEmailField.setText("");
        changeEmailPasswordField.setText("");

        app.settingsView.changeEmailTabBtn.setStyle("-fx-background-color: #eeeeee; -fx-border-color: #868686; -fx-background-radius: 5 5 0 0; -fx-border-radius: 5 5 0 0; -fx-alignment: center-left;");
        app.settingsView.deleteAccountTabBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 0 0 5 5; -fx-alignment: center-left;");
        app.settingsView.changePasswordTabBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 0 0 0 0; -fx-alignment: center-left;");
    }

    /**
     * Sets the change password pane as visible
     * @param event a JavaFX Event
     */
    @FXML
    private void changePasswordTabBtnClicked(Event event) {
        deleteAccountAnchorPane.setVisible(false);
        changeEmailAnchorPane.setVisible(false);
        changePasswordAnchorPane.setVisible(true);
        changeEmailErrorField.setVisible(false);
        deleteAccountErrorField.setVisible(false);

        app.settingsView.changePasswordTabBtn.setStyle("-fx-background-color: #eeeeee; -fx-border-color: #868686; -fx-border-radius: 0 0 0 0; -fx-alignment: center-left;");
        app.settingsView.deleteAccountTabBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 0 0 5 5; -fx-alignment: center-left;");
        app.settingsView.changeEmailTabBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius:  5 5 0 0; -fx-alignment: center-left;");
    }

    /**
     * Sets the delete account pane as visible
     * @param event a JavaFX Event
     */
    @FXML
    private void deleteAccountTabBtnClicked(Event event) {
        changePasswordAnchorPane.setVisible(false);
        changeEmailAnchorPane.setVisible(false);
        deleteAccountAnchorPane.setVisible(true);
        changeEmailErrorField.setVisible(false);
        deleteAccountErrorField.setVisible(false);
        deleteAccountEmailField.setText("");

        app.settingsView.deleteAccountTabBtn.setStyle("-fx-background-color: #eeeeee; -fx-border-color: #868686; -fx-background-radius: 0 0 5 5; -fx-border-radius: 0 0 5 5; -fx-alignment: center-left;");
        app.settingsView.changePasswordTabBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 0 0 0 0; -fx-alignment: center-left;");
        app.settingsView.changeEmailTabBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 5 5 0 0; -fx-alignment: center-left;");
    }

    /**
     * Handles issuing a confirmation email for the new email address when the button is clicked
     * @param event a JavaFX Event
     */
    @FXML
    private void changeEmailButtonClicked(Event event) {
        changeCurrentUserEmail();
    }

    /**
     * Handles issuing a confirmation email for the new email address when the enter key is pressed
     * @param event a JavaFX KeyEvent
     */
    @FXML
    private void changeEmailEnterKeyPressed(KeyEvent event) {
        if(event.getCode().equals((KeyCode.ENTER))) {
            changeCurrentUserEmail();
        }
    }

    /**
     * Changes the current user's email address
     */
    private void changeCurrentUserEmail(){
        try {
            changeEmailErrorField.setVisible(false);

            // Save the current user's owner_id for future manipulation
            Preferences prefs = Preferences.userRoot().node("/com/modelbox");
            prefs.put("owner_id", app.users.ownerId);

            String functionCall = String.format("ModelBox.Auth.changeCurrentUserEmail('%s', '%s');", changeAccountEmailField.getText(), changeEmailPasswordField.getText());
            app.mongoApp.eval(functionCall);
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * Logs the user out and redirects the user to use the 'Forgot Password' view to change their password
     */
    @FXML
    private void changePasswordBtnClicked(){
        try {
            String functionCall = "ModelBox.Auth.changeCurrentUserPassword();";
            app.mongoApp.eval(functionCall);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * Launches a delete account confirmation pop-up to confirm the action before proceeding
     * @param event a JavaFX event
     */
    @FXML
    private void deleteAccountBtnClicked(Event event) {
        deleteAccountErrorField.setVisible(false);
        deleteConfirmationPopUp.setVisible(true);
    }

    /**
     * Launches a delete account confirmation pop-up to confirm the action before proceeding
     * @param event a JavaFX event
     */
    @FXML
    private void deleteAccountEnterKeyPressed(KeyEvent event) {
        if(event.getCode().equals((KeyCode.ENTER))) {
            deleteAccountErrorField.setVisible(false);
            deleteConfirmationPopUp.setVisible(true);
        }
    }

    /**
     * Deletes the current user from the app and schedules all of their data for permanent deletion
     * @param event a JavaFX event
     */
    @FXML
    private void deleteConfirmationBtnClicked(Event event) {
        try {
            String functionCall = String.format("ModelBox.Auth.deleteCurrentUser('%s');", deleteAccountEmailField.getText());
            app.mongoApp.eval(functionCall);
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * Closes and removes the delete account confirmation pop-up from view
     * @param event a JavaFX event
     */
    @FXML
    private void closeConfirmationBtnClicked(Event event) {
        deleteAccountErrorField.setVisible(false);
        deleteConfirmationPopUp.setVisible(false);
        deleteAccountEmailField.setText("");
    }
}
