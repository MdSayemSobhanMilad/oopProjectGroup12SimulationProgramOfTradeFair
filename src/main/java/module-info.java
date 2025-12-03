module cse213.todayjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafx.graphics;


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

    exports cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;
    opens cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses to javafx.fxml;

    exports cse213.todayjava.Arabi.UserMediaPromoter;
    opens cse213.todayjava.Arabi.UserMediaPromoter to javafx.fxml;

    exports cse213.todayjava.Arabi.UserGovernmentOfficer;
    opens cse213.todayjava.Arabi.UserGovernmentOfficer to javafx.fxml;

    exports cse213.todayjava.Rahat.UserVisitor;
    opens cse213.todayjava.Rahat.UserVisitor to javafx.fxml;


}