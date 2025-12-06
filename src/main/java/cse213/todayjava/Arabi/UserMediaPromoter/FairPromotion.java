package cse213.todayjava.Arabi.UserMediaPromoter;

import java.time.LocalDate;

public class FairPromotion {
    private LocalDate promotionDate;
    private String promotionStatus;


    public FairPromotion(LocalDate promotionDate, String promotionStatus) {
        this.promotionDate = promotionDate;
        this.promotionStatus = promotionStatus;
    }


    public FairPromotion() {
    }


    public LocalDate getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(LocalDate promotionDate) {
        this.promotionDate = promotionDate;
    }

    public String getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(String promotionStatus) {
        this.promotionStatus = promotionStatus;
    }


    @Override
    public String toString() {
        return promotionDate + " | " + promotionStatus;
    }
}