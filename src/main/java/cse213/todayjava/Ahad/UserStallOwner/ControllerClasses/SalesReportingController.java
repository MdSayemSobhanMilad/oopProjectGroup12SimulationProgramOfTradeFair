package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SalesReportingController
{
    @javafx.fxml.FXML
    private TextField priceField;
    @javafx.fxml.FXML
    private ComboBox paymenentMethodCB;
    @javafx.fxml.FXML
    private TextArea changeDueField;
    @javafx.fxml.FXML
    private TextField productFiled;
    @javafx.fxml.FXML
    private TextArea receiptTextArea;
    @javafx.fxml.FXML
    private TextArea cashReceivedField;
    @javafx.fxml.FXML
    private TextField quantityFiled;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void checkOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void receiptInfoOnaction(ActionEvent actionEvent) throws IOException {
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }
}