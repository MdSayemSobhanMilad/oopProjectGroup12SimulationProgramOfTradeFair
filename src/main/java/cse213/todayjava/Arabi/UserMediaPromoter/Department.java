package cse213.todayjava.Arabi.UserMediaPromoter;

public class Department {
    private String deptId;
    private String name;
    private String head;

    // Constructor
    public Department(String deptId, String name, String head) {
        this.deptId = deptId;
        this.name = name;
        this.head = head;
    }

    // Default constructor
    public Department() {
    }

    // Getters and Setters
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    // toString method
    @Override
    public String toString() {
        return "Department{" +
                "deptId='" + deptId + '\'' +
                ", name='" + name + '\'' +
                ", head='" + head + '\'' +
                '}';
    }
}