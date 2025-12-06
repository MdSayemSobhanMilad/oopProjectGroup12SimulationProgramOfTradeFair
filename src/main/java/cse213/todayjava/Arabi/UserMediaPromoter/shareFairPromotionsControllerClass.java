package cse213.todayjava.Arabi.UserMediaPromoter;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.time.LocalDate;

public class shareFairPromotionsControllerClass {

    @FXML
    private DatePicker promotionDatePicker;

    @FXML
    private TextArea promotionStatusTextArea;

    @FXML
    private TableView<FairPromotion> shareFairPromotionTableView;

    @FXML
    private TableColumn<FairPromotion, String> promotionDateTableColumn;

    @FXML
    private TableColumn<FairPromotion, String> promotionStatusTableColumn;

    @FXML
    private Label statusSectionLabel;


    private ObservableList<FairPromotion> currentPromotion = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Share Fair Promotions Controller shuru hoise!");


        promotionDateTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getPromotionDate().toString()));

        promotionStatusTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getPromotionStatus()));


        shareFairPromotionTableView.setItems(currentPromotion);


        statusSectionLabel.setText("");
    }

    @FXML
    private void uploadMediaOnClick() {
        System.out.println("Upload Media button click!");


        LocalDate promotionDate = promotionDatePicker.getValue();
        String promotionStatus = promotionStatusTextArea.getText();


        if (promotionDate == null || promotionStatus.isEmpty()) {

            statusSectionLabel.setText("failed");
            System.out.println("Field khali ache!");
            return;
        }


        currentPromotion.clear();


        FairPromotion newPromotion = new FairPromotion(promotionDate, promotionStatus);


        currentPromotion.add(newPromotion);


        statusSectionLabel.setText("successful");
        System.out.println("Table e new data add hoise!");


        clearFields();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/mediaPromoterDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        promotionDatePicker.setValue(null);
        promotionStatusTextArea.clear();
    }
}