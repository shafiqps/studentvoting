package com.example.studentvoting;

public class CandidateList {
    String name;
    String party;
    String id;
    int image;

    @Override
    public String toString() {
        return "CandidateList{" +
                "name='" + name + '\'' +
                ", party='" + party + '\'' +
                ", image=" + image +
                '}';
    }

    public String getId() {
        return id;
    }

    public CandidateList(String name, String party, String id) {
        this.name = name;
        this.party = party;
        this.id = id;
    }

    public CandidateList(String name, String party, int image, String id) {
        this.name = name;
        this.party = party;
        this.image = image;
        this.id = id;
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
