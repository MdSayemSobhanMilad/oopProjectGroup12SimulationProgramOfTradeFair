package cse213.todayjava.Rahat.UserVisitor;

import javafx.event.ActionEvent;
import javafx.event.Event;
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

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class planSheduleController {

    @FXML
    private DatePicker BookingdateDatepicker;

    @FXML
    private TableColumn<PlanShedule,LocalDate> BookingdateTablecolumn;

    @FXML
    private ComboBox<String> CategoryCombobox;

    @FXML
    private TableColumn<PlanShedule, String> CategoryTablecolumn;

    @FXML
    private TextField ProductcategoryTextfield;

    @FXML
    private TableColumn<PlanShedule, Integer> StallnumberTablecolumn;

    @FXML
    private TextField StallnumberTextfield;

    @FXML
    private ComboBox<String> StalltypeCombobox;

    @FXML
    private TableView<PlanShedule> Tableview;

    @FXML
    private TableColumn<PlanShedule,String> VisitornameTablecolumn;

    @FXML
    private TextField VisitornameTextfield;

    @FXML
    public void initialize() {
        StalltypeCombobox.getItems().addAll("Local", "Premium");
        CategoryCombobox.getItems().addAll("Food", "Technology", "Clothing", "Crafts");
        CategoryTablecolumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
        VisitornameTablecolumn.setCellValueFactory(new PropertyValueFactory<>("VisitorName"));
        StallnumberTablecolumn.setCellValueFactory(new PropertyValueFactory<>("Stallnumber"));
        BookingdateTablecolumn.setCellValueFactory(new PropertyValueFactory<>("Bookingdate"));
    }











    @FXML
    public void UpdateButton(ActionEvent actionEvent) {
        Tableview.getItems().clear();
        ObjectInputStream ois = null;
        try {
            PlanShedule y;
            ois = new ObjectInputStream(new FileInputStream("Planshedule.bin"));
            while (true) {
                y = (PlanShedule) ois.readObject();
                Tableview.getItems().add(y);
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
    public void AddButton(ActionEvent actionEvent) {
        Tableview.getItems().clear();
        String VisitorName = VisitornameTextfield.getText();
        int Stallnumber = Integer.parseInt(StallnumberTextfield.getText());
        String Stalltype = StalltypeCombobox.getValue();
        LocalDate Bookingdate = BookingdateDatepicker.getValue();
        String Category = CategoryCombobox.getValue();
        String Productcategory = ProductcategoryTextfield.getText();
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Planshedule.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            PlanShedule y = new PlanShedule(VisitorName,Stallnumber,Stalltype,Category,Bookingdate,Productcategory);
            Tableview.getItems().add(y);
            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(planSheduleController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(planSheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    public void BackButton(ActionEvent event)  throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserVisitor/visitorDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("PlanShedule");
        window.setScene(scene2);
        window.show();
    }
}

