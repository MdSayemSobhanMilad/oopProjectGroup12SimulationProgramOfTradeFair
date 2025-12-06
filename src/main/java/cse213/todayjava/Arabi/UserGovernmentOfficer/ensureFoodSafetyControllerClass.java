package cse213.todayjava.Arabi.UserGovernmentOfficer;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class ensureFoodSafetyControllerClass {

    @FXML
    private ComboBox<String> hygenicCheckListComboBox;

    @FXML
    private TextArea reviewFoodStatusTextArea;

    @FXML
    private ListView<String> listView;


    private ObservableList<String> foodSafetyList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        hygenicCheckListComboBox.getItems().addAll(
                "Clean Kitchen",
                "Fresh Ingredients",
                "Proper Storage",
                "Temperature Control",
                "Clean Utensils",
                "Staff Hygiene"
        );


        listView.setItems(foodSafetyList);
    }

    @FXML
    private void uploadOnClick() {

        String selectedHygenicCheck = hygenicCheckListComboBox.getValue();
        String reviewStatus = reviewFoodStatusTextArea.getText();


        if (selectedHygenicCheck != null && !selectedHygenicCheck.isEmpty()
                && !reviewStatus.isEmpty()) {


            FoodSafety foodSafety = new FoodSafety(selectedHygenicCheck, reviewStatus);


            foodSafetyList.add(foodSafety.toString());


            hygenicCheckListComboBox.setValue(null);
            reviewFoodStatusTextArea.clear();
        }

    }

    @FXML
    private void deleteOnClick() {

        foodSafetyList.clear();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/governmentOfficerDashboard.fxml", actionEvent);
    }
}