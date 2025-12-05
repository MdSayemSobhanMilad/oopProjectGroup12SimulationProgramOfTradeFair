package cse213.todayjava.Arabi.UserMediaPromoter;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class mediaPromoterDashboardControllerClass
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void trackVisitorEngagementsOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/trackVisitorEngagement.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void logOutOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/login.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void uploadPhotosOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void promoteSponsorContentOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void publishDailyHighlightsOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void coordinateWithSecurityOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void postNewsAndAnnouncemenstOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/User7Goal1.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void shareFairPromotionsOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/shareFairPromotions.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void manageAdvertisementsOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserMediaPromoter/manageAdvertisements.fxml", actionEvent);

    }

}