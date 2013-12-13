package com.avapir.soccingover.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import com.avapir.soccingover.R;
import com.avapir.soccingover.core.DataHandler;
import com.perm.kate.api.KException;
import com.perm.kate.api.beans.NewsItem;
import org.json.JSONException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FeedActivity extends ListActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bar.setVisibility(View.VISIBLE);
                        }
                    });
                    final List<NewsItem> items = DataHandler.api
                                                            .getNews(System.currentTimeMillis() / 1000 - 60 *
                                                                    60, 50, null, null, null, null, "post", 0, null,
                                                                     null).items;
                    for (NewsItem item : items) {
                        System.out.println("id:" + item.source_id + "\nText:" + item.text + "\n");
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("hello from ui");
                            setListAdapter(new ArrayAdapter(FeedActivity.this, android.R.layout.simple_list_item_1,
                                                            toStrings(items)));
                            bar.setVisibility(View.INVISIBLE);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (KException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private String[] toStrings(List<NewsItem> items) {
        String[] arr = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            NewsItem item = items.get(i);

            String text = "id:" + item.source_id;
            text = text.concat("\n" + item.text);
            text = text.concat(String.format("\n%s attachments", item.attachments.size()));
            text = text.concat(String.format("\n%s likes, %s reposts", item.like_count, item.reposts_count));
            arr[i] = text;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

}
