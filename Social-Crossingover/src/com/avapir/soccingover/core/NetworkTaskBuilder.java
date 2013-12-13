package com.avapir.soccingover.core;

import android.os.AsyncTask;
import com.avapir.soccingover.networking.instagram.InstagramFeedTask;
import com.avapir.soccingover.networking.twitter.TwitterFeedTask;
import com.avapir.soccingover.networking.vk.VkFeedTask;

/** User: Alpen Ditrix Date: 24.11.13 Time: 14:16 */
public class NetworkTaskBuilder {

    private static final AsyncTask EMPTY_TASK = new AsyncTask() {
        @Override
        protected Object doInBackground(Object... params) {
            return null;
        }
    };

    public static AsyncTask createNewTaskFor(NegotiableServices serviceType) {
        switch (serviceType) {
            case INSTAGRAM:
                return new InstagramFeedTask();
            case TWITTER:
                return new TwitterFeedTask();
            case VK:
                return new VkFeedTask();
            default:
                return EMPTY_TASK;
        }
    }

}
