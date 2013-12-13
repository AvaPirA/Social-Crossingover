package com.avapir.soccingover.networking.twitter;

import com.avapir.soccingover.models.Post;
import com.avapir.soccingover.networking.INetworking;

import java.io.InputStream;
import java.util.List;

/** User: Alpen Ditrix Date: 10.11.13 Time: 16:17 */
public class TwitterApiHandler implements INetworking {

    ///OAuth settings
    public static final String CUSTOMER_KEY        = "GAH63p8smZmI5agFI35jSA";
    public static final String CUSTOMER_SECRET     = "Wymv8sckDz3ZOUAArPYTFVDyycg1auMMKt0nYgAvQ5A";
    public static final String REQUEST_TOKEN       = "https://api.twitter.com/oauth/request_token";
    public static final String AUTHORIZE_URL       = "https://api.twitter.com/oauth/authorize";
    public static final String ACCESS_TOKEN_URL    = "https://api.twitter.com/oauth/access_token";
    //Your access token
    public static final String ACCESS_TOKEN        = "407279333-augMfvLQQ1aV5XOY6UcsmQlGtRn98Pc7z3wgDRCZ";
    public static final String ACCESS_TOKEN_SECRET = "m9oUM4hnWhrrvErxlEiBCwBBgFexQT1mbY6GMLpMboufj";


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
