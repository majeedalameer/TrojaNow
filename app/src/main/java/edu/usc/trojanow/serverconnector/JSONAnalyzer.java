package edu.usc.trojanow.serverconnector;

import android.location.Location;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.messages.DirectMessage;
import edu.usc.trojanow.sensor.TemperatureInfo;
import edu.usc.trojanow.thought.Thought;
import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class JSONAnalyzer {


    public static User AnalyzeJsonUser(String json){
User user=null;
        try {
            JSONArray object = new JSONArray(json);
            String username,firstName,lastName;
            for(int i=0;i<object.length();i++)
            {
                JSONObject obj = object.getJSONObject(i);
                username=obj.getString("username");
                firstName=obj.getString("name");
                lastName=obj.getString("name");
                user=new User(username,firstName,lastName,null);
            }
        }
        catch (JSONException e)
        {
            System.out.println(e.getMessage());
        }
        return user;
    }

    // this method analyze a JSON string and return the corresponding object
    public static ArrayList<Thought> AnalyzeJson(String json){
        ArrayList<Thought> arrayList = new ArrayList<>();
        try {
            JSONArray object = new JSONArray(json);
            Thought thought=null;
            String text;
            char emptyChar='\0';
            double longit,lat;
            LocationInfo location;
            String temp;
            TemperatureInfo temprature=null;
            User user= new User("Anonymous","Anonymous","Anonymous",null);
            for(int i=0;i<object.length();i++)
            {
                JSONObject obj = object.getJSONObject(i);
                text=obj.getString("text");
                Location lo=new Location("");
                longit=Double.parseDouble(obj.getString("long"));
                lat=Double.parseDouble(obj.getString("lat"));
                lo.setLatitude(lat);
                lo.setLongitude(longit);
                location =new LocationInfo(longit,lat,lo);
                temp=obj.getString("temp");
                if(!temp.equals("null"))
                    temprature=new TemperatureInfo(Float.parseFloat(temp),emptyChar,null);
                else
                    temprature=null;
                if(!obj.getString("anony").equalsIgnoreCase("true"))
                    user=new User(obj.getString("user"),obj.getString("user"),obj.getString("user"),null);
                else
                     user= new User("Anonymous","Anonymous","Anonymous",null);
                thought=new Thought(text,location,temprature,user);
                arrayList.add(thought);
            }
        }
        catch (JSONException e)
        {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }



    public static ArrayList<DirectMessage> AnalyzeJsonMsg(String json){
        ArrayList<DirectMessage> arrayList = new ArrayList<>();
        try {
            JSONArray object = new JSONArray(json);
            DirectMessage msg=null;
            String text;
            User sender,reciever;
            for(int i=0;i<object.length();i++)
            {
                JSONObject obj = object.getJSONObject(i);
                text=obj.getString("text");
                //date=obj.getString("date");
                sender=new User(obj.getString("sender"),obj.getString("sender"),obj.getString("sender"),null);
                reciever=new User(obj.getString("reciever"),obj.getString("reciever"),obj.getString("reciever"),null);
                msg=new DirectMessage(sender,reciever,text,null);
                arrayList.add(msg);
            }
        }
        catch (JSONException e)
        {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }


    public static ArrayList<NameValuePair> composeJsonLogin(String username)
    {

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("username",username));
        return nameValuePairs;
    }


public static ArrayList<NameValuePair> composeJson(Thought thought)
{
String temp="null";
    if(thought.getTemperature()!=null)
        temp=thought.getTemperature().getTemperatureDegree()+"";
    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("user",thought.getCreatedBy().getUserName()));
    nameValuePairs.add(new BasicNameValuePair("text",thought.getText()));
    nameValuePairs.add(new BasicNameValuePair("anony",thought.isAnonymous()+""));
    nameValuePairs.add(new BasicNameValuePair("temp",temp));
    nameValuePairs.add(new BasicNameValuePair("long",thought.getLocation().getLongitude()+""));
    nameValuePairs.add(new BasicNameValuePair("lat",thought.getLocation().getLatitude()+""));
    return nameValuePairs;
}
    public static ArrayList<NameValuePair> composeJsonMsg(DirectMessage msg)
    {

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("reciever",msg.getReceiver().getUserName()));
        nameValuePairs.add(new BasicNameValuePair("sender",msg.getSender().getUserName()));
        nameValuePairs.add(new BasicNameValuePair("text",msg.getMessageText()));
        nameValuePairs.add(new BasicNameValuePair("date","12/12/12"));
        return nameValuePairs;
    }
}
