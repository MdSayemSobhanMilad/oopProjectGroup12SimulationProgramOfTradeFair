package cse213.todayjava.Arabi.UserMediaPromoter;

public class PhotoData {
    private String uploadType;
    private String requirements;
    private String details;


    public PhotoData(String uploadType, String requirements, String details) {
        this.uploadType = uploadType;
        this.requirements = requirements;
        this.details = details;
    }


    public PhotoData() {
    }


    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    @Override
    public String toString() {
        return uploadType + " | " + requirements + " | " + details;
    }
}