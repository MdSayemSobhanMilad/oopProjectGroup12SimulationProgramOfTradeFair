package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class ExhibitorComplaint {
    private String selectedComplaint;
    private String resolutionNotes;


    public ExhibitorComplaint(String selectedComplaint, String resolutionNotes) {
        this.selectedComplaint = selectedComplaint;
        this.resolutionNotes = resolutionNotes;
    }


    public ExhibitorComplaint() {
    }


    public String getSelectedComplaint() {
        return selectedComplaint;
    }

    public void setSelectedComplaint(String selectedComplaint) {
        this.selectedComplaint = selectedComplaint;
    }

    public String getResolutionNotes() {
        return resolutionNotes;
    }

    public void setResolutionNotes(String resolutionNotes) {
        this.resolutionNotes = resolutionNotes;
    }


    @Override
    public String toString() {
        return selectedComplaint + ": " + resolutionNotes;
    }
}