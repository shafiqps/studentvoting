package com.example.studentvoting;

public class featuredInfo {
    int image;
    String info;

    public featuredInfo(int image, String info) {
        this.image = image;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
