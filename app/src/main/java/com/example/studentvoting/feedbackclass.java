package com.example.studentvoting;

public class feedbackclass {
    String feedback;
    int rating;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public feedbackclass(String feedback, int rating) {
        this.feedback = feedback;
        this.rating = rating;
    }
}
