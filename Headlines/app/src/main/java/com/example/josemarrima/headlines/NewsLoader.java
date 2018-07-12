package com.example.josemarrima.headlines;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Jose Marrima on 15/10/2017.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Tag for log messages */
    private static final String LOG_TAG = NewsAdapter.class.getName();

    /** Query URL */
    private String url;

    public NewsLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (url == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<News> newsArrayList = QueryUtils.fetchNewsData(url);
        return newsArrayList;
    }
}
