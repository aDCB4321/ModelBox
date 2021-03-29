package com.modelbox.controllers.account;

import com.modelbox.app;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class settingsController {

    @FXML private Button accountSettingsBtn;
    @FXML private Button accountSecurityBtn;
    @FXML private Button changeEmailBtn;
    @FXML public TextField displayNameTextField;
    @FXML private AnchorPane accountSettingsAnchorPane;
    @FXML private AnchorPane accountSecurityAnchorPane;
    @FXML private AnchorPane changeEmailAnchorPane;
    @FXML public Circle settingsPictureImage;
    @FXML private TextField newEmailField;
    @FXML private TextField changeEmailErrorField;
    @FXML private Button changeEmailButton;
    @FXML private Button deleteAccountBtn;
    @FXML private TextField emailAddressDeleteAccountField;
    @FXML private TextField deleteAccountErrorField;
    @FXML public AnchorPane settingsContentAnchorPane;
    @FXML public AnchorPane loadingAnchorPane;

    /**
     *   Sets the account settings pane as visible
     *
     *   @param event a JavaFX Event
     */
    @FXML
    private void accountSettingsBtnClicked(Event event) {
        accountSecurityAnchorPane.setVisible(false);
        changeEmailAnchorPane.setVisible(false);
        accountSettingsAnchorPane.setVisible(true);
        changeEmailErrorField.setVisible(false);
        deleteAccountErrorField.setVisible(false);
        emailAddressDeleteAccountField.setText("");

        app.settingsView.accountSettingsBtn.setStyle("-fx-background-color: #D3D3D3; -fx-border-color: #868686; -fx-border-radius: 5 5 0 0; -fx-alignment: center-left;");
        app.settingsView.accountSecurityBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 0 0 0 0; -fx-alignment: center-left;");
        app.settingsView.changeEmailBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 0 0 5 5; -fx-alignment: center-left;");
    }

    /**
     *   Sets the account security pane as visible.
     *
     *   @param event a JavaFX Event
     */
    @FXML
    private void accountSecurityBtnClicked(Event event) {
        accountSettingsAnchorPane.setVisible(false);
        changeEmailAnchorPane.setVisible(false);
        accountSecurityAnchorPane.setVisible(true);
        changeEmailErrorField.setVisible(false);
        deleteAccountErrorField.setVisible(false);

        app.settingsView.accountSecurityBtn.setStyle("-fx-background-color: #D3D3D3; -fx-border-color: #868686; -fx-border-radius: 0 0 0 0; -fx-alignment: center-left;");
        app.settingsView.accountSettingsBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 5 5 0 0; -fx-alignment: center-left;");
        app.settingsView.changeEmailBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius:  0 0 5 5; -fx-alignment: center-left;");
    }

    @FXML
    private void changeEmailBtnClicked(Event event) {
        accountSecurityAnchorPane.setVisible(false);
        accountSettingsAnchorPane.setVisible(false);
        changeEmailAnchorPane.setVisible(true);
        changeEmailErrorField.setVisible(false);
        deleteAccountErrorField.setVisible(false);
        newEmailField.setText("");

        app.settingsView.changeEmailBtn.setStyle("-fx-background-color: #D3D3D3; -fx-border-color: #868686; -fx-border-radius: 0 0 5 5; -fx-alignment: center-left;");
        app.settingsView.accountSettingsBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 5 5 0 0; -fx-alignment: center-left;");
        app.settingsView.accountSecurityBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #868686; -fx-border-radius: 0 0 0 0; -fx-alignment: center-left;");
    }

    @FXML
    private void changeEmailButtonClicked(Event event) {
        changeUsersEmail();
    }

    @FXML
    private void changeEmailEnterKeyPressed(KeyEvent event) {
        if(event.getCode().equals((KeyCode.ENTER))) {
            changeUsersEmail();
        }
    }

    private void changeUsersEmail(){
        try {

        } catch(Exception exception){
            // Handle errors
            exception.printStackTrace();
        }
    }

    @FXML
    private void deleteAccountBtnClicked(Event event) {
        deleteUsersAccount();
    }

    @FXML
    private void deleteConfirmPassField(KeyEvent event) {
        if(event.getCode().equals((KeyCode.ENTER))) {
            deleteUsersAccount();
        }
    }

    private void deleteUsersAccount() {
        try {

        } catch(Exception exception){
            // Handle errors
            exception.printStackTrace();
        }
    }

}
