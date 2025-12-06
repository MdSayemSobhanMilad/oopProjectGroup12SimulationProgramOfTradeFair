package cse213.todayjava.Rahat.UserVisitor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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

public class eticketController {

    @FXML
    private TableColumn<Eticket,LocalDate> EventdateTablecolumn;

    @FXML
    private TableColumn<Eticket,String> EventgtypeTablecolumn;

    @FXML
    private ComboBox<String> EventtypeCombobox;

    @FXML
    private TableColumn<Eticket,String> NameTablecolumn;

    @FXML
    private TextField NameTextfield;


    @FXML
    private ComboBox<String> TickettypeCombobox;

    @FXML
    private TableColumn<Eticket, String> TickettypeTablecolumn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField NumberTextfield;

    @FXML
    private TableView<Eticket> tableview;

    @FXML
    public void initialize() {
        TickettypeCombobox.getItems().addAll("General", "Vip", "Premium");
        EventtypeCombobox.getItems().addAll("Tech Expo", "Food Fair", "Art SHow");
        TickettypeTablecolumn.setCellValueFactory(new PropertyValueFactory<>("Tickettype"));
        NameTablecolumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        EventgtypeTablecolumn.setCellValueFactory(new PropertyValueFactory<>("Eventtype"));
        EventdateTablecolumn.setCellValueFactory(new PropertyValueFactory<>("Eventdate"));

    }

    @FXML
    public void BackButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserVisitor/visitorDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Eticket");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    public void GenerateButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        String Name = NameTextfield.getText();
        String Tickettype = TickettypeCombobox.getValue();
        int Number = Integer.parseInt(NumberTextfield.getText());
        LocalDate Eventdate = datepicker.getValue();
        String Eventtype = EventtypeCombobox.getValue();
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Eticket.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Eticket y = new Eticket(Name,Number, Tickettype,Eventtype,Eventdate);
            tableview.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(eticketController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(eticketController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    public void ShowallButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        ObjectInputStream ois = null;
        try {
            Eticket y;
            ois = new ObjectInputStream(new FileInputStream("Eticket.bin"));
            while (true) {
                y = (Eticket) ois.readObject();
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
