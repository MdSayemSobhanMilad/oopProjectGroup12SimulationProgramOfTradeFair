package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import cse213.todayjava.Ahad.UserStallOwner.ProductPrepare;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.io.IOException;

public class PrepareController {

    @javafx.fxml.FXML
    private TextField stallNameField;
    @javafx.fxml.FXML
    private TextField shiftTimeField;
    @javafx.fxml.FXML
    private CheckBox lightingCheck;
    @javafx.fxml.FXML
    private TextField stallNumberField;
    @javafx.fxml.FXML
    private TextArea detailsTextarea;
    @javafx.fxml.FXML
    private CheckBox tablesCheck;
    @javafx.fxml.FXML
    private Label successAndAllertMessage;
    @javafx.fxml.FXML
    private CheckBox powerCheck;
    @javafx.fxml.FXML
    private CheckBox shelvesCheck;
    @javafx.fxml.FXML
    private TextField staffCountField;
    @javafx.fxml.FXML
    private TextField stallLocationField;

    private ProductPrepare stall = new ProductPrepare();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        successAndAllertMessage.setText("");

        String stallName = stallNameField.getText();
        String stallNumber = stallNumberField.getText();
        String stallLocation = stallLocationField.getText();
        String staffCount = staffCountField.getText();
        String shiftTime = shiftTimeField.getText();
        boolean tablesReady = tablesCheck.isSelected();
        boolean shelvesReady = shelvesCheck.isSelected();
        boolean lightingReady = lightingCheck.isSelected();
        boolean powerReady = powerCheck.isSelected();
        String notes = detailsTextarea.getText();

        stall.populateFromForm(stallName, stallNumber, stallLocation,
                staffCount, shiftTime,
                tablesReady, shelvesReady, lightingReady, powerReady,
                notes);

        if (stall.validateForm()) {
            String summary = stall.generateSummary();
            detailsTextarea.setText(summary);
            successAndAllertMessage.setText("Stall is ready for customers!");
        } else {
            successAndAllertMessage.setText(stall.getStatusMessage());
        }
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }
}