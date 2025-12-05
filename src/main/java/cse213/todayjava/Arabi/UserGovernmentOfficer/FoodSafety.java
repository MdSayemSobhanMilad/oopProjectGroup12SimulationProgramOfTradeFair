package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class FoodSafety {
    private String hygenicCheck;
    private String reviewFoodStatus;

    // Constructor with parameters
    public FoodSafety(String hygenicCheck, String reviewFoodStatus) {
        this.hygenicCheck = hygenicCheck;
        this.reviewFoodStatus = reviewFoodStatus;
    }

    // Empty constructor
    public FoodSafety() {
    }

    // Getters and Setters
    public String getHygenicCheck() {
        return hygenicCheck;
    }

    public void setHygenicCheck(String hygenicCheck) {
        this.hygenicCheck = hygenicCheck;
    }

    public String getReviewFoodStatus() {
        return reviewFoodStatus;
    }

    public void setReviewFoodStatus(String reviewFoodStatus) {
        this.reviewFoodStatus = reviewFoodStatus;
    }

    // toString method
    @Override
    public String toString() {
        return hygenicCheck + " - " + reviewFoodStatus;
    }
}