package com.avapir.soccingover.models;

import java.util.Date;

/** User: Alpen Ditrix Date: 10.11.13 Time: 15:57 */
public class Post {

    private final Date   postingDate;
    private final String author;
    private final String textData;


    public Post(Date postingDate, String author, String textData) {
        this.postingDate = postingDate;
        this.author = author;
        this.textData = textData;
    }

    public String getTextData() {
        return textData;
    }

    public String getAuthor() {

        return author;
    }

    public Date getPostingDate() {

        return postingDate;
    }
}
