package com.avapir.soccingover.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.perm.kate.api.beans.NewsItem;

import java.util.List;

/**
 * User: Alpen Ditrix Date: 11.12.13 Time: 23:37
 */
public class TextArrayAdapter extends ArrayAdapter<NewsItem> {

    private static final int res = android.R.layout.simple_list_item_1;

    public TextArrayAdapter(Context context, List<NewsItem> values) {
        super(context, res, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(res, parent, false);
        TextView author = (TextView) view.findViewById(android.R.id.text1);
//        TextView post = (TextView) view.findViewById(android.R.id.text2);
        NewsItem item = getItem(position);
//        author.setText("id: " + item.source_id);
        String text = item.text;
        text.concat(String.format("\n%s attachments", item.attachments.size()));
        text.concat(String.format("\n%s likes, %s reposts", item.like_count, item.reposts_count));
        author.setText(text);
        return view;
    }
}
