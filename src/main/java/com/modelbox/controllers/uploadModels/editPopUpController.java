package com.modelbox.controllers.uploadModels;

import com.modelbox.app;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import org.bson.Document;

public class editPopUpController {

    @FXML public StackPane editModelStackPane;
    @FXML public TextField modelNameTextField;
    @FXML public Text modelTypeText;
    @FXML public AnchorPane editInfoAnchorPane;
    @FXML public AnchorPane loadingAnchorPane;
    @FXML public Button saveAttributesBtn;

    /**
     * Closes and removes the edit pop-up from view
     *
     * @param event a JavaFX Event
     */
    @FXML
    private void closeEditPaneBtnClicked(Event event) {
        AnchorPane currentEditPopUp = (AnchorPane) ((Button) event.getSource()).getParent().getParent();
        app.verifyModelsView.verifyModelsAnchorPane.getChildren().remove(currentEditPopUp);
    }

    /**
     * Closes and removes the edit pop-up from view
     *
     * @param event a JavaFX Event
     */
    @FXML
    private void saveAttributesBtnClicked(Event event) {
        AnchorPane currentEditInfoPane = (AnchorPane) ((Button) event.getSource()).getParent();
        editInfoAnchorPane.setVisible(false);
        loadingAnchorPane.setVisible(true);

        int currentModelIndex = app.dashboard.getDocumentIndexByModelID(app.dashboard.verifyModelsList, currentEditInfoPane.getId());
        Document currentModelDocument = app.dashboard.verifyModelsList.get(currentModelIndex);

        currentModelDocument.remove("modelName");
        currentModelDocument.append("modelName", modelNameTextField.getText() + "." + modelTypeText.getText().toLowerCase());

        app.dashboard.verifyModelsList.remove(currentModelIndex);
        app.dashboard.verifyModelsList.add(currentModelDocument);

        loadingAnchorPane.setVisible(false);
        editInfoAnchorPane.setVisible(true);

        app.verifyModelsView.verifyModelsAnchorPane.getChildren().remove(currentEditInfoPane.getParent());
    }
}
