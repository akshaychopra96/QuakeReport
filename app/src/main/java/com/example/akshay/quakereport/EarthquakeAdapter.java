package com.example.akshay.quakereport;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context c, ArrayList<Earthquake> earthquake) {
        super(c, 0, (List<Earthquake>) earthquake);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Earthquake e = getItem(position);
        Log.d("Adapter", String.valueOf(position));

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }
        TextView mag = convertView.findViewById(R.id.mag);
        TextView loc = convertView.findViewById(R.id.loc);
        TextView date = convertView.findViewById(R.id.date);
        TextView time = convertView.findViewById(R.id.time);
        TextView location2 = convertView.findViewById(R.id.loc2);

        Date dateObject = new Date(e.getTime());

        // steps to represent milliseconds in date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd LLL, yyyy");
        String formatDate = dateFormat.format(dateObject);

        //Steps to represent time
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        String formatTime = timeFormat.format(dateObject);


        String originalLocation = e.getLocation();

        Log.e("tag", originalLocation);

        String loc1 = "";
        String loc2 = "";

/*        The error was caused as the last line of Json Pacific-Antarctic Ridge does not contain "of"
            in its string. Hence you were getting IndexOutOfBoundsException because the value
            didn't exist at all.
*/

        if (originalLocation.toLowerCase().contains("of ")){ // Check if the String or originalLocation has the string of to split
            String array[] = originalLocation.split("of ");// If of is present then split to array
            // Get values from array
            loc1 = array[0];
            loc2 = array[1];

            Log.e("tag", "loc1 is " + loc1);
            Log.e("tag", "loc2 is " + loc2);

        }else { // Of is not present in the originalLocation
             loc1 = originalLocation; // Set text originalLocation to loc1
             loc2 = "";
        }


        loc.setText(loc1);
        location2.setText(loc2);

        double magnitude = e.getMagnitude();
        DecimalFormat df = new DecimalFormat("0.0");
        String truncatedMag = df.format(magnitude);
        time.setText(formatTime);
        date.setText(formatDate);
        mag.setText(truncatedMag);

        return convertView;
    }
}