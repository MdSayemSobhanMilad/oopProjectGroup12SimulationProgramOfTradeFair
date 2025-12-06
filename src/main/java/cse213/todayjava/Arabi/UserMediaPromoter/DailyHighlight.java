package cse213.todayjava.Arabi.UserMediaPromoter;

import java.time.LocalDate;

public class DailyHighlight {
    private String selectMedia;
    private String mediaList;
    private String summary;
    private LocalDate dailyDate;


    public DailyHighlight(String selectMedia, String mediaList, String summary, LocalDate dailyDate) {
        this.selectMedia = selectMedia;
        this.mediaList = mediaList;
        this.summary = summary;
        this.dailyDate = dailyDate;
    }


    public DailyHighlight() {
    }


    public String getSelectMedia() {
        return selectMedia;
    }

    public void setSelectMedia(String selectMedia) {
        this.selectMedia = selectMedia;
    }

    public String getMediaList() {
        return mediaList;
    }

    public void setMediaList(String mediaList) {
        this.mediaList = mediaList;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getDailyDate() {
        return dailyDate;
    }

    public void setDailyDate(LocalDate dailyDate) {
        this.dailyDate = dailyDate;
    }


    @Override
    public String toString() {
        return selectMedia + " | " + mediaList + " | " + summary + " | " + dailyDate;
    }
}