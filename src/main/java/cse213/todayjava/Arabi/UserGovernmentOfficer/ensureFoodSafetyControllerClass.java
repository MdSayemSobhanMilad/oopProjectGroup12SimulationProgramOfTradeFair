package cse213.todayjava.Arabi.UserGovernmentOfficer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ensureFoodSafetyControllerClass {

    @FXML
    private ComboBox<String> hygenicCheckListComboBox;

    @FXML
    private TextArea reviewFoodStatusTextArea;

    @FXML
    private ListView<String> listView;

    // ObservableList for ListView
    private ObservableList<String> foodSafetyList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // ComboBox এ কিছু অপশন যোগ করা
        hygenicCheckListComboBox.getItems().addAll(
                "Clean Kitchen",
                "Fresh Ingredients",
                "Proper Storage",
                "Temperature Control",
                "Clean Utensils",
                "Staff Hygiene"
        );

        // ListView সেট করা
        listView.setItems(foodSafetyList);
    }

    @FXML
    private void uploadOnClick() {
        // সব ফিল্ড চেক করা
        String selectedHygenicCheck = hygenicCheckListComboBox.getValue();
        String reviewStatus = reviewFoodStatusTextArea.getText();

        // সব ফিল্ড ভরা থাকলে
        if (selectedHygenicCheck != null && !selectedHygenicCheck.isEmpty()
                && !reviewStatus.isEmpty()) {

            // Model object তৈরি
            FoodSafety foodSafety = new FoodSafety(selectedHygenicCheck, reviewStatus);

            // ListView এ যোগ করা (toString() ব্যবহার করে)
            foodSafetyList.add(foodSafety.toString());

            // ফিল্ডগুলো খালি করা
            hygenicCheckListComboBox.setValue(null);
            reviewFoodStatusTextArea.clear();
        }
        // কোনো ফিল্ড খালি থাকলে কিছুই করবে না
    }

    @FXML
    private void deleteOnClick() {
        // ListView এর সব ডেটা মুছে দেবে
        foodSafetyList.clear();
    }

    @FXML
    private void backOnClick() {
        // Back button এর কাজ
        System.out.println("Back button clicked");
    }
}