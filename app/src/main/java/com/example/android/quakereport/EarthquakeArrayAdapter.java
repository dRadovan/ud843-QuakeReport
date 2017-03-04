package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Custom ArrayAdapter to provide Earthquake objects for our list_view
 */

public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeArrayAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.eq_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Earthquake currentEQ = getItem(position);

        TextView mag = (TextView) listItemView.findViewById(R.id.mag_text_view);
        mag.setText(currentEQ.getMagnitude());

        TextView loc = (TextView) listItemView.findViewById(R.id.place_text_view);
        loc.setText(currentEQ.getLocation());

        TextView date = (TextView) listItemView.findViewById(R.id.date_text_view);
        date.setText(currentEQ.getDate());

        return listItemView;
    }
}
