package cse213.todayjava.Arabi.UserMediaPromoter;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class coordinateWithSecurityControllerClass {

    @FXML
    private TextField securityUpdatesTextField;

    @FXML
    private TextArea securityInfoTextArea;

    @FXML
    private TextField createAnnouncementTextField;

    @FXML
    private ListView<String> coordinateWithSecurityListView;

    @FXML
    private Label statusLabel;


    private ObservableList<String> securityList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Coordinate With Security Controller Initialized!");


        coordinateWithSecurityListView.setItems(securityList);


        statusLabel.setText("");
    }

    @FXML
    private void submitOnClick() {
        System.out.println("Submit button clicked!");


        String securityUpdates = securityUpdatesTextField.getText();
        String securityInfo = securityInfoTextArea.getText();
        String createAnnouncement = createAnnouncementTextField.getText();


        if (!securityUpdates.isEmpty() && !securityInfo.isEmpty() && !createAnnouncement.isEmpty()) {

            SecurityCoordinator newCoordinator = new SecurityCoordinator(securityUpdates, securityInfo, createAnnouncement);


            securityList.add(newCoordinator.toString());


            statusLabel.setText("successful");
            System.out.println("New security coordination added to list!");


            clearFields();
        }

        else {

            statusLabel.setText("failed");
            System.out.println("Failed - Some fields are empty!");


        }
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button clicked!");


        securityList.clear();
        System.out.println("List data cleared!");


        statusLabel.setText("");


        clearFields();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/mediaPromoterDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        securityUpdatesTextField.clear();
        securityInfoTextArea.clear();
        createAnnouncementTextField.clear();
    }
}