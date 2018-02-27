package com.example.akshay.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date dateObject = new Date();

        ArrayList<Earthquake> dataModels = QueryUtils.extractEarthquakes();
       /* dataModels.add(new Earthquake(7.2,"nag", 5255224));
        dataModels.add(new Earthquake(5.5,"pune",  454645));
        dataModels.add(new Earthquake(9.5,"mum",  4578544));
        dataModels.add(new Earthquake(7.7,"bang",  45466664));
*/

        EarthquakeAdapter adapter = new EarthquakeAdapter(this,dataModels);

        ListView l = findViewById(R.id.list);
        l.setAdapter(adapter);


    }

}
