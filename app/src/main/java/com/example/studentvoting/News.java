package com.example.studentvoting;

public class News {

    String heading;
    String descNews;
    int imageView;

    public News(String heading, int imageView, String s) {
        this.heading = heading;
        this.imageView = imageView;
        this.descNews = descNews;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescNews() {
        return descNews;
    }

    public void setDescNews(String descNews) {
        this.descNews = descNews;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
