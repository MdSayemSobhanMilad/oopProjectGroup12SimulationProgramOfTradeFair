package cse213.todayjava.Arabi.UserMediaPromoter;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.time.LocalDate;

public class publishDailyHighlightsControllerClass {

    @FXML
    private TextField selectMediaTextField;

    @FXML
    private TextArea mediaListTextArea;

    @FXML
    private TextArea summaryTextArea;

    @FXML
    private DatePicker dailyDatePicker;

    @FXML
    private TableView<DailyHighlight> publishDailyHighlightsTableView;

    @FXML
    private TableColumn<DailyHighlight, String> selectMediaTableColumn;

    @FXML
    private TableColumn<DailyHighlight, String> mediaListTableColumn;

    @FXML
    private TableColumn<DailyHighlight, String> summaryTableColumn;

    @FXML
    private TableColumn<DailyHighlight, String> dateTableColumn;

    @FXML
    private Label statusLabel;


    private ObservableList<DailyHighlight> highlightList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Publish Daily Highlights Controller Initialized!");


        selectMediaTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getSelectMedia()));

        mediaListTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getMediaList()));

        summaryTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getSummary()));

        dateTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getDailyDate().toString()));


        publishDailyHighlightsTableView.setItems(highlightList);


        statusLabel.setText("");
    }

    @FXML
    private void submitOnClick() {
        System.out.println("Submit button clicked!");


        String selectMedia = selectMediaTextField.getText();
        String mediaList = mediaListTextArea.getText();
        String summary = summaryTextArea.getText();
        LocalDate dailyDate = dailyDatePicker.getValue();


        if (!selectMedia.isEmpty() && !mediaList.isEmpty() &&
                !summary.isEmpty() && dailyDate != null) {


            DailyHighlight newHighlight = new DailyHighlight(selectMedia, mediaList, summary, dailyDate);


            highlightList.add(newHighlight);


            statusLabel.setText("successful");
            System.out.println("New daily highlight added to table!");


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


        highlightList.clear();
        System.out.println("Table data cleared!");


        statusLabel.setText("");


        clearFields();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/mediaPromoterDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        selectMediaTextField.clear();
        mediaListTextArea.clear();
        summaryTextArea.clear();
        dailyDatePicker.setValue(null);
    }
}