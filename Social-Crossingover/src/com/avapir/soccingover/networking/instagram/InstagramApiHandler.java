package com.avapir.soccingover.networking.instagram;

import com.avapir.soccingover.models.Post;
import com.avapir.soccingover.networking.INetworking;

import java.io.InputStream;
import java.util.List;

/** User: Alpen Ditrix Date: 10.11.13 Time: 16:24 */
public class InstagramApiHandler implements INetworking {
    public static final String CLIENT_ID     = "65ce60395bea4c869a977d8c74290434";
    public static final String CLIEND_SECRET = "542fb46a6d0e449daaaff02d1ee7d9f6";

    @Override
    public String login(String login, String password) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Post> getRecentPosts() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public InputStream requestFeed() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
