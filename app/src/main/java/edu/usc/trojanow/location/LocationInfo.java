package edu.usc.trojanow.location;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class LocationInfo {
    private float longitude;
    private float latitude;
    private String locationName;


    // constructor for the class
    public LocationInfo(float longitude, float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationName = getLocationString(this.longitude,this.latitude);
    }

    //this method returns the name of the location as a String
    // Similar to this format "Los Angeles, CA"
    public String getLocationString(float longitude, float latitude){
        //TODO: fill method skeleton
        return null;
    }

    // This method returns the distance between this location and location loc
    // it is useful when we want to show thoughts that are within specific radius
    public int getDistance(LocationInfo loc){
        //TODO: fill method skeleton
        return 0;
    }

    //getter for longitude
    public float getLongitude() {
        return longitude;
    }

    //setter for longitude
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    //getter for latitude
    public float getLatitude() {
        return latitude;
    }

    //setter for latitude
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
