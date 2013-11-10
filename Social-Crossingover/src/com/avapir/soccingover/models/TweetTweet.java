package com.avapir.soccingover.models;

import java.util.Date;

/** User: Alpen Ditrix Date: 10.11.13 Time: 15:56 */
public class TweetTweet extends Post {

    //TODO число ретвитов\избранноного

    public TweetTweet(Date postingDate, String author, String textData, String webLink) {
        super(postingDate, author, textData, webLink);
    }
}
