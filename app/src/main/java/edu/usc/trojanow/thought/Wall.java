package edu.usc.trojanow.thought;

import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import edu.usc.trojanow.R;
import edu.usc.trojanow.location.LocationHelper;
import edu.usc.trojanow.location.LocationInfo;

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
        //TODO: update method to call server and get the thoughts instead of the empty arraylist

        ArrayList<Thought> allThoughts = new ArrayList<Thought>();
        ArrayList<Thought> filteredThoughts = null;

        for (Thought thought: allThoughts) {
            if(thought.getLocation().getDistance(location) <= range)
                filteredThoughts.add(thought);
        }

        return filteredThoughts;
    }



}
