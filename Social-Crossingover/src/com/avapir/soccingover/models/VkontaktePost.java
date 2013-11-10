package com.avapir.soccingover.models;

import android.graphics.drawable.Drawable;

import java.util.Date;

/** User: Alpen Ditrix Date: 10.11.13 Time: 15:56 */
public class VkontaktePost extends Post {

    //TODO репосты\лайки

    private final Drawable picture;

    public VkontaktePost(Date postingDate, String author, String textData, String webLink, Drawable picture) {
        super(postingDate, author, textData, webLink);
        this.picture = picture;
    }
}
