package cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;

import cse213.todayjava.Milad.UserMaintenanceStaff.DailyMaintanenceTask;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyTaskController
{
    @javafx.fxml.FXML
    private TableView<DailyMaintanenceTask> dailyTV;
    @javafx.fxml.FXML
    private TableColumn<DailyMaintanenceTask, String> taskTypeTC;
    @javafx.fxml.FXML
    private TableColumn<DailyMaintanenceTask, String> taskIdTC;
    @javafx.fxml.FXML
    private TableColumn<DailyMaintanenceTask, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<DailyMaintanenceTask, String> taskDecTC;
    @javafx.fxml.FXML
    private TableColumn<DailyMaintanenceTask, LocalDate> dateTC;

    List<DailyMaintanenceTask> item = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        DailyMaintanenceTask t1 = new DailyMaintanenceTask("DT001", "Electrical Check", "Inspect and confirm that all stall lights are functioning properly.", "Undone");
        DailyMaintanenceTask t2 = new DailyMaintanenceTask("DT002", "Cleanliness", "Ensure the walkways and stalls are properly cleaned.", "Undone");
        DailyMaintanenceTask t3 = new DailyMaintanenceTask("DT003", "Safety Check", "Verify fire extinguishers and emergency exits.", "Undone");
        DailyMaintanenceTask t4 = new DailyMaintanenceTask("DT004", "Plumbing Check", "Inspect water supply lines and ensure no leakage.", "Undone");
        DailyMaintanenceTask t5 = new DailyMaintanenceTask("DT005", "Stall Inspection", "Check vendor stalls for structural safety.", "Undone");
        DailyMaintanenceTask t6 = new DailyMaintanenceTask("DT006", "Sound System Check", "Test speakers and microphones across event areas.", "Undone");
        DailyMaintanenceTask t7 = new DailyMaintanenceTask("DT007", "Generator Check", "Inspect backup generator fuel level and startup function.", "Undone");
        DailyMaintanenceTask t8 = new DailyMaintanenceTask("DT008", "CCTV Check", "Verify all CCTV cameras are working properly.", "Undone");
        DailyMaintanenceTask t9 = new DailyMaintanenceTask("DT009", "Decoration Check", "Ensure banners and decorative materials are properly installed.", "Undone");
        DailyMaintanenceTask t10 = new DailyMaintanenceTask("DT010", "Cooling System Check", "Inspect air cooling units and report any overheating.", "Undone");

        item.add(t1);
        item.add(t2);
        item.add(t3);
        item.add(t4);
        item.add(t5);
        item.add(t6);
        item.add(t7);
        item.add(t8);
        item.add(t9);
        item.add(t10);

        dateTC.setCellValueFactory(new PropertyValueFactory<>("todayDate"));
        taskIdTC.setCellValueFactory(new PropertyValueFactory<>("taskId"));
        taskTypeTC.setCellValueFactory(new PropertyValueFactory<>("taskType"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        taskDecTC.setCellValueFactory(new PropertyValueFactory<>("taskDescricption"));

        dailyTV.getItems().addAll(item);
    }

    @javafx.fxml.FXML
    public void markDoneClick(ActionEvent actionEvent) {
        DailyMaintanenceTask selected = dailyTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection",
                    "Please select a task from the list.");
            return;
        }

        selected.setStatus("Done");
        dailyTV.refresh();
    }

    @javafx.fxml.FXML
    public void undoneClick(ActionEvent actionEvent) {
        List<DailyMaintanenceTask> temp = new ArrayList<>();
        for(DailyMaintanenceTask i: item){
            if(i.getStatus().equals("Undone")){
                temp.add(i);
            }
        }

        dailyTV.getItems().clear();
        dailyTV.getItems().addAll(temp);

    }

    @javafx.fxml.FXML
    public void backClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserMaintenanceStaff/maintenanceDashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void loadAllClick(ActionEvent actionEvent) {
        dailyTV.getItems().clear();
        dailyTV.getItems().addAll(item);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}