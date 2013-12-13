package com.avapir.soccingover.models;

import android.graphics.drawable.Drawable;

import java.util.Date;

/** User: Alpen Ditrix Date: 10.11.13 Time: 15:56 */
public class VkPost extends Post {

    //TODO репосты\лайки

    private final Drawable picture;

    public VkPost(Date postingDate, String author, String textData, String webLink, Drawable picture) {
        super(postingDate, author, textData, webLink);
        this.picture = picture;
    }
}
