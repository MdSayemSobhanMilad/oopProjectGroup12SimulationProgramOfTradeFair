package cse213.todayjava.Arabi.UserMediaPromoter;

import cse213.todayjava.User;
import java.io.Serializable;
import java.time.LocalDate;

public class MediaPromoter extends User implements Serializable {
    private String mediaId;
    private String department;
    private String newsTitle;
    private String reporterName;
    private String description;
    private LocalDate publishingDate;

    public MediaPromoter(String userId, String name, String mediaId, String department) {
        super(userId, name);
        this.mediaId = mediaId;
        this.department = department;
    }

    public MediaPromoter() {
        super("", "");
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    @Override
    public String toString() {
        return newsTitle + " - " + reporterName + " (" + publishingDate + ")";
    }


    public static void saveNewsToFile(MediaPromoter news) {
        try {
            java.io.File file = new java.io.File("news_data.bin");
            java.io.ObjectOutputStream oos;

            if (file.exists() && file.length() > 0) {
                oos = new java.io.ObjectOutputStream(
                        new java.io.FileOutputStream("news_data.bin", true)) {
                    protected void writeStreamHeader() {

                    }
                };
            } else {
                oos = new java.io.ObjectOutputStream(
                        new java.io.FileOutputStream("news_data.bin"));
            }

            oos.writeObject(news);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static java.util.ArrayList<MediaPromoter> loadNewsFromFile() {
        java.util.ArrayList<MediaPromoter> newsList = new java.util.ArrayList<>();
        try {
            java.io.File file = new java.io.File("news_data.bin");
            if (!file.exists() || file.length() == 0) {
                return newsList;
            }

            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(
                    new java.io.FileInputStream("news_data.bin"));

            while (true) {
                try {
                    MediaPromoter news = (MediaPromoter) ois.readObject();
                    newsList.add(news);
                } catch (java.io.EOFException e) {
                    break;
                }
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }
}