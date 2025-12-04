package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ProductInformationController
{
    @javafx.fxml.FXML
    private TableColumn priceView;
    @javafx.fxml.FXML
    private TableColumn descriptionView;
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private TextArea inquiryNotesField;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn stockStatusView;
    @javafx.fxml.FXML
    private TableColumn productNameView;
    @javafx.fxml.FXML
    private TableColumn categoryView;
    @javafx.fxml.FXML
    private TextArea featuresArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchProductOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveInquiryOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);


    }
}