package com.example.studentvoting;

import java.util.List;

public class Faculty {
    String facName;
    List<Candidate> candidateList;

    public Faculty(String name, List<Candidate> candidateList){
        this.facName = name;
        this.candidateList = candidateList;
    }

    public String getName() {
        return facName;
    }

    public void setName(String name) {
        this.facName = facName;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }
}
