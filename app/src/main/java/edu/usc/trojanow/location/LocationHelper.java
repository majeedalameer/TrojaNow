package edu.usc.trojanow.location;

import android.location.Location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class LocationHelper {

    public static GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(null)
            .addConnectionCallbacks(null) // this and above,below lines changed from this to null
            .addOnConnectionFailedListener(null)  // TODO: make sure it is ok
            .addApi(LocationServices.API)
            .build();

    //This static method returns the current location of the Android device
    //It calls the Android API to get the current location and returns it in
    // LocationInfo Object
    public static LocationInfo getCurrentLocationFromAPI() {

        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            LocationInfo locationinfo = new LocationInfo(mLastLocation.getLongitude(), mLastLocation.getLatitude(),mLastLocation);
        }

        return new LocationInfo(0, 0,null);
    }

    public static String getPlaceName(double longitude, double latitude) {

        //TODO: fill method skeleton
        return "";

    }
}