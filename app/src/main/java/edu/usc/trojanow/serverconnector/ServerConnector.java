package edu.usc.trojanow.serverconnector;

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
    private String connectionString;

    //this method posts a new thought to the server
    public boolean postThought(Thought thought){
        //TODO: fill in method skeleton
        return false;
    }

    // This methods sends a directs message information to the server
    public boolean sendDirectMessage(DirectMessage directMessage){
        //TODO: fill in method skeleton
        return false;
    }

        //This method calls the server to retrieve a JSON string that represents
        //the thoughts that are within specific range
    public String getThoughts(LocationInfo location, float range){
        //TODO: fill in method skeleton
        return "";
    }

    //This method calls the server to retrieve a JSON string that represents
    //the inbox of a specific user

    public String getMessages(User user){
        //TODO: fill in method skeleton
        return "";
    }

    //this methods connects to the server to login and create a session
    // for the user
    // it returns either "failed" or sessionID
    public String logIn(String username, String passwd){
        //TODO: fill in method skeleton
        return "";
    }

    //this methods connects to the server to signup and create a new user
    // it returns either "failed" or sessionID
    public String signUp(String firstName, String lastName,String username, String passwd , Email email){
        //TODO: fill in method skeleton
        return "";
    }

}
