package edu.usc.trojanow.thought;

import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.sensor.TemperatureInfo;
import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class Thought {

    private String text;
    private LocationInfo location;
    private TemperatureInfo temperature;
    private User createdBy;

    public Thought(String text, LocationInfo location, TemperatureInfo temperature, User createdBy) {
        this.text = text;
        this.location = location;
        this.temperature = temperature;
        this.createdBy = createdBy;
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
