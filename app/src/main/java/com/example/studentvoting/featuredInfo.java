package com.example.studentvoting;

public class featuredInfo {
    String image;
    String info;

    public featuredInfo(String image, String info) {
        this.image = image;
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
