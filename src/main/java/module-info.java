module cse213.todayjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafx.graphics;



    exports cse213.todayjava;
    opens cse213.todayjava to javafx.fxml;

    // FIX: Add this line to allow JavaFX to access MaintenanceReport
    opens cse213.todayjava.Milad.UserMaintenanceStaff to javafx.base;
    opens cse213.todayjava.Milad.UserSecurityPersonnel to javafx.base;
    opens cse213.todayjava.Ahad.UserStallOwner to javafx.base;
    opens cse213.todayjava.Ahad.UserTicketCounterStaff to javafx.base;
    opens cse213.todayjava.Rahat.UserVisitor to javafx.base;
    opens cse213.todayjava.Rahat.UserFinanceManager to javafx.base;


    exports cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;
    opens cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses to javafx.fxml;

    exports cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses;
    opens cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses to javafx.fxml;

    exports cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;
    opens cse213.todayjava.Ahad.UserStallOwner.ControllerClasses to javafx.fxml;

    exports cse213.todayjava.Ahad.UserStallOwner;


    exports cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;
    opens cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses to javafx.fxml;

    exports cse213.todayjava.Arabi.UserMediaPromoter;
    opens cse213.todayjava.Arabi.UserMediaPromoter to javafx.fxml;

    exports cse213.todayjava.Arabi.UserGovernmentOfficer;
    opens cse213.todayjava.Arabi.UserGovernmentOfficer to javafx.fxml;

    exports cse213.todayjava.Rahat.UserVisitor;


    exports cse213.todayjava.Milad.UserMaintenanceStaff;
}