package com.example.studentvoting;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    String facName;
    ArrayList<Candidate> candidateList;

    public Faculty(String name, ArrayList<Candidate> candidateList){
        this.facName = name;
        this.candidateList = candidateList;
    }

    public Faculty(String name){
        this.facName = name;
    }

    public String getName() {
        return facName;
    }

    public void setName(String name) {
        this.facName = facName;
    }

    public ArrayList<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(ArrayList<Candidate> candidateList) {
        this.candidateList = candidateList;
    }
}
