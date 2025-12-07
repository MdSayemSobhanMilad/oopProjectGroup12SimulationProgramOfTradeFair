package cse213.todayjava.Rahat.UserVisitor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class trackpurchaseController {

    @FXML
    private ComboBox<String> categoryCombobox;

    @FXML
    private TableColumn<Trackpurchase,String> categoryTablecolumn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TableColumn<Trackpurchase,Integer> priceTablecolumn;

    @FXML
    private TextField priceTextfield;

    @FXML
    private TableColumn<Trackpurchase,String> productnameTablecolumn;

    @FXML
    private TextField productnameTextfield;

    @FXML
    private TableColumn<Trackpurchase,LocalDate> purchasedateTablecolumn;

    @FXML
    private TableView<Trackpurchase> tableview;

    @FXML
    public void initialize() {
        categoryCombobox.getItems().addAll("Food", "Technology", "Clothing", "Crafts");
        categoryTablecolumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
        productnameTablecolumn.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        priceTablecolumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        purchasedateTablecolumn.setCellValueFactory(new PropertyValueFactory<>(" Purchase date"));
    }

    @FXML
    void BackButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserVisitor/visitorDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Trackpurchase");
        window.setScene(scene2);
        window.show();
    }



    @FXML
    void TrackallButton(ActionEvent event) {
        tableview.getItems().clear();
        ObjectInputStream ois = null;
        try {
            Trackpurchase y;
            ois = new ObjectInputStream(new FileInputStream("Trackpurchase.bin"));
            while (true) {
                y = (Trackpurchase) ois.readObject();
                tableview.getItems().add(y);
            }
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }




    @FXML
    void TrackpurchaseButton(ActionEvent event) {
        tableview.getItems().clear();
        String ProductName = productnameTextfield.getText();
        int Price = Integer.parseInt(priceTextfield.getText());
        LocalDate Purchasedate = datepicker.getValue();
        String Category = categoryCombobox.getValue();
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Trackpurchase.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Trackpurchase y = new Trackpurchase(ProductName,Price,Category,Purchasedate);
            tableview.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(trackpurchaseController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(trackpurchaseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}

