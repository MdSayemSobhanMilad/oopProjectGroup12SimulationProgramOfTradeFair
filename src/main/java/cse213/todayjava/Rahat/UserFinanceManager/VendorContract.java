package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.Date;

// ==================== VENDOR CONTRACT MANAGEMENT ====================

// VendorContract Class
class VendorContract {
    private String contractId;
    private String vendorId;
    private Date startDate;
    private Date endDate;
    private Double contractValue;
    private String paymentSchedule; // "MONTHLY", "QUARTERLY", "UPFRONT"
    private String status; // "ACTIVE", "EXPIRED", "TERMINATED"
    private Vendor vendor;

    public VendorContract(String contractId, String vendorId, Date startDate,
                          Date endDate, Double contractValue, Vendor vendor) {
        this.contractId = contractId;
        this.vendorId = vendorId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractValue = contractValue;
        this.paymentSchedule = "MONTHLY";
        this.status = "ACTIVE";
        this.vendor = vendor;
    }

    public boolean verifyCompliance() {
        Date currentDate = new Date();
        if (currentDate.after(endDate)) {
            this.status = "EXPIRED";
            System.out.println("Contract " + contractId + " has expired");
            return false;
        }

        System.out.println("Contract " + contractId + " is compliant");
        return true;
    }

    public void checkPaymentDeadlines() {
        Date currentDate = new Date();
        // Calculate next payment deadline
        System.out.println("Checking payment deadlines for contract: " + contractId);
        System.out.println("Vendor: " + vendor.getName());
        System.out.println("Contract value: $" + contractValue);
        System.out.println("Payment schedule: " + paymentSchedule);
    }

    // Getters and Setters
    public String getContractId() { return contractId; }
    public void setContractId(String contractId) { this.contractId = contractId; }

    public String getVendorId() { return vendorId; }
    public void setVendorId(String vendorId) { this.vendorId = vendorId; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Double getContractValue() { return contractValue; }
    public void setContractValue(Double contractValue) { this.contractValue = contractValue; }

    public String getPaymentSchedule() { return paymentSchedule; }
    public void setPaymentSchedule(String paymentSchedule) { this.paymentSchedule = paymentSchedule; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
}
