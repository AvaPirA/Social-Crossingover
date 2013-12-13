package com.avapir.soccingover.models;

import android.graphics.drawable.Drawable;

import java.util.Date;

/** User: Alpen Ditrix Date: 10.11.13 Time: 15:57 */
public class InstagramPost extends Post {

    private final String   filterTitle;
    private final Drawable picture;

    public InstagramPost(Date postingDate,
                         String author,
                         String textData,
                         String webLink,
                         int likes,
                         Drawable picture,
                         String filterTitle) {
        super(postingDate, author, textData, webLink);
        this.picture = picture;
        this.filterTitle = filterTitle;
    }
}
