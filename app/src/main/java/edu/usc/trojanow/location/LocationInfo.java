package edu.usc.trojanow.location;

import android.location.Location;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class LocationInfo {
    private double longitude;
    private double latitude;
    private String locationName;



    private Location locationObj;

    // constructor for the class
    public LocationInfo(double longitude, double latitude,Location locationObj) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationName = "";
        this.locationObj = locationObj;
    }

    public LocationInfo(){
        this.longitude = -1;
        this.latitude = -1;
        this.locationName = "";
        this.locationObj = null;

    }

    public String toString(){
        return latitude+"|"+ longitude;
    }

    //this method returns the name of the location as a String
    // Similar to this format "Los Angeles, CA"
    public String getLocationString(float longitude, float latitude){
        return locationName;
    }

    // This method returns the distance in meters between this location and location loc
    // it is useful when we want to show thoughts that are within specific radius
    public float getDistance(LocationInfo loc){
        return locationObj.distanceTo(loc.getLocationObj());
    }

    //getter for longitude
    public double getLongitude() {
        return longitude;
    }

    //setter for longitude
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    //getter for latitude
    public double getLatitude() {
        return latitude;
    }

    //setter for latitude
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Location getLocationObj() {
        return locationObj;
    }
}
