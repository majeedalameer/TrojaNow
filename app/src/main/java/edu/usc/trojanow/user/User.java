package edu.usc.trojanow.user;

import edu.usc.trojanow.messages.DirectMessage;
import edu.usc.trojanow.messages.Inbox;
import edu.usc.trojanow.thought.Thought;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private Email email;
    private Inbox inbox;

    public User(String userName, String firstName, String lastName, Email email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //this method calls the server and updates the inbox of direct messages
    public void updateInbox(){
        //TODO: update method skeleton

    }

    // this method calls the server to post a thought on behalf of the user
    public void postThought( boolean anonymous , Thought thought){
        //TODO: update method skeleton

    }



    // This methods sends a direct message to another user
    // The message information is enclosed inside the directMessage object
    public void sendDirectMessage(DirectMessage directMessage){
        //TODO: update method skeleton

    }


    // Getters ...
    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }
}
