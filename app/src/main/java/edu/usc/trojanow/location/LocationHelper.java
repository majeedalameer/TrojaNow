package edu.usc.trojanow.location;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class LocationHelper{

    Context mContext;
    public LocationHelper(Context cont){
        mContext = cont;
    }

    //This static method returns the current location of the Android device
    //It calls the Android API to get the current location and returns it in
    // LocationInfo Object

    public LocationInfo getCurrentLocationFromAPI() {

        LocationInfo locationinfo;
        LocationManager locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);


        // TRY GPS first if not working try network provider
        Location mLastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(mLastLocation == null) {
            mLastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        if (mLastLocation == null) {
            locationinfo = new LocationInfo(-1, -1, null);
        }
        else
            locationinfo = new LocationInfo(mLastLocation.getLongitude(), mLastLocation.getLatitude(),mLastLocation);


        return locationinfo;
    }

    public String getPlaceName(double longitude, double latitude) {

        //TODO: fill method skeleton
        return "unknown place";

    }
}