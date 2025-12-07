package cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses;

import cse213.todayjava.Milad.UserSecurityPersonnel.Watchlist;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WatchlistController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private Label errorSuccessLabel;
    @javafx.fxml.FXML
    private TableView<Watchlist> watchlistTV;
    @javafx.fxml.FXML
    private TableColumn<Watchlist, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<Watchlist, String> reasonTC;
    @javafx.fxml.FXML
    private TableColumn<Watchlist, String> idTC;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private TextField reasonTF;

    List<Watchlist> item = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        idTC.setCellValueFactory(new PropertyValueFactory<>("entryId"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("personNameDescription"));
        reasonTC.setCellValueFactory(new PropertyValueFactory<>("reason"));
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        item.add(new Watchlist(idTF.getText(), nameTF.getText(), reasonTF.getText()));

        errorSuccessLabel.setText("Data Successfully Added");
        watchlistTV.getItems().clear();
        watchlistTV.getItems().addAll(item);
    }

    @javafx.fxml.FXML
    public void loadOnClick(ActionEvent actionEvent) {
        watchlistTV.getItems().clear();
        watchlistTV.getItems().addAll(item);
        errorSuccessLabel.setText("Data Successfully Loaded");
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/securityPersonnelDashboard.fxml", actionEvent);
    }
}