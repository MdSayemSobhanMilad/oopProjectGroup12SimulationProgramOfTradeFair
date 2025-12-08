package cse213.todayjava.Ahad.UserStallOwner.ModelClasses;

public class NetworkingBusiness {
    private String businessName;
    private String contactPerson;
    private String email;
    private String phone;
    private String addedDate;

    // Constructor
    public NetworkingBusiness() {
    }

    public NetworkingBusiness(String businessName, String contactPerson, String email, String phone) {
        this.businessName = businessName;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return businessName + " - " + contactPerson + " (" + email + ")";
    }
}