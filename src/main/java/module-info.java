module cse213.todayjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse213.todayjava to javafx.fxml;
    exports cse213.todayjava;
}