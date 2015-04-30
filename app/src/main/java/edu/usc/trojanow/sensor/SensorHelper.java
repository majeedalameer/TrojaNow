package edu.usc.trojanow.sensor;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.Date;
import java.util.Random;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class SensorHelper implements SensorEventListener{


    //This static method returns the current temperature
    //It calls the Android API to get the current location and returns it in
    // LocationInfo Object
    Context mContext;
    SensorManager mSensorManager;
    Sensor mTemprature;
    float lastTempReading = 0;
    boolean changed = false;

    public SensorHelper(Context contx){
        mContext = contx;
        mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        mTemprature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    public TemperatureInfo getCurrentTemperatureFromAPI(){

        //TODO: remove this when testing on real phone
        if(!changed)  //this line gives random temperature if no reading is received from the device
            lastTempReading = new Random().nextFloat() * (50 - 20) + 20;

        TemperatureInfo tempInfo = new TemperatureInfo(lastTempReading,'C',new Date());
        return tempInfo;
    }

    //starts the sensor
    public void start(){
        mSensorManager.registerListener(this, mTemprature, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //stops the sensor
    public void stop(){
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        changed = true;
        lastTempReading = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
