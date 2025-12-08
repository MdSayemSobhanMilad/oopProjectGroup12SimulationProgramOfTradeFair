package cse213.todayjava.Arabi.UserMediaPromoter;

import java.util.Date;

public class News {
    private String newsId;
    private String title;
    private String content;
    private Date publishDate;
    private String mediaPromoterId;

<<<<<<< Updated upstream

=======
    // Constructor
>>>>>>> Stashed changes
    public News(String newsId, String title, String content, Date publishDate, String mediaPromoterId) {
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
        this.mediaPromoterId = mediaPromoterId;
    }

<<<<<<< Updated upstream

    public News() {}


=======
    // Default constructor
    public News() {}

    // Getters and Setters
>>>>>>> Stashed changes
    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getMediaPromoterId() {
        return mediaPromoterId;
    }

    public void setMediaPromoterId(String mediaPromoterId) {
        this.mediaPromoterId = mediaPromoterId;
    }

<<<<<<< Updated upstream

=======
    // Methods from UML
>>>>>>> Stashed changes
    public void publish() {
        System.out.println("News published: " + title);
    }

    public void edit() {
        System.out.println("News edited: " + title);
    }

<<<<<<< Updated upstream

=======
    // toString method
>>>>>>> Stashed changes
    @Override
    public String toString() {
        return "News{" +
                "newsId='" + newsId + '\'' +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", mediaPromoterId='" + mediaPromoterId + '\'' +
                '}';
    }
}