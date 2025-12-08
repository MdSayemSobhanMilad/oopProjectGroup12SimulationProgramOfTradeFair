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

public class requestassistanceController {

    @FXML
    private TableView<Requestassistance> tableview;

    @FXML
    private TableColumn<Requestassistance,String> typeofassistanceColumn;

    @FXML
    private ComboBox<String> typeofassistanceCombobox;

    @FXML
    private TableColumn<Requestassistance,Integer> visitoridColumn;

    @FXML
    private TextField visitoridTextfield;

    @FXML
    public void initialize() {
        typeofassistanceCombobox.getItems().addAll("Medical help", "Lost item","Safety/security","Technical issue");
        typeofassistanceColumn.setCellValueFactory(new PropertyValueFactory<>("TypeOfAssistance"));
        visitoridColumn.setCellValueFactory(new PropertyValueFactory<>("VisitorId"));

    }

    @FXML
    void BackButton(ActionEvent event)  throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserVisitor/visitorDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Requestassistance");
        window.setScene(scene2);
        window.show();
    }




    @FXML
    void sendreqButton(ActionEvent event) {
        tableview.getItems().clear();
        int VisitorId = Integer.parseInt(visitoridTextfield.getText());
        String TypeOfAssistance = typeofassistanceCombobox.getValue();
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Requestassistance.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Requestassistance y = new Requestassistance(VisitorId,TypeOfAssistance);
            tableview.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(requestassistanceController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(requestassistanceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



    @FXML
    void showallButton(ActionEvent event) {
        tableview.getItems().clear();
        ObjectInputStream ois = null;
        try {
            Requestassistance y;
            ois = new ObjectInputStream(new FileInputStream("Requestassistance.bin"));
            while (true) {
                y = (Requestassistance) ois.readObject();
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
