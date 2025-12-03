package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ApplyDiscountsController
{
    @javafx.fxml.FXML
    private TextField iteamNameField;
    @javafx.fxml.FXML
    private TableColumn iteamNameView;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private ComboBox discountTypeField;
    @javafx.fxml.FXML
    private TableColumn amountView;
    @javafx.fxml.FXML
    private TextField amountField;
    @javafx.fxml.FXML
    private TableColumn discountTypeView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void checkOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);

    }
}