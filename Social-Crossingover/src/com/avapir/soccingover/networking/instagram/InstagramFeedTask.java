package com.avapir.soccingover.networking.instagram;

import android.os.AsyncTask;
import com.avapir.soccingover.models.InstagramPost;

import java.util.Collections;
import java.util.List;

/** User: Alpen Ditrix Date: 11.11.13 Time: 10:21 */
public class InstagramFeedTask extends AsyncTask<Void, Void, List<InstagramPost>> {
    @Override
    protected List<InstagramPost> doInBackground(Void... params) {
        return Collections.emptyList();
    }
}