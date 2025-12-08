package cse213.todayjava.Rahat.UserFinancemanager;

import cse213.todayjava.Rahat.UserVisitor.AppendableObjectOutPutStream;
import cse213.todayjava.Rahat.UserVisitor.Bookticket;
import cse213.todayjava.Rahat.UserVisitor.bookticketController;
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

public class revenuerecordController {

    @FXML
    private TextField amountTextfield;

    @FXML
    private TableColumn<Revenuerecord,Integer> amounttablecolumn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TableColumn<Revenuerecord, LocalDate> datetablecolumn;

    @FXML
    private ComboBox<String> revenuetypeCombobox;

    @FXML
    private TableColumn<Revenuerecord,String> revenuetypetablecolumn;

    @FXML
    private TableView<Revenuerecord> tableview;

    @FXML
    private TextField transactionidTextfield;

    @FXML
    public void initialize() {
        revenuetypeCombobox.getItems().addAll("Ticket", "Stall","Sponsorship");
        amounttablecolumn.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        datetablecolumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        revenuetypetablecolumn.setCellValueFactory(new PropertyValueFactory<>("Revenue type"));

    }

    @FXML
    void Addbutton(ActionEvent event) {
        tableview.getItems().clear();
        Integer Transactionid = Integer.parseInt(transactionidTextfield.getText());
        Integer Amount = Integer.parseInt(amountTextfield.getText());
        LocalDate Date = datepicker.getValue();
        String Revenuetype = revenuetypeCombobox.getValue();
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Revenuerecord.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Revenuerecord y = new Revenuerecord(Transactionid,Amount,Revenuetype, Date);
            tableview.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(revenuerecordController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(revenuerecordController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }



    @FXML
    void ShowAllButton(ActionEvent event) {
        tableview.getItems().clear();
        ObjectInputStream ois = null;
        try {
            Revenuerecord y;
            ois = new ObjectInputStream(new FileInputStream("Revenuerecord.bin"));
            while (true) {
                y = (Revenuerecord) ois.readObject();
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
    void backBujtton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserFinancemanager/FinancemanagerDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Revenuerecord");
        window.setScene(scene2);
        window.show();

    }



}
