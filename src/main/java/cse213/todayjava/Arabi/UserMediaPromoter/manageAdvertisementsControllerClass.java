package cse213.todayjava.Arabi.UserMediaPromoter;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class manageAdvertisementsControllerClass {

    @FXML
    private TextField addIdTextField;

    @FXML
    private TextField sponsorTextField;

    @FXML
    private TextField addTypeTextField;

    @FXML
    private TextField statusTextField;

    @FXML
    private TableView<AdManagement> manageAdvertisementsTableView;

    @FXML
    private TableColumn<AdManagement, String> addIdTableColumn;

    @FXML
    private TableColumn<AdManagement, String> sponsorTableColumn;

    @FXML
    private TableColumn<AdManagement, String> addTypeTableColumn;

    @FXML
    private TableColumn<AdManagement, String> statusTableColumn;

    @FXML
    private Label statusLabel;


    private ObservableList<AdManagement> advertisementList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Manage Advertisements Controller Initialized!");


        addIdTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getAddId()));

        sponsorTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getSponsor()));

        addTypeTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getAddType()));

        statusTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getStatus()));


        manageAdvertisementsTableView.setItems(advertisementList);


        statusLabel.setText("");
    }

    @FXML
    private void submitOnClick() {
        System.out.println("Submit button clicked!");


        String addId = addIdTextField.getText();
        String sponsor = sponsorTextField.getText();
        String addType = addTypeTextField.getText();
        String status = statusTextField.getText();


        if (!addId.isEmpty() && !sponsor.isEmpty() &&
                !addType.isEmpty() && !status.isEmpty()) {


            AdManagement newAdvertisement = new AdManagement(addId, sponsor, addType, status);


            advertisementList.add(newAdvertisement);


            statusLabel.setText("Successful Submit");
            System.out.println("New advertisement added to table!");


            clearFields();
        }

        else {

            statusLabel.setText("Failed");
            System.out.println("Failed - some fields are empty!");


        }
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button clicked!");

        // টেবিলের সব ডেটা মুছে দেবে
        advertisementList.clear();
        System.out.println("Table data cleared!");

        // Status label clear করা
        statusLabel.setText("");

        // ফিল্ডগুলো খালি করবে
        clearFields();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/mediaPromoterDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        addIdTextField.clear();
        sponsorTextField.clear();
        addTypeTextField.clear();
        statusTextField.clear();
    }
}