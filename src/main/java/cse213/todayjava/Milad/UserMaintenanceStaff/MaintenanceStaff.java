package cse213.todayjava.Milad.UserMaintenanceStaff;
import java.time.LocalDateTime;
import java.util.List;
import cse213.todayjava.User;

public class MaintenanceStaff extends User {
    private String employeeId;
    private String name;
    private String department;
    private String contactNumber;

    public MaintenanceStaff(String userId, String userType, String employeeId, String name, String department, String contactNumber) {
        super(userId, name);
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.contactNumber = contactNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "MaintenanceStaff{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}