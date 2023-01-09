package com.example.studentvoting;

public class CandidateList {
    String name;
    String party;
    int image;

    public CandidateList(String name, String party, int image) {
        this.name = name;
        this.party = party;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public int getImage() {
        return image;
    }
}
