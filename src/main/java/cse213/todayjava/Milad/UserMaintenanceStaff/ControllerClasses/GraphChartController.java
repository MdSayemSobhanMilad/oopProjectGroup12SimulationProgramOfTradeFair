package cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;

import cse213.todayjava.Milad.UserMaintenanceStaff.ChartData;
import cse213.todayjava.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphChartController
{
    @javafx.fxml.FXML
    private ComboBox<String> equipmentNameCB;
    @javafx.fxml.FXML
    private Label successErrorLabel;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private PieChart piechart;

    ObservableList<PieChart.Data> item = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        equipmentNameCB.getItems().addAll(
                "Toilet Paper",
                "Hand Soap",
                "Paper Towels",
                "Hand Sanitizer",
                "Air Freshener",
                "Trash Bags",
                "Disinfectant Spray",
                "Floor Cleaner",
                "Glass Cleaner",
                "Bleach",
                "Rubber Gloves",
                "Mop Heads",
                "Microfiber Cloths",
                "Toilet Bowl Cleaner",
                "Hand Dryer Paper"
        );
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        if (!validateInput()){
            return;
        }
        String a = quantityTF.getText();
        try{
            int b = Integer.parseInt(a);
            if (b < 0){
                successErrorLabel.setText("Please Enter Positive Number.");
                return;
            }
        } catch (NumberFormatException e) {
            successErrorLabel.setText("Please Enter Integer Number.");
            return;
        }

        for (PieChart.Data i: item){
            if (i.getName().equals(equipmentNameCB.getValue())){
                successErrorLabel.setText("This Equipment is already in the pie chart.");
                return;
            }
        }

        item.add(new PieChart.Data(equipmentNameCB.getValue(), Integer.parseInt(a)));

        piechart.setData(item);
        piechart.setTitle("My Analysis");
        successErrorLabel.setText("Data added in the pie chart successfully");
        clearForms();
    }


    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserMaintenanceStaff/maintenanceDashboard.fxml", actionEvent);
    }


    private boolean validateInput(){
        if (equipmentNameCB.getValue() == null || quantityTF.getText().isEmpty()){
            successErrorLabel.setText("Please Input All the fields.");
            return false;
        }
        return true;
    }

    private void clearForms(){
        quantityTF.clear();
        equipmentNameCB.setValue(null);
    }
}
