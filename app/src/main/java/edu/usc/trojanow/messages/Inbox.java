package edu.usc.trojanow.messages;

import java.util.ArrayList;
import java.util.Date;

import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.sensor.TemperatureInfo;
import edu.usc.trojanow.thought.Thought;
import edu.usc.trojanow.user.Email;
import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class Inbox {
    private ArrayList<DirectMessage> directMessages;
    private User inboxOwner;

    //Constructor
    public Inbox( ArrayList<DirectMessage> directMessages , User user ){
        this.directMessages = directMessages;
        this.inboxOwner = user;
    }

    //Constructor
    public Inbox(User user){
        this.inboxOwner = user;
        this.directMessages = getMessagesFromServer(user);
    }

    public Inbox(String userName) {
        this.inboxOwner = new User(userName);
        this.directMessages = getMessagesFromServer(inboxOwner);
    }

    // getter for direct messages
    public ArrayList<DirectMessage> getDirectMessages() {
        return directMessages;
    }

    //this methods calls the server and retrieve the thoughts that are within
    //a specific range of a location;
    private ArrayList<DirectMessage> getMessagesFromServer(User user){
        //TODO: update method to call server and get the messages instead of the dummy Arraylist
        ArrayList<DirectMessage> allMessages = new ArrayList<DirectMessage>();

        // TODO: delete this after fixing the code
        allMessages.add(new DirectMessage(new User("user12","Mark","Alice",new Email("Mark","google.com")),new User("user4","Tony","Malcolm",new Email("Tony","google.com")),"This is a direct message",new Date()));
        allMessages.add(new DirectMessage(new User("MarkAlice","Mark","Alice",new Email("Mark","google.com")),new User("MarkAlice","Mark","Alice",new Email("Mark","google.com")),"This is another message",new Date()));
        return allMessages;
    }



}
