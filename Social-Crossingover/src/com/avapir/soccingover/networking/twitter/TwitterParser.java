package com.avapir.soccingover.networking.twitter;

import com.avapir.soccingover.models.TweetTweet;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

/** User: Alpen Ditrix Date: 11.11.13 Time: 10:28 */
public class TwitterParser extends DefaultHandler {

    private List<TweetTweet> result;

    public List<TweetTweet> getResult() {
        return result;
    }

    //TODO implement XML-parser
}
