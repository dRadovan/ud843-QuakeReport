package com.example.android.quakereport;

/**
 * Class to create Earthquake objects
 */

public class Earthquake {

    // fields that describe an earthquake
    private double mMagnitude;
    private String mLocation;
    private long mTime;
    private String mURL;

    public Earthquake(double mag, String loc, long time, String url){
        mMagnitude=mag;
        mLocation=loc;
        mTime = time;
        mURL = url;
    }

    //getter methods for each field
    public double getMagnitude(){
        return mMagnitude;
    }
    public String getLocation(){
        return mLocation;
    }
    public long getTime(){
        return mTime;
    }
    public String getURL(){return mURL;}

    //assuming we won't set any values, we don't provide setter methods
}
