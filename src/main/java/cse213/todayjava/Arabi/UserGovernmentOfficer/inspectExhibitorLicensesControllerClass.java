package cse213.todayjava.Arabi.UserGovernmentOfficer;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class inspectExhibitorLicensesControllerClass {

    @FXML
    private TextField exhibitorNameTextFied;

    @FXML
    private TextField licenseNumberTextField;

    @FXML
    private TextField stallNoTextField;

    @FXML
    private TableView<ExhibitorLicense> inspectExhibitorLicensesTableView;

    @FXML
    private TableColumn<ExhibitorLicense, String> exhibitorNameTableColumn;

    @FXML
    private TableColumn<ExhibitorLicense, String> stallNoTableColumn;

    @FXML
    private TableColumn<ExhibitorLicense, String> licenseNumberTableColumn;

    @FXML
    private Label statusLabel;


    private ObservableList<ExhibitorLicense> tempDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        exhibitorNameTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getExhibitorName()));

        stallNoTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getStallNo()));

        licenseNumberTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getLicenseNumber()));


        inspectExhibitorLicensesTableView.getItems().clear();
    }

    @FXML
    private void approveOnClick() {

        String exhibitorName = exhibitorNameTextFied.getText();
        String stallNo = stallNoTextField.getText();
        String licenseNumber = licenseNumberTextField.getText();


        if (!exhibitorName.isEmpty() && !stallNo.isEmpty() && !licenseNumber.isEmpty()) {

            tempDataList.clear();
            inspectExhibitorLicensesTableView.getItems().clear();


            ExhibitorLicense newLicense = new ExhibitorLicense(exhibitorName, stallNo, licenseNumber);


            tempDataList.add(newLicense);


            inspectExhibitorLicensesTableView.getItems().add(newLicense);


            statusLabel.setText("Approved");


            exhibitorNameTextFied.clear();
            stallNoTextField.clear();
            licenseNumberTextField.clear();
        }

        else {

            statusLabel.setText("Failed");


            inspectExhibitorLicensesTableView.getItems().clear();
            tempDataList.clear();
        }
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/governmentOfficerDashboard.fxml", actionEvent);
    }
}