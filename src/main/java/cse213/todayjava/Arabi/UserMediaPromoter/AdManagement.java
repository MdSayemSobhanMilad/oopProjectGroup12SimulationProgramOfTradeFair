package cse213.todayjava.Arabi.UserMediaPromoter;

public class AdManagement {
    private String addId;
    private String sponsor;
    private String addType;
    private String status;


    public AdManagement(String addId, String sponsor, String addType, String status) {
        this.addId = addId;
        this.sponsor = sponsor;
        this.addType = addType;
        this.status = status;
    }


    public AdManagement() {
    }


    public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return addId + " | " + sponsor + " | " + addType + " | " + status;
    }
}