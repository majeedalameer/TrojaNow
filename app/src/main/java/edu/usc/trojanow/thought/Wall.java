package edu.usc.trojanow.thought;

import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.usc.trojanow.R;
import edu.usc.trojanow.location.LocationHelper;
import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.sensor.TemperatureInfo;
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
    public Wall(LocationInfo location, float range) {
        this.location = location;
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
        //TODO: update method to call server and get the thoughts instead of the empty Arraylist

        ArrayList<Thought> allThoughts = new ArrayList<Thought>();
        ArrayList<Thought> filteredThoughts = null;

        for (Thought thought: allThoughts) {
            if(thought.getLocation().getDistance(location) <= range)
                filteredThoughts.add(thought);
        }

        // TODO: delete this after fixing the code
        ArrayList<Thought> thoughts = new ArrayList<Thought>(4);
        thoughts.add(new Thought("this is a thought",new LocationInfo(123421,43244,null),
                new TemperatureInfo(120.0f,'F',new Date()), new User("user1","John","Doe",new Email("Jong","google.com"))));
        thoughts.add(new Thought("this is a second thought",new LocationInfo(2342345,43554,null),
                new TemperatureInfo(110.0f,'F',new Date()), new User("user12","Mark","Alice",new Email("Mark","google.com"))));

        filteredThoughts = thoughts;
        return filteredThoughts;
    }



}
