package cse213.todayjava.Rahat.UserVisitor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class VisitorDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logOutOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bookticketbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/todayjava/Rahat/UserVisitor/bookticket.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Book Ticket");
        window.setScene(scene2);
        window.show();
    }

}