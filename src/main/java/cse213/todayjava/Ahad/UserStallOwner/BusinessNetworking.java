package cse213.todayjava.Ahad.UserStallOwner;

public class BusinessNetworking {
    private String networkId;

    public BusinessNetworking(String networkId) {
        this.networkId = networkId;
    }

    // Getters and Setters
    public String getNetworkId() { return networkId; }
    public void setNetworkId(String networkId) { this.networkId = networkId; }

    // Methods
    public void exchangeContacts(String vendorName, String contactInfo) {
        System.out.println("Contact exchanged with: " + vendorName);
        System.out.println("Contact info: " + contactInfo);
    }

    public boolean validateCompliance(String contactData) {
        boolean isCompliant = contactData != null && !contactData.isEmpty();
        System.out.println("Compliance validation: " + (isCompliant ? "COMPLIANT" : "NON-COMPLIANT"));
        return isCompliant;
    }

    public void saveContact(String contactId, String vendorName, String contactInfo) {
        if (validateCompliance(contactInfo)) {
            System.out.println("Contact saved: " + vendorName + " (" + contactId + ")");
        } else {
            System.out.println("Contact not saved due to compliance issues.");
        }
    }

    @Override
    public String toString() {
        return "BusinessNetworking{" +
                "networkId='" + networkId + '\'' +
                '}';
    }
}
