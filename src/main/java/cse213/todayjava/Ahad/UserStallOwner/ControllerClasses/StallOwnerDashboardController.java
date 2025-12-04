package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StallOwnerDashboardController {
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logOutOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/login.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void prepareStall(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/prepare-stall.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void manageProductOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/manage-products.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void productInfoOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/product-information.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void customerDiscountOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/apply-discounts.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void salesTransactionsOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/sales-reporting.fxml", actionEvent);


    }

    @javafx.fxml.FXML
    public void maintainStallOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/maintain-stall.fxml", actionEvent);

    }
}