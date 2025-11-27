module cse213.todayjava {
    requires javafx.controls;
    requires javafx.fxml;

    exports cse213.todayjava;

    opens cse213.todayjava to javafx.fxml;

}