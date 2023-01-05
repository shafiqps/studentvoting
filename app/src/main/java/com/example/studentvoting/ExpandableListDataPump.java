package com.example.studentvoting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> faq1 = new ArrayList<String>();
        faq1.add("A group of Year 2 Students that wanted to make elections easier.");
        List<String> faq2 = new ArrayList<String>();
        faq2.add("The purpose of this app is to create a more complete and comprehensive system for students to participate in University Malaya elections.");
        List<String> faq3 = new ArrayList<String>();
        faq3.add("This app is meant to be used for University Malaya students only.");


        expandableListDetail.put("Who created this app?", faq1);
        expandableListDetail.put("What is the main purpose of this app?", faq2);
        expandableListDetail.put("Can anyone use this app?", faq3);
        return expandableListDetail;
    }
}