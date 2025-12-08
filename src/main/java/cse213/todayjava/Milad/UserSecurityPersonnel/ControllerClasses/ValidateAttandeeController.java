package cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ValidateAttandeeController
{
    @javafx.fxml.FXML
    private TextArea validationTextArea;
    @javafx.fxml.FXML
    private TextField validateTF;
    @javafx.fxml.FXML
    private Label error;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void validateOnClick(ActionEvent actionEvent) {
        String validate = validateTF.getText();
        if (validate == null){
            error.setText("Please enter the id of the attendee.");
        }

        String temp = "" + validate.charAt(0) + validate.charAt(1);

        if (temp.equals("VA") || temp.equals("va")){
            validationTextArea.setText("Valid Attendee.");
        }else{
            validationTextArea.setText("Invalid Attendee.");
        }

    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/securityPersonnelDashboard.fxml", actionEvent);
    }
}