package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BusinessNetworkingController
{
    @javafx.fxml.FXML
    private TextField businessNameField;
    @javafx.fxml.FXML
    private TextField contactPersonField;
    @javafx.fxml.FXML
    private TextArea policiesArea;
    @javafx.fxml.FXML
    private TextField statusTextField;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private TextArea contactsTableView;
    @javafx.fxml.FXML
    private TextField phoneField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addContactOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }
}