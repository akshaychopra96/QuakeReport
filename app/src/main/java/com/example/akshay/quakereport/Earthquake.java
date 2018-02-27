package com.example.akshay.quakereport;

public class Earthquake {

    private double magnitude;
    private String location;
    private long time;

    Earthquake(double magnitude,String location, long time){
        this.magnitude = magnitude;
        this.location = location;
        this.time = time;
    }


    public double getMagnitude(){
        return magnitude;
    }

    public String getLocation(){
        return location;
    }

    public long getTime(){
        return time;
    }
}
