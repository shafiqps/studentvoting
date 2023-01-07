package com.example.studentvoting;

public class News {

    String title_news;
    String descNews;
    int imageNews;

    public News(String title_news, String descNews, int imageNews) {
        this.title_news = title_news;
        this.descNews = descNews;
        this.imageNews = imageNews;
    }

    public String getTitle_news() {
        return title_news;
    }

    public void setTitle_news(String title_news) {
        this.title_news = title_news;
    }

    public String getDescNews() {
        return descNews;
    }

    public void setDescNews(String descNews) {
        this.descNews = descNews;
    }

    public int getImageNews() {
        return imageNews;
    }

    public void setImageNews(int imageNews) {
        this.imageNews = imageNews;
    }
}
