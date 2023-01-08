package com.example.studentvoting;

public class Candidate {
    private String name;
    private String party;
    private String faculty;

    public Candidate(String name, String party, String faculty){
        this.name = name;
        this.party = party;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
