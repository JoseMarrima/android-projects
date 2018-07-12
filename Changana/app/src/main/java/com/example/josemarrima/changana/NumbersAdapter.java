package com.example.josemarrima.changana;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jose Marrima on 18/5/2017.
 */

public class NumbersAdapter extends ArrayAdapter<Numbers> {

    public NumbersAdapter(Activity context, ArrayList<Numbers> numbers){
        super(context, 0, numbers);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Numbers currentNumbers = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView defaultLanguage = (TextView) listItemView.findViewById(R.id.default_language);
        defaultLanguage.setText(currentNumbers.getmDefaultLanguage());

        TextView changanaLanguage = (TextView) listItemView.findViewById(R.id.changana_language);
        changanaLanguage.setText(currentNumbers.getmChanganaLanguage());

        ImageView leftImage = (ImageView) listItemView.findViewById(R.id.image_view);
        leftImage.setImageResource(currentNumbers.getImageReseourceId());

        ImageView playImage = (ImageView) listItemView.findViewById(R.id.play_button);
        playImage.setImageResource(currentNumbers.getmAudioResourceId());

        return listItemView;
    }
}
