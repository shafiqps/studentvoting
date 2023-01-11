package com.example.studentvoting;

public class Student {
    String name;
    String matrixno;
    String siswamail;
    String password;
    String address;
    String image;
    int currentVote;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatrixno() {
        return matrixno;
    }

    public void setMatrixno(String matrixno) {
        this.matrixno = matrixno;
    }

    public String getSiswamail() {
        return siswamail;
    }

    public void setSiswamail(String siswamail) {
        this.siswamail = siswamail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Student(String name, String matrixno, String siswamail, String password, String address, String faculty, String image, int currentVote) {
        this.name = name;
        this.matrixno = matrixno;
        this.siswamail = siswamail;
        this.password = password;
        this.address = address;
        this.faculty = faculty;
        this.image = image;
        this.currentVote = currentVote;
    }

    String faculty;
}
