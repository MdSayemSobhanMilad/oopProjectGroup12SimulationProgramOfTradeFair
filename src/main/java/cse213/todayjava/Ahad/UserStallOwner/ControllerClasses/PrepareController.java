package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class PrepareController
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

    @Deprecated
    public void submitButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void backButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }

}