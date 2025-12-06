package cse213.todayjava.Arabi.UserMediaPromoter;

public class SponsorContent {
    private String selectSponsor;
    private String containtDetails;
    private String approval;


    public SponsorContent(String selectSponsor, String containtDetails, String approval) {
        this.selectSponsor = selectSponsor;
        this.containtDetails = containtDetails;
        this.approval = approval;
    }


    public SponsorContent() {
    }


    public String getSelectSponsor() {
        return selectSponsor;
    }

    public void setSelectSponsor(String selectSponsor) {
        this.selectSponsor = selectSponsor;
    }

    public String getContaintDetails() {
        return containtDetails;
    }

    public void setContaintDetails(String containtDetails) {
        this.containtDetails = containtDetails;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }


    @Override
    public String toString() {
        return selectSponsor + " | " + containtDetails + " | " + approval;
    }
}