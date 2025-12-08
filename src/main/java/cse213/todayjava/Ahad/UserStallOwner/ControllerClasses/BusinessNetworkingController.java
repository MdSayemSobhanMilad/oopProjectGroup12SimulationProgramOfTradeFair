package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import cse213.todayjava.Ahad.UserStallOwner.ModelClasses.NetworkingBusiness;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BusinessNetworkingController {


    @FXML private TextArea policiesArea;
    @FXML private TextField businessNameField;
    @FXML private TextField contactPersonField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextArea contactsTableView;
    @FXML private TextField statusTextField;


    private List<NetworkingBusiness> contactsList;
    private DateTimeFormatter dateFormatter;


    private final String DEFAULT_POLICIES = """
        BUSINESS NETWORKING POLICIES:
        
        1. Professional Conduct:
           - Always maintain professional behavior
           - Respect other businesses' time and resources
           
        2. Information Exchange:
           - Share only relevant business information
           - Keep contact details updated
           
        3. Collaboration Guidelines:
           - Seek mutual benefits in partnerships
           - Clearly define collaboration terms
           
        4. Privacy & Confidentiality:
           - Respect business confidentiality
           - Do not share sensitive information without consent
           
        5. Follow-up Protocol:
           - Follow up within 48 hours of initial contact
           - Maintain professional communication
        """;

    @FXML
    public void initialize() {

        contactsList = new ArrayList<>();
        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        policiesArea.setText(DEFAULT_POLICIES);
        policiesArea.setEditable(false);


        contactsTableView.setEditable(false);


        updateStatus("Ready to network");


        loadSampleContacts();
    }

    private void loadSampleContacts() {

        contactsList.add(new NetworkingBusiness("Tech Solutions Inc", "John Smith", "john@techsolutions.com", "123-456-7890"));
        contactsList.add(new NetworkingBusiness("Trade Fair Management", "Sarah Johnson", "sarah@tfm.com", "987-654-3210"));

        updateContactsDisplay();
    }

    @FXML
    private void addContactOnaction(ActionEvent event) {

        String businessName = businessNameField.getText().trim();
        String contactPerson = contactPersonField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();


        if (businessName.isEmpty() || contactPerson.isEmpty() || email.isEmpty()) {
            return;
        }


        NetworkingBusiness newContact = new NetworkingBusiness(businessName, contactPerson, email, phone);
        contactsList.add(newContact);


        updateContactsDisplay();


        businessNameField.clear();
        contactPersonField.clear();
        emailField.clear();
        phoneField.clear();
        updateStatus("Contact added: " + businessName);

    }

    @FXML
    private void backOnaction(ActionEvent event) {
        try {

            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/cse213/todayjava/Ahad/UserStallOwner/StallOwnerDashboard.fxml"
            ));

            Parent root = loader.load();


            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Navigation Error",
                    "Failed to load dashboard.\n" +
                            "Make sure StallOwnerDashboard.fxml exists in the correct location.\n" +
                            "Error: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }


    private void backOnactionAlternative(ActionEvent event) {
        try {

            String[] possiblePaths = {
                    "/cse213/todayjava/Ahad/UserStallOwner/StallOwnerDashboard.fxml",
                    "/StallOwnerDashboard.fxml",
                    "../StallOwnerDashboard.fxml",
                    "../../StallOwnerDashboard.fxml"
            };

            FXMLLoader loader = null;
            Parent root = null;


            for (String path : possiblePaths) {
                try {
                    loader = new FXMLLoader(getClass().getResource(path));
                    root = loader.load();
                    break;
                } catch (Exception ex) {
                    return;
                }
            }

            if (root != null) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Navigation failed: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void updateContactsDisplay() {
        StringBuilder displayText = new StringBuilder();
        displayText.append("BUSINESS CONTACTS LIST:\n");
        displayText.append("======================\n\n");

        int count = 1;
        for (NetworkingBusiness contact : contactsList) {
            displayText.append(count).append(". ").append(contact.getBusinessName())
                    .append("\n   Contact: ").append(contact.getContactPerson())
                    .append("\n   Email: ").append(contact.getEmail())
                    .append("\n   Phone: ").append(contact.getPhone())
                    .append("\n\n");
            count++;
        }

        if (contactsList.isEmpty()) {
            return;
        }

        contactsTableView.setText(displayText.toString());
    }

    private void updateStatus(String message) {
        String timestamp = LocalDateTime.now().format(dateFormatter);
        statusTextField.setText("[" + timestamp + "] " + message);
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public List<NetworkingBusiness> getContactsList() {
        return contactsList;
    }
}