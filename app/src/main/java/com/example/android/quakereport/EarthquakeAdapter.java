package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Custom ArrayAdapter to provide Earthquake objects for our list_view
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Earthquake currentEQ = getItem(position);

        TextView mag = (TextView) listItemView.findViewById(R.id.mag_text_view);
        mag.setText(currentEQ.getMagnitude());

        TextView loc = (TextView) listItemView.findViewById(R.id.place_text_view);
        loc.setText(currentEQ.getLocation());

        TextView date = (TextView) listItemView.findViewById(R.id.date_text_view);
        Date currentDate = new Date(currentEQ.getTime());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(currentDate);
        date.setText(dateToDisplay);

        return listItemView;
    }
}
