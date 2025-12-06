package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.Ahad.UserTicketCounterStaff.RegulationsInform;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InformRegulationsController {
    @javafx.fxml.FXML
    private CheckBox guidelinessCheckBox;
    @javafx.fxml.FXML
    private TextArea explanationTextArea;
    @javafx.fxml.FXML
    private TextArea entryRulesTextArea;
    @javafx.fxml.FXML
    private TextField statusTextField;

    private RegulationsInform regulations;

    @javafx.fxml.FXML
    public void initialize() {
        regulations = new RegulationsInform();
        entryRulesTextArea.setText(regulations.getOfficialRules());
        statusTextField.setText("Ready");
        entryRulesTextArea.setEditable(false);
    }

    @javafx.fxml.FXML
    public void saveOnaction(ActionEvent actionEvent) {
        String explanation = explanationTextArea.getText();

        if (explanation.isEmpty()) {
            statusTextField.setText("Please add explanation");
            return;
        }

        if (!guidelinessCheckBox.isSelected()) {
            statusTextField.setText("Please check compliance box");
            return;
        }

        regulations.setStaffExplanation(explanation);
        regulations.setGuidelinesViewed(true);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        regulations.setTimestamp(timestamp);

        regulations.setStatus("Saved to Compliance Log");
        statusTextField.setText("Saved - " + timestamp);

        System.out.println("=== Compliance Log Entry ===");
        System.out.println(regulations.getComplianceRecord());
        System.out.println("===========================");
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/ticketCounterStaffDashboard.fxml", actionEvent);
    }
}