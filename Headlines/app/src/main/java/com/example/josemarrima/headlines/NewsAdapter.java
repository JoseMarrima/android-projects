package com.example.josemarrima.headlines;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jose Marrima on 15/10/2017.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    /** Tag for the log messages */
    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();

    public NewsAdapter(Activity context, ArrayList<News> news) {

        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;

        ///check of the listViewItem is inflated, if not inflate
        if(listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.headline_news_item,
                    parent, false);
        }

        // get the current news article position
        News currentNews = getItem(position);

        // Find the textview for the title
        TextView titleTextView = (TextView) listViewItem.findViewById(R.id.news_title);
        //set the title to the titleTextView
        titleTextView.setText(currentNews.getTitle());

        // Find the textview for the description
        TextView descriptionTextView = (TextView) listViewItem.findViewById(R.id.news_description);
        //set the title to the descriptionTextView
        descriptionTextView.setText(currentNews.getDescription());


        return listViewItem;
    }
}
