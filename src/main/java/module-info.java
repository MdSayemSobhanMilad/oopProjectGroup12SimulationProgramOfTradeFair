module cse213.todayjava {
    requires javafx.controls;
    requires javafx.fxml;

<<<<<<< Updated upstream


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

    exports cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;
    opens cse213.todayjava.Ahad.UserStallOwner.ControllerClasses to javafx.fxml;

    exports cse213.todayjava.Ahad.UserStallOwner;
    opens cse213.todayjava.Ahad.UserStallOwner to javafx.fxml;
=======
    opens cse213.todayjava.Arabi.UserMediaPromoter to javafx.base, javafx.fxml;
    opens cse213.todayjava to javafx.fxml;

    exports cse213.todayjava;
    exports cse213.todayjava.Arabi.UserMediaPromoter;
>>>>>>> Stashed changes
}