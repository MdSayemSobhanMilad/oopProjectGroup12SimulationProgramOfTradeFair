package cse213.todayjava.Rahat.UserVisitor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.Objects;

public class searchproductController {

    @FXML
    private TextField ProductnameTextField;

    @FXML
    private TableColumn<Searchproduct, String> Productpricetablecolumn;

    @FXML
    private TableColumn<Searchproduct, String> Stockstatustablecolumn;

    @FXML
    private TableColumn<Searchproduct,Integer> pricetablecolumn;

    @FXML
    private TableView<Searchproduct> tableview;

    private ObservableList<Searchproduct> productList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Productpricetablecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pricetablecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        Stockstatustablecolumn.setCellValueFactory(new PropertyValueFactory<>("stockStatus"));
        productList.add(new Searchproduct("Laptop", 999, "In Stock"));
        productList.add(new Searchproduct("Mouse", 29, "In Stock"));
        productList.add(new Searchproduct("Keyboard", 49, "Low Stock"));
        productList.add(new Searchproduct("Monitor", 199, "In Stock"));
        productList.add(new Searchproduct("Phone", 299, "Out of Stock"));

        tableview.setItems(productList);
    }

    @FXML
    void BackButton(ActionEvent event)  throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserVisitor/visitorDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Searchproduct");
        window.setScene(scene2);
        window.show();
    }




    @FXML
    void SearchButton(ActionEvent event) {
        String searchText = ProductnameTextField.getText().toLowerCase().trim();

        if (searchText.isEmpty()) {
            tableview.setItems(productList);
            return;
        }

        ObservableList<Searchproduct> filteredList = FXCollections.observableArrayList();

        for (Searchproduct product : productList) {
            if (product.getName().toLowerCase().contains(searchText)) {
                filteredList.add(product);
            }
        }

        tableview.setItems(filteredList);

        if (filteredList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Results");
            alert.setContentText("No products found for: " + searchText);
            alert.show();
        }
    }

    @FXML
    void ShowallButton(ActionEvent event) {
        tableview.setItems(productList);
        ProductnameTextField.clear();
    }
}