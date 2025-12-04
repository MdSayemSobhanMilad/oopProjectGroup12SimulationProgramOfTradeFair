package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SafetySecurityController
{
    @javafx.fxml.FXML
    private TextArea securityGuidelinesTextArea;
    @javafx.fxml.FXML
    private TextArea recentAlertTextView;
    @javafx.fxml.FXML
    private ComboBox incidentTypeCombo;
    @javafx.fxml.FXML
    private TextField statusField;
    @javafx.fxml.FXML
    private CheckBox acknowledgeCheckBox;
    @javafx.fxml.FXML
    private TextArea incidentDetailsArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void confirmOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitReportOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);

    }
}