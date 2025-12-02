package cse213.todayjava;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.scene.control.*;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField usernameField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logIn(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("m") && password.equals("1234")) {
            SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserMaintenanceStaff/maintenanceDashboard.fxml", actionEvent);
        } else if (username.equals("s") && password.equals("1234")){
            SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/securityPersonnelDashboard.fxml", actionEvent);
        } else if (username.equals("st") && password.equals("1234")){
            SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
        }else if (username.equals("me") && password.equals("1234")){
            SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/user7Goal1.fxml", actionEvent);
        }
        else {
            label.setText("Username or password do not match");
        }
    }
}