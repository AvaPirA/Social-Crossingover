package com.avapir.soccingover.networking;

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/** User: Alpen Ditrix Date: 10.11.13 Time: 16:35 */
public class MyAsyncTask extends AsyncTask<Void, Void, InputStream> {

    private final String url;

    public MyAsyncTask(String requestUrl) {
        url = requestUrl;
    }

    @Override
    protected InputStream doInBackground(Void... params) {
        HttpGet httpGetter = new HttpGet();
        try {
            httpGetter.setURI(new URI(url));
            final HttpClient httpClient = new DefaultHttpClient();
            final HttpResponse response = httpClient.execute(httpGetter);
            final HttpEntity entity = response.getEntity();
            final BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
            return bufHttpEntity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            httpGetter.abort();
            return null;
        }
    }
}
