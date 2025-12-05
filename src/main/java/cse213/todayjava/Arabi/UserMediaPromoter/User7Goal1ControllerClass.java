package cse213.todayjava.Arabi.UserMediaPromoter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class User7Goal1ControllerClass implements Initializable {

    @FXML
    private TableColumn<MediaPromoter, String> descriptionTableCol;
    @FXML
    private TextField descriptionTextfield;
    @FXML
    private TableView<MediaPromoter> newsAndAnnnouncementPortalTableView;
    @FXML
    private TableColumn<MediaPromoter, String> newsTitleTableCol;
    @FXML
    private TextField newstitleTextField;
    @FXML
    private DatePicker publishingDatePicker;
    @FXML
    private TableColumn<MediaPromoter, LocalDate> publishingDayeTableCol;
    @FXML
    private TableColumn<MediaPromoter, String> reporterNameTableCol;
    @FXML
    private TextField reporterNameTextField;

    private ObservableList<MediaPromoter> newsList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupTableColumns();
        loadNewsData();
    }

    private void setupTableColumns() {
        newsTitleTableCol.setCellValueFactory(new PropertyValueFactory<>("newsTitle"));
        reporterNameTableCol.setCellValueFactory(new PropertyValueFactory<>("reporterName"));
        descriptionTableCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        publishingDayeTableCol.setCellValueFactory(new PropertyValueFactory<>("publishingDate"));

        newsAndAnnnouncementPortalTableView.setItems(newsList);
    }

    private void loadNewsData() {
        ArrayList<MediaPromoter> loadedNews = MediaPromoter.loadNewsFromFile();
        newsList.addAll(loadedNews);
    }

    @FXML
    void postNewsButtonOnClick(ActionEvent event) {
        String title = newstitleTextField.getText();
        String reporter = reporterNameTextField.getText();
        String description = descriptionTextfield.getText();
        LocalDate date = publishingDatePicker.getValue();

        if (title.isEmpty() || reporter.isEmpty() || description.isEmpty() || date == null) {
            System.out.println("Please fill all fields!");
            return;
        }

        MediaPromoter news = new MediaPromoter();
        news.setNewsTitle(title);
        news.setReporterName(reporter);
        news.setDescription(description);
        news.setPublishingDate(date);

        MediaPromoter.saveNewsToFile(news);
        newsList.add(news);
        clearFields();
    }

    private void clearFields() {
        newstitleTextField.clear();
        reporterNameTextField.clear();
        descriptionTextfield.clear();
        publishingDatePicker.setValue(null);
    }

    @FXML
    public void backOnClick(ActionEvent actionEvent) {
    }
}