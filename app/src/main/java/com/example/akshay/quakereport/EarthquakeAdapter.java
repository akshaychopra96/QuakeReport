package com.example.akshay.quakereport;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

public EarthquakeAdapter(Context c, ArrayList<Earthquake> earthquake){
    super(c,0, (List<Earthquake>) earthquake);
}


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    Earthquake e = getItem(position);

    if(convertView == null)
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent,false);

        TextView mag = convertView.findViewById(R.id.mag);
        TextView loc = convertView.findViewById(R.id.loc);
        TextView date = convertView.findViewById(R.id.date);
        TextView time = convertView.findViewById(R.id.time);
        TextView location2 = convertView.findViewById(R.id.loc2);

        Date dateObject = new Date(e.getTime());

      //  Log.e("tag",""+e.getTime());

        // steps to represent milliseconds in date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd LLL, yyyy");
        String formatDate = dateFormat.format(dateObject);

        //Steps to represent time
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        String formatTime = timeFormat.format(dateObject);

       // Log.e("tag",formatTime);

// Create a calendar object that will convert the date and time value in milliseconds to date.
        /*Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(e.getTime());
        String t = formatter.format(calendar.getTime());
*/


        String originalLocation = e.getLocation();

        Log.e("tag",originalLocation);

        String array[] = originalLocation.split("of ");
        String loc1 = array[0];
        String loc2 = array[1]; // this is the 68 line
//Log.e("tag","length: "+array.length);
        Log.e("tag","loc1 is "+loc1);
       Log.e("tag","loc2 is "+loc2);

        double magnitude = e.getMagnitude();
        DecimalFormat df = new DecimalFormat("0.0");
        String truncatedMag = df.format(magnitude);

        time.setText(formatTime);
        date.setText(formatDate);
        mag.setText(truncatedMag);
        loc.setText(loc1);
        location2.setText(loc2);

       // time.setText(String.valueOf(e.getTime()));

        return convertView;
    }
}