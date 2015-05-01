package edu.usc.trojanow.serverconnector;

import android.os.StrictMode;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.messages.DirectMessage;
import edu.usc.trojanow.thought.Thought;
import edu.usc.trojanow.thought.Wall;
import edu.usc.trojanow.user.Email;
import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class ServerConnector {
    private String connectionString="http://10.120.88.88/trojanNow/";

    //this method posts a new thought to the server
    public void postThought(Thought thought){

        InputStream is = null;
        // http post
        ArrayList<NameValuePair> nameValuePairs=JSONAnalyzer.composeJson(thought);

        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(connectionString+"thought.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
/*
            obj.put("text","debugging response");//thought.getText());
            obj.put("user","sadeem");//thought.getCreatedBy().getFirstName());
            obj.put("anony","true");
            obj.put("long","12212");//thought.getLocation().getLongitude());
            obj.put("lat","1111");//thought.getLocation().getLatitude());
            obj.put("temp","11");//thought.getTemperature().getTemperatureDegree());

            HttpPost httpPost = new HttpPost("http://10.123.35.109/trojanNow/connect.php/");
            httpPost.setEntity(new StringEntity(obj.toString()));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            new DefaultHttpClient().execute(httpPost);
*/
        }catch(Exception e){
            System.out.println("log_tag Error in http connection" + e.toString());
        }       // return false;
    }

    // This methods sends a directs message information to the server
    public void sendDirectMessage(DirectMessage directMessage){
        //TODO: fill in method skeleton
        ArrayList<NameValuePair> nameValuePairs=JSONAnalyzer.composeJsonMsg(directMessage);

        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(connectionString+"message.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
        }catch(Exception e){
            System.out.println("log_tag Error in http connection" + e.toString());
        }  }

        //This method calls the server to retrieve a JSON string that represents
        //the thoughts that are within specific range
    public ArrayList<Thought> getThoughts(){
        StringBuffer sb=null;
        try
        {

            HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet();
        request.setURI(new URI(connectionString+"thought.php?thoughts=all"));
        HttpResponse response = client.execute(request);
        BufferedReader in = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));

         sb = new StringBuffer("");
        String line="";
        while ((line = in.readLine()) != null) {
            sb.append(line);
            break;
        }
            in.close();
            System.out.println("from localhost: "+sb.toString());
                  return JSONAnalyzer.AnalyzeJson(sb.toString());

        }catch(Exception e){
        System.out.println("Exception: " + e.getMessage());
    }return null;
    }

    //This method calls the server to retrieve a JSON string that represents
    //the inbox of a specific user

    public ArrayList<DirectMessage> getMessages(User user){
        StringBuffer sb=null;
        try
        {

            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(connectionString+"message.php?message="+user.getUserName()));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader
                    (new InputStreamReader(response.getEntity().getContent()));

            sb = new StringBuffer("");
            String line="";
            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
            in.close();
            System.out.println("from localhost: "+sb.toString());
            return JSONAnalyzer.AnalyzeJsonMsg(sb.toString());

        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }return null;
    }

    //this methods connects to the server to login and create a session
    // for the user
    // it returns either "failed" or sessionID
    public User logIn(String username){
        StringBuffer sb=null;
        try
        {

            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(connectionString+"user.php?username="+username));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader
                    (new InputStreamReader(response.getEntity().getContent()));

            sb = new StringBuffer("");
            String line="";
            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
            in.close();
            System.out.println("from localhost: "+sb.toString());
            return JSONAnalyzer.AnalyzeJsonUser(sb.toString());

        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }return null;
    }

    //this methods connects to the server to signup and create a new user
    // it returns either "failed" or sessionID
    public String signUp(String firstName, String lastName,String username, String passwd , Email email){
        //TODO: fill in method skeleton
        return "";
    }

}
