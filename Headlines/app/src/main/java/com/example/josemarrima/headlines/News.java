package com.example.josemarrima.headlines;

/**
 * Created by Jose Marrima on 15/10/2017.
 */

public class News {

    /* This News Class represents a single news article */

    private String title; // this is the title of the article
    private String description; // this is the body of the article

    /*
        *This creates the object named news that will host a single news article
        * @param title represents the title of the news article
        * @param description represents the news article body
     */

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
