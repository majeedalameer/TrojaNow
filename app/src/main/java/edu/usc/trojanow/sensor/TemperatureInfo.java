package edu.usc.trojanow.sensor;

import java.util.Date;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class TemperatureInfo {
    private float temperatureDegree;
    private char temperatureUnit;
    private Date timeOfMeasurement;

    public TemperatureInfo(float temperatureDegree, char temperatureUnit, Date timeOfMeasurement) {
        this.temperatureDegree = temperatureDegree;
        this.temperatureUnit = temperatureUnit;
        this.timeOfMeasurement = timeOfMeasurement;
    }



    // Getters
    public float getTemperatureDegree() {
        return temperatureDegree;
    }

    public char getTemperatureUnit() {
        return temperatureUnit;
    }

    public Date getTimeOfMeasurement() {
        return timeOfMeasurement;
    }
}
