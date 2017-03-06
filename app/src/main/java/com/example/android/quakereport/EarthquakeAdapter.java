package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(formatMagnitude(currentEQ.getMagnitude()));
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEQ.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView locationOffset = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView primaryLocation = (TextView) listItemView.findViewById(R.id.primary_location);
        String fullLocation = currentEQ.getLocation();
        String locationOff = "Near the";
        String primaryLoc = fullLocation;
        if (fullLocation.contains("of")){
            int index = fullLocation.indexOf("of");
            locationOff = fullLocation.substring(0, index + 2);
            primaryLoc = fullLocation.substring(index + 3, fullLocation.length());
        }
        locationOffset.setText(locationOff);
        primaryLocation.setText(primaryLoc);

        Date currentDate = new Date(currentEQ.getTime());
        String dateToDisplay = formatDate(currentDate);
        String timeToDisplay = formatTime(currentDate);

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(dateToDisplay);

        TextView time = (TextView) listItemView.findViewById(R.id.time);
        time.setText(timeToDisplay);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude){

        switch ((int)magnitude) {
            case 2: return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3: return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4: return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5: return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6: return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7: return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8: return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9: return ContextCompat.getColor(getContext(), R.color.magnitude9);
            case 10: return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
            default: return ContextCompat.getColor(getContext(), R.color.magnitude1);

        }
    }
}
