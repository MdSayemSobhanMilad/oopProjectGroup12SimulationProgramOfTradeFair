module cse213.todayjava {
    requires javafx.controls;
    requires javafx.fxml;

    exports cse213.todayjava;

    opens cse213.todayjava to javafx.fxml;

//    exports cse213.todayjava.Milad.UserMaintenanceStaff;
//    opens cse213.todayjava.Milad.UserMaintenanceStaff to javafx.fxml;

    exports cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;
    opens cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses to javafx.fxml;

//    exports cse213.todayjava.Milad.UserSecurityPersonnel;
//    opens cse213.todayjava.Milad.UserSecurityPersonnel to javafx.fxml;

    exports cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses;
    opens cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses to javafx.fxml;
}