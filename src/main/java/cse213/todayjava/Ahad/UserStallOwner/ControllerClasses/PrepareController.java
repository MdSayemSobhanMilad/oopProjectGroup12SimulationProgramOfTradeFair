package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.Ahad.UserStallOwner.PrepareStall;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrepareController {
    // Text fields from FXML
    @FXML private TextField stallNameField;
    @FXML private TextField stallNumberField;
    @FXML private TextField stallLocationField;
    @FXML private TextField staffCountField;
    @FXML private TextField shiftTimeField;

    // Checkboxes from FXML
    @FXML private CheckBox tablesCheck;
    @FXML private CheckBox shelvesCheck;
    @FXML private CheckBox lightingCheck;
    @FXML private CheckBox powerCheck;

    // Text area and label from FXML
    @FXML private TextArea detailsTextarea;
    @FXML private Label successAndAllertMessage;

    // Our stall object
    private PrepareStall stall;

    @FXML
    public void initialize() {
        // Create a new stall object when the screen loads
        stall = new PrepareStall();

        // Clear any previous messages
        successAndAllertMessage.setText("");
    }

    @FXML
    public void submitButton(ActionEvent actionEvent) {
        // Step 1: Get all the values from the form
        String stallName = stallNameField.getText().trim();
        String stallNumber = stallNumberField.getText().trim();
        String location = stallLocationField.getText().trim();
        String staffCountText = staffCountField.getText().trim();
        String shiftTime = shiftTimeField.getText().trim();

        // Step 2: Check if required fields are filled
        if (stallName.isEmpty() || stallNumber.isEmpty() || location.isEmpty() ||
                staffCountText.isEmpty() || shiftTime.isEmpty()) {

            successAndAllertMessage.setText("Please fill all fields!");
            successAndAllertMessage.setStyle("-fx-text-fill: red;");
            return;
        }

        // Step 3: Check if staff count is a valid number
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

        // Step 4: Save all data to our stall object
        stall.setStallName(stallName);
        stall.setStallNumber(stallNumber);
        stall.setLocation(location);
        stall.setStaffCount(staffCount);
        stall.setShiftTime(shiftTime);

        // Save checkbox values
        stall.setTablesReady(tablesCheck.isSelected());
        stall.setShelvesOrganized(shelvesCheck.isSelected());
        stall.setLightingAdequate(lightingCheck.isSelected());
        stall.setPowerConnected(powerCheck.isSelected());

        // Step 5: Show all details in the text area
        String allDetails = stall.getAllDetails();
        detailsTextarea.setText(allDetails);

        // Step 6: Show success message
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