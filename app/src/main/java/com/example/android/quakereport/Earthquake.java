package com.example.android.quakereport;

/**
 * Class to create Earthquake objects
 */

public class Earthquake {

    // fields that describe an earthquake
    private String mMagnitude;
    private String mLocation;
    private long mTime;

    public Earthquake(String mag, String loc, long time){
        mMagnitude=mag;
        mLocation=loc;
        mTime = time;
    }

    //getter methods for each field
    public String getMagnitude(){
        return mMagnitude;
    }
    public String getLocation(){
        return mLocation;
    }
    public long getTime(){
        return mTime;
    }

    //assuming we won't set any values, we don't provide setter methods
}
