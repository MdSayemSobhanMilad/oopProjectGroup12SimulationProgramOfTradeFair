package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.Ahad.UserStallOwner.PrepareStall;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrepareController {

    @FXML private TextField stallNameField;
    @FXML private TextField stallNumberField;
    @FXML private TextField stallLocationField;
    @FXML private TextField staffCountField;
    @FXML private TextField shiftTimeField;


    @FXML private CheckBox tablesCheck;
    @FXML private CheckBox shelvesCheck;
    @FXML private CheckBox lightingCheck;
    @FXML private CheckBox powerCheck;


    @FXML private TextArea detailsTextarea;
    @FXML private Label successAndAllertMessage;


    private PrepareStall stall;

    @FXML
    public void initialize() {

        stall = new PrepareStall();



    }

    @FXML
    public void submitButton(ActionEvent actionEvent) {

        String stallName = stallNameField.getText().trim();
        String stallNumber = stallNumberField.getText().trim();
        String location = stallLocationField.getText().trim();
        String staffCountText = staffCountField.getText().trim();
        String shiftTime = shiftTimeField.getText().trim();


        if (stallName.isEmpty() || stallNumber.isEmpty() || location.isEmpty() ||
                staffCountText.isEmpty() || shiftTime.isEmpty()) {

            successAndAllertMessage.setText("Please fill all fields!");
            successAndAllertMessage.setStyle("-fx-text-fill: red;");
            return;
        }


        int staffCount;
        try {
            staffCount = Integer.parseInt(staffCountText);
            if (staffCount <= 0) {
                successAndAllertMessage.setText("Staff count must be positive!");
                successAndAllertMessage.setStyle("-fx-text-fill: red;");
                return;
            }
        } catch (NumberFormatException e) {
            successAndAllertMessage.setText("Enter valid number for staff!");
            successAndAllertMessage.setStyle("-fx-text-fill: red;");
            return;
        }


        stall.setStallName(stallName);
        stall.setStallNumber(stallNumber);
        stall.setLocation(location);
        stall.setStaffCount(staffCount);
        stall.setShiftTime(shiftTime);


        stall.setTablesReady(tablesCheck.isSelected());
        stall.setShelvesOrganized(shelvesCheck.isSelected());
        stall.setLightingAdequate(lightingCheck.isSelected());
        stall.setPowerConnected(powerCheck.isSelected());


        String allDetails = stall.getAllDetails();
        detailsTextarea.setText(allDetails);


        successAndAllertMessage.setText("Stall details submitted successfully!");

    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            // Go back to previous screen
            SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
        } catch (Exception e) {
            successAndAllertMessage.setText("Error: Cannot go back!");
            successAndAllertMessage.setStyle("-fx-text-fill: red;");
        }
    }
}