package cse213.todayjava.Arabi.UserMediaPromoter;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class promoteSponsorContentControllerClass {

    @FXML
    private TextField selectSponsorTextField;

    @FXML
    private TextArea containtDetailsTextArea;

    @FXML
    private RadioButton approveRadioButton;

    @FXML
    private RadioButton rejectRadioButton;

    @FXML
    private TableView<SponsorContent> promoteSponsorContentTableView;

    @FXML
    private TableColumn<SponsorContent, String> selectSponsorTableColumn;

    @FXML
    private TableColumn<SponsorContent, String> containtDetailsTableColumn;

    @FXML
    private TableColumn<SponsorContent, String> approvalTableColumn;

    @FXML
    private Label statusLabel;


    private ToggleGroup approvalToggleGroup;


    private ObservableList<SponsorContent> sponsorContentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Promote Sponsor Content Controller Initialized!");


        approvalToggleGroup = new ToggleGroup();
        approveRadioButton.setToggleGroup(approvalToggleGroup);
        rejectRadioButton.setToggleGroup(approvalToggleGroup);


        selectSponsorTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getSelectSponsor()));

        containtDetailsTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getContaintDetails()));

        approvalTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getApproval()));


        promoteSponsorContentTableView.setItems(sponsorContentList);


        statusLabel.setText("");
    }

    @FXML
    private void publishContentOnClick() {
        System.out.println("Publish Content button clicked!");


        String selectSponsor = selectSponsorTextField.getText();
        String containtDetails = containtDetailsTextArea.getText();


        String approval = "";
        if (approveRadioButton.isSelected()) {
            approval = "Approve";
        } else if (rejectRadioButton.isSelected()) {
            approval = "Reject";
        }


        if (!selectSponsor.isEmpty() && !containtDetails.isEmpty() && !approval.isEmpty()) {

            SponsorContent newContent = new SponsorContent(selectSponsor, containtDetails, approval);


            sponsorContentList.add(newContent);


            statusLabel.setText("Successful");
            System.out.println("New sponsor content added to table: " + newContent);


            clearFields();
        }

        else {

            statusLabel.setText("Failed");
            System.out.println("Failed - Some fields are empty or radio button not selected!");


        }
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button clicked!");


        sponsorContentList.clear();
        System.out.println("Table data cleared!");


        statusLabel.setText("");


        clearFields();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/mediaPromoterDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        selectSponsorTextField.clear();
        containtDetailsTextArea.clear();
        approvalToggleGroup.selectToggle(null);
    }
}