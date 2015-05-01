package edu.usc.trojanow.thought;

import android.content.Context;
import android.location.Location;
import android.location.LocationProvider;

import edu.usc.trojanow.location.FallbackLocationTracker;
import edu.usc.trojanow.location.LocationHelper;
import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.location.ProviderLocationTracker;
import edu.usc.trojanow.sensor.SensorHelper;
import edu.usc.trojanow.sensor.TemperatureInfo;
import edu.usc.trojanow.serverconnector.ServerConnector;
import edu.usc.trojanow.user.Email;
import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class Thought {

    private String text;
    private LocationInfo location;
    private TemperatureInfo temperature;
    private User createdBy;


    private boolean isAnonymous;

    public Thought(String text, LocationInfo location, TemperatureInfo temperature, User createdBy) {
        this.text = text;
        this.location = location;
        this.temperature = temperature;
        this.createdBy = createdBy;
    }

    // create a thought with current location
    public Thought(String text, String username, boolean isAnonymous , boolean includeTemperature, Context context) {
        //prepare sensors
        SensorHelper sh = new SensorHelper(context);
        sh.start();
        FallbackLocationTracker locationTracker = new FallbackLocationTracker(context, ProviderLocationTracker.ProviderType.GPS);
        locationTracker.start();

        this.isAnonymous = isAnonymous;

        //set location
        if(locationTracker.hasLocation()) {
            Location loc = locationTracker.getLocation();
            this.location = new LocationInfo(loc.getLongitude(), loc.getLatitude(), loc);
        }
        else if(locationTracker.hasPossiblyStaleLocation()){
            Location loc = locationTracker.getPossiblyStaleLocation();
            this.location = new LocationInfo(loc.getLongitude(), loc.getLatitude(), loc);
        }
        else { //just assign dummy location in case no location is found (for testing)
            this.location = new LocationInfo(-122.084099, 37.422099, new Location(""));
        }
        locationTracker.stop();

        //set text
        this.text = text;

        //TODO: change this to get the userinfo from the Database
        User user = isAnonymous? null:
                new User(username,username,username,new Email(username,username));

        //setUser
        this.createdBy = user;
        if(includeTemperature) {
            this.temperature = sh.getCurrentTemperatureFromAPI();
        }
        else
            this.temperature = null;

        sh.stop();

    }

    public TemperatureInfo getTemperature(){
        return temperature;
    }



    public void postToServer(){
        //TODO: call server and post this thought
        ServerConnector connector=new ServerConnector();
        connector.postThought(this);
        System.out.println("Class Thought says Thought is posted to the server !!");
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    // Getter for Thought text
    public String getText() {
        return text;
    }

    // Getter for Thought Location
    public LocationInfo getLocation() {
        return location;
    }

    // Getter for Thought Creator
    public User getCreatedBy() {
        return createdBy;
    }
}
