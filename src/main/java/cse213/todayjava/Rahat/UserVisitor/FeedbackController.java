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

public class FeedbackController {

    @FXML
    private ComboBox<String> RatingCombobox;

    @FXML
    private TextField productnameTextfield;

    @FXML
    private TableColumn<Feedback, String> producttnametablecolumn;

    @FXML
    private TableColumn<Feedback, String> ratingtablecolumn;

    @FXML
    private TextField stallnameTextfield;

    @FXML
    private TableColumn<Feedback, String> stallnametablecolumn;

    @FXML
    private TableView<Feedback> tableview;

    @FXML
    public void initialize() {
        RatingCombobox.getItems().addAll("Average", "Bad","Good","Best");
        stallnametablecolumn.setCellValueFactory(new PropertyValueFactory<>("Stallname"));
        producttnametablecolumn.setCellValueFactory(new PropertyValueFactory<>("Productname"));
        ratingtablecolumn.setCellValueFactory(new PropertyValueFactory<>("Rating"));


    }

    @FXML
    void addButton(ActionEvent event) {
        tableview.getItems().clear();
        String Stallname = stallnameTextfield.getText();
        String Productname = productnameTextfield.getText();
        String Rating = RatingCombobox.getValue();
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Feedback.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Feedback y = new Feedback(Stallname,Productname,Rating);
            tableview.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(FeedbackController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FeedbackController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }



    @FXML
    void backButton(ActionEvent event)  throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserVisitor/visitorDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Feedback");
        window.setScene(scene2);
        window.show();

    }



    @FXML
    void showallButton(ActionEvent event) {
        tableview.getItems().clear();
        ObjectInputStream ois = null;
        try {
            Feedback y;
            ois = new ObjectInputStream(new FileInputStream("Feedback.bin"));
            while (true) {
                y = (Feedback) ois.readObject();
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


