package com.example.android.quakereport;

/**
 * Class to create Earthquake objects
 */

public class Earthquake {

    // fields that describe an earthquake
    private String mMagnitude;
    private String mLocation;
    private String mDate;

    public Earthquake(String mag, String loc, String date){
        mMagnitude=mag;
        mLocation=loc;
        mDate=date;
    }

    //getter methods for each field
    public String getMagnitude(){
        return mMagnitude;
    }
    public String getLocation(){
        return mLocation;
    }
    public String getDate(){
        return mDate;
    }

    //assuming we won't set any values, we don't provide setter methods
}
