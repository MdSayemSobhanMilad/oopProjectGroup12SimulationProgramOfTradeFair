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

public class bookticketController {

    @FXML
    private TableColumn<Bookticket, LocalDate> Datecolumn;

    @FXML
    private ComboBox<String> GenderCombobox;

    @FXML
    private TableColumn<Bookticket, String> Gendercolumn;

    @FXML
    private TextField NameTextfield;

    @FXML
    private TableColumn<Bookticket, String> Namecolumn;

    @FXML
    private TextField TicketIdTextfield;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField phoneNumberTextfield;

    @FXML
    private TableColumn<Bookticket, Integer> phoneNumbercolumn;

    @FXML
    private TableView<Bookticket> tableview;

    @FXML
    private TableColumn<Bookticket, Integer> ticketIdcolumn;
    @FXML
    public void initialize(){
        GenderCombobox.getItems().addAll("Male","Female");
        Namecolumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        phoneNumbercolumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        ticketIdcolumn.setCellValueFactory(new PropertyValueFactory<>("TicketId"));
        Gendercolumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        Datecolumn.setCellValueFactory(new PropertyValueFactory<>("Date"));


    }

    @FXML
    void BACKButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserVisitor/visitorDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Book Ticket");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void BookticketButton(ActionEvent event) {
        tableview.getItems().clear();
        String Name=NameTextfield.getText();
        Integer TicketId=Integer.parseInt(TicketIdTextfield.getText());
        Integer phoneNumber=Integer.parseInt(phoneNumberTextfield.getText());
        LocalDate date=datepicker.getValue();
        String gender=GenderCombobox.getValue();
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("BookTicket.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Bookticket y=new Bookticket(Name,phoneNumber,TicketId,gender,date);
            tableview.getItems().add(y);
            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(bookticketController.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(bookticketController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    public void ShowAllButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        ObjectInputStream ois = null;
        try {
            Bookticket y;
            ois = new ObjectInputStream(new FileInputStream("BookTicket.bin"));
            while (true) {
                y = (Bookticket) ois.readObject();
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
