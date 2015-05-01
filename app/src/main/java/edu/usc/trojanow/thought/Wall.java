package edu.usc.trojanow.thought;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.usc.trojanow.R;
import edu.usc.trojanow.location.FallbackLocationTracker;
import edu.usc.trojanow.location.LocationHelper;
import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.location.ProviderLocationTracker;
import edu.usc.trojanow.sensor.TemperatureInfo;
import edu.usc.trojanow.serverconnector.ServerConnector;
import edu.usc.trojanow.user.Email;
import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class Wall {

    private ArrayList<Thought> thoughts;
    private LocationInfo location;
    private float range;


    // constructor that create the wall by calling the server
    // and retrieve Thoughts that are within specific range
    public Wall(float range, Context mContext) {

        this.location = new FallbackLocationTracker(mContext, ProviderLocationTracker.ProviderType.GPS).getAnyLocation();

        this.range = range;
        thoughts = getThoughtsFromServer(location,range);
    }

    public Wall() {

    }

    // Getter for Thought array
    public ArrayList<Thought> getThoughts() {
        return thoughts;
    }

    // Getter for locationInfo
    public LocationInfo getLocation() {
        return location;
    }

    // Getter for Range
    public float getRange() {
        return range;
    }

    //this methods calls the server and retrieve the thoughts that are within
    //a specific range of a location;
    public ArrayList<Thought> getThoughtsFromServer(LocationInfo location, float range){

        ServerConnector connector=new ServerConnector();
        ArrayList<Thought> allThoughts = connector.getThoughts();
        ArrayList<Thought> filteredThoughts = new ArrayList<Thought>();

        for (Thought thought: allThoughts) {
            if(thought.getLocation().getDistance(location) <= range)
                filteredThoughts.add(thought);
        }
        return filteredThoughts;

    }



}
