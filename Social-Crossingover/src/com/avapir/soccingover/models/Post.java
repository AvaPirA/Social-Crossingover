package com.avapir.soccingover.models;

import java.util.Date;

/** User: Alpen Ditrix Date: 10.11.13 Time: 15:57 */
public class Post {

    private final Date   postingDate;
    private final String author;
    private final String textData;
    private final String webLink;
    private final int    likes;

    public Post(Date postingDate, String author, String textData, String webLink, int likes) {
        this.postingDate = postingDate;
        this.author = author;
        this.textData = textData;
        this.webLink = webLink;
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public String getTextData() {
        return textData;
    }

    public String getAuthor() {

        return author;
    }

    public String getWebLink() {
        return webLink;
    }

    public Date getPostingDate() {

        return postingDate;
    }
}
