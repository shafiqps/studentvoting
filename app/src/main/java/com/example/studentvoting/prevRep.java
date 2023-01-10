package com.example.studentvoting;

public class prevRep {
    String session;
    int image;
    String name;

    public prevRep(String session, int image, String name) {
        this.session = session;
        this.image = image;
        this.name = name;
    }

    public String getSession() {
        return session;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
