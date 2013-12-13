package com.avapir.soccingover.networking.twitter;

import android.os.AsyncTask;
import com.avapir.soccingover.models.TweetTweet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/** User: Alpen Ditrix Date: 11.11.13 Time: 10:21 */
public class TwitterFeedTask extends AsyncTask<Void, Void, List<TweetTweet>> {

    public static final TwitterApiHandler api = new TwitterApiHandler();

    @Override
    protected List<TweetTweet> doInBackground(Void... params) {
        try {
            final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            final SAXParser saxParser = saxParserFactory.newSAXParser();
            final TwitterParser parser = new TwitterParser();

            saxParser.parse(api.requestFeed(), parser);
            return parser.getResult();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
        } finally {
            return Collections.emptyList();
        }
    }
}