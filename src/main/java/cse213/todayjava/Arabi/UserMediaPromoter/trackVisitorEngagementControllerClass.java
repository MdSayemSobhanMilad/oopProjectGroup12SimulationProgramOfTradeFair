package cse213.todayjava.Arabi.UserMediaPromoter;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.time.LocalDate;

public class trackVisitorEngagementControllerClass {

    @FXML
    private TextField visitorPostTextField;

    @FXML
    private DatePicker selectDatePicker;

    @FXML
    private TextArea commentsTextArea;

    @FXML
    private TableView<VisitorEngagement> trackVisitorEngagementTableView;

    @FXML
    private TableColumn<VisitorEngagement, String> visitorPostTableColumn;

    @FXML
    private TableColumn<VisitorEngagement, String> selectDateTableColumn;

    @FXML
    private TableColumn<VisitorEngagement, String> commentsTableColumn;

    @FXML
    private Label viewStatusLabel;


    private ObservableList<VisitorEngagement> engagementList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Track Visitor Engagement Controller Initialized!");


        visitorPostTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getVisitorPost()));

        selectDateTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getSelectDate().toString()));

        commentsTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getComments()));


        trackVisitorEngagementTableView.setItems(engagementList);


        viewStatusLabel.setText("");
    }

    @FXML
    private void showStatusOnClick() {
        System.out.println("Show Status button clicked!");


        String visitorPost = visitorPostTextField.getText();
        LocalDate selectDate = selectDatePicker.getValue();
        String comments = commentsTextArea.getText();


        if (!visitorPost.isEmpty() && selectDate != null && !comments.isEmpty()) {

            engagementList.clear();


            VisitorEngagement newEngagement = new VisitorEngagement(visitorPost, selectDate, comments);


            engagementList.add(newEngagement);


            viewStatusLabel.setText("Successful");
            System.out.println("New engagement data added to table: " + newEngagement);


            clearFields();
        }

        else {

            engagementList.clear();


            viewStatusLabel.setText("Failed");
            System.out.println("Failed - Some fields are empty!");


            clearFields();
        }
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/mediaPromoterDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        visitorPostTextField.clear();
        selectDatePicker.setValue(null);
        commentsTextArea.clear();
    }
}