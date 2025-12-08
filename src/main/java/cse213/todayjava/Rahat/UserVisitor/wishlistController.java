package cse213.todayjava.Rahat.UserVisitor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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

public class wishlistController {

    @FXML
    private ComboBox<String> ItemcategoryCombobox;

    @FXML
    private TextField ItemnameTextfield;

    @FXML
    private TextField PriceTextfield;

    @FXML
    private TableColumn<Wishlist,String> itemcategorytablecolumn;

    @FXML
    private TableColumn<Wishlist,String> itemnametablecolumn;

    @FXML
    private TableColumn<Wishlist,Integer> pricetablecolumn;

    @FXML
    private TableView<Wishlist> tableview;

    @FXML
    public void initialize() {
        ItemcategoryCombobox.getItems().addAll("Food", "Technology", "Clothing", "Crafts");
        itemcategorytablecolumn.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
        itemnametablecolumn.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        pricetablecolumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }

    @FXML
    void AddButton(ActionEvent event) {
        tableview.getItems().clear();
        String itemName  = ItemnameTextfield.getText();
        int Price = Integer.parseInt(PriceTextfield.getText());
        String itemCategory = ItemcategoryCombobox.getValue();
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Wishlist.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Wishlist y = new Wishlist(itemName,Price,itemCategory);
            tableview.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(wishlistController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(wishlistController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



    @FXML
    void BackButoon(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserVisitor/visitorDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Wishlist");
        window.setScene(scene2);
        window.show();
    }


    @FXML
    void ShowallButton(ActionEvent event) {
        tableview.getItems().clear();
        ObjectInputStream ois = null;
        try {
            Wishlist y;
            ois = new ObjectInputStream(new FileInputStream("Wishlist.bin"));
            while (true) {
                y = (Wishlist) ois.readObject();
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

}

