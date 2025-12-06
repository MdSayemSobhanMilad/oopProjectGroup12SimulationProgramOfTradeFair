package cse213.todayjava.Arabi.UserMediaPromoter;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class uploadPhotosControllerClass {

    @FXML
    private TextField uploadTypeTextField;

    @FXML
    private TextArea requirementsTextArea;

    @FXML
    private TextArea detailsTextArea;

    @FXML
    private ListView<String> uploadPhotosListView;

    @FXML
    private Label statusLabel;


    private ObservableList<String> photoList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Upload Photos Controller Initialized");


        uploadPhotosListView.setItems(photoList);


        statusLabel.setText("");
    }

    @FXML
    private void submitOnClick() {
        System.out.println("Submit button clicked");


        String uploadType = uploadTypeTextField.getText();
        String requirements = requirementsTextArea.getText();
        String details = detailsTextArea.getText();


        if (!uploadType.isEmpty() && !requirements.isEmpty() && !details.isEmpty()) {

            PhotoData newPhotoData = new PhotoData(uploadType, requirements, details);


            photoList.add(newPhotoData.toString());


            statusLabel.setText("successful");
            System.out.println("New photo data added to list");


            clearFields();
        }

        else {

            statusLabel.setText("failed");
            System.out.println("Failed - Some fields are empty");


        }
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button clicked");


        photoList.clear();
        System.out.println("List data cleared");


        statusLabel.setText("");


        clearFields();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/mediaPromoterDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        uploadTypeTextField.clear();
        requirementsTextArea.clear();
        detailsTextArea.clear();
    }
}