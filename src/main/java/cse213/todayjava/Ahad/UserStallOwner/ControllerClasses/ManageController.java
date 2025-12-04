package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ManageController
{
    @javafx.fxml.FXML
    private TextField productNameField;
    @javafx.fxml.FXML
    private TableColumn quantityColumn;
    @javafx.fxml.FXML
    private TableColumn nameColumn;
    @javafx.fxml.FXML
    private TextField priceField;
    @javafx.fxml.FXML
    private TableView productTable;
    @javafx.fxml.FXML
    private TextField quantityField;
    @javafx.fxml.FXML
    private TableColumn priceColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void editOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void removeOnaction(ActionEvent actionEvent) {
    }
}