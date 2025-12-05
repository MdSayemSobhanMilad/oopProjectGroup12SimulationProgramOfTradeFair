package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import cse213.todayjava.Ahad.UserStallOwner.ModelClasses.SecuritySafety;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class SafetySecurityController {


    @FXML private TextArea securityGuidelinesTextArea;
    @FXML private CheckBox acknowledgeCheckBox;
    @FXML private ComboBox<String> incidentTypeCombo;
    @FXML private TextArea incidentDetailsArea;
    @FXML private TextArea recentAlertTextView;
    @FXML private TextField statusField;


    private ObservableList<SecuritySafety> incidentReports;
    private ObservableList<String> recentAlerts;


    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Random random = new Random();


    private final String DEFAULT_GUIDELINES = """
        SAFETY & SECURITY GUIDELINES:
        
        1. Always keep emergency exits clear and accessible
        2. Report any suspicious activity immediately
        3. Keep fire extinguishers visible and accessible
        4. Never leave valuable items unattended
        5. Follow proper electrical safety protocols
        6. Report any equipment malfunctions
        7. Keep first aid kit fully stocked
        8. Maintain clear pathways at all times
        9. Report any structural damage immediately
        10. Follow COVID-19 safety protocols if applicable
        
        EMERGENCY CONTACTS:
        • Security: 101
        • Fire Department: 102
        • Medical Emergency: 103
        • Maintenance: 104
        """;

    @FXML
    public void initialize() {
        incidentReports = FXCollections.observableArrayList();
        recentAlerts = FXCollections.observableArrayList();


        securityGuidelinesTextArea.setText(DEFAULT_GUIDELINES);
        securityGuidelinesTextArea.setEditable(false);


        ObservableList<String> incidentTypes = FXCollections.observableArrayList(
                "Suspicious Activity",
                "Fire Hazard",
                "Electrical Hazard",
                "Structural Damage",
                "Theft/Burglary",
                "Medical Emergency",
                "Equipment Failure",
                "Safety Violation",
                "Crowd Control Issue",
                "Other"
        );
        incidentTypeCombo.setItems(incidentTypes);


        recentAlertTextView.setEditable(false);


        statusField.setText("System Ready");
        statusField.setEditable(false);


        loadSampleAlerts();
    }

    private void loadSampleAlerts() {

        recentAlerts.add("[" + LocalDateTime.now().minusHours(2).format(formatter) + "] Security checkpoint completed - All clear");
        recentAlerts.add("[" + LocalDateTime.now().minusHours(4).format(formatter) + "] Fire extinguisher inspection passed");
        recentAlerts.add("[" + LocalDateTime.now().minusDays(1).format(formatter) + "] Safety audit completed - No issues found");

        updateRecentAlertsDisplay();
    }

    @FXML
    private void confirmOnaction(ActionEvent event) {
        if (acknowledgeCheckBox.isSelected()) {

            statusField.setText("Guidelines Acknowledged");
            statusField.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");


            String alert = "[" + LocalDateTime.now().format(formatter) + "] Safety guidelines acknowledged by user";
            recentAlerts.add(0, alert); // Add at beginning
            updateRecentAlertsDisplay();

            showAlert("Confirmation",
                    "Thank you for acknowledging the safety and security guidelines.",
                    Alert.AlertType.INFORMATION);


            acknowledgeCheckBox.setSelected(false);
        } else {
            showAlert("Warning",
                    "Please check the box to confirm you have read and understood the guidelines.",
                    Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void submitReportOnaction(ActionEvent event) {
        String incidentType = incidentTypeCombo.getValue();
        String details = incidentDetailsArea.getText().trim();


        if (incidentType == null || incidentType.isEmpty()) {
            showAlert("Error", "Please select an incident type.", Alert.AlertType.ERROR);
            incidentTypeCombo.requestFocus();
            return;
        }

        if (details.isEmpty()) {
            showAlert("Error", "Please provide incident details.", Alert.AlertType.ERROR);
            incidentDetailsArea.requestFocus();
            return;
        }


        String incidentId = "INC-" + String.format("%06d", random.nextInt(999999));
        SecuritySafety incident = new SecuritySafety(
                incidentId,
                incidentType,
                details,
                "STALL-001",
                "User"
        );


        incidentReports.add(incident);


        String alert = "[" + LocalDateTime.now().format(formatter) + "] " + incidentType + " reported - " + incidentId;
        recentAlerts.add(0, alert);
        updateRecentAlertsDisplay();


        statusField.setText("Report Submitted");

        incidentTypeCombo.setValue(null);
        incidentDetailsArea.clear();


        showAlert("Report Submitted",
                "Incident Report #" + incidentId + "\n" +
                        "Type: " + incidentType + "\n" +
                        "Status: Submitted for review\n" +
                        "Security team has been notified.",
                Alert.AlertType.INFORMATION);

        // Simulate security response
        simulateSecurityResponse(incidentId);
    }

    private void simulateSecurityResponse(String incidentId) {
        new Thread(() -> {
            try {
                Thread.sleep(3000); // Wait 3 seconds


                javafx.application.Platform.runLater(() -> {
                    String responseAlert = "[" + LocalDateTime.now().format(formatter) + "] Security team responding to " + incidentId;
                    recentAlerts.add(0, responseAlert);
                    updateRecentAlertsDisplay();

                    statusField.setText("Security Responding");
                });

                Thread.sleep(2000);

                javafx.application.Platform.runLater(() -> {
                    String resolvedAlert = "[" + LocalDateTime.now().format(formatter) + "] " + incidentId + " - Issue being addressed";
                    recentAlerts.add(0, resolvedAlert);
                    updateRecentAlertsDisplay();

                    statusField.setText("Issue Being Addressed");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    private void backOnaction(ActionEvent event) {
        try {

            if (event != null && event.getSource() != null) {

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/cse213/todayjava/Ahad/UserStallOwner/StallOwnerDashboard.fxml"
                ));

                Parent root = loader.load();
                Scene scene = new Scene(root);


                stage.setScene(scene);
                stage.show();
            } else {

                showAlert("Navigation Error", "Cannot navigate back: Invalid event", Alert.AlertType.ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Navigation Error",
                    "Failed to load StallOwnerDashboard.fxml\n" +
                            "Make sure the file exists at: /cse213/todayjava/Ahad/UserStallOwner/StallOwnerDashboard.fxml",
                    Alert.AlertType.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Failed to navigate back: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void updateRecentAlertsDisplay() {

        StringBuilder alertText = new StringBuilder();
        alertText.append("RECENT SECURITY ALERTS:\n");
        alertText.append("=====================\n\n");


        int count = Math.min(recentAlerts.size(), 5);
        for (int i = 0; i < count; i++) {
            alertText.append("• ").append(recentAlerts.get(i)).append("\n\n");
        }

        if (count == 0) {
            alertText.append("No recent alerts.\n");
            alertText.append("System Status: Normal\n");
        }

        recentAlertTextView.setText(alertText.toString());
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public ObservableList<SecuritySafety> getIncidentReports() {
        return incidentReports;
    }

    public ObservableList<String> getRecentAlerts() {
        return recentAlerts;
    }
}