package com.avapir.soccingover.models;

import android.graphics.drawable.Drawable;

import java.util.Date;

/** User: Alpen Ditrix Date: 10.11.13 Time: 15:57 */
public class InstagramPost extends Post {


    private final Drawable picture;

    public InstagramPost(Date postingDate, String author, String textData, Drawable picture) {
        super(postingDate, author, textData);
        this.picture = picture;
    }
}
