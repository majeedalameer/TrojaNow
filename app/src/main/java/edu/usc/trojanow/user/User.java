package edu.usc.trojanow.user;


/**
 * Created by abdulmajeed on 3/24/15.
 */
public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private Email email;

    public User(String userName, String firstName, String lastName, Email email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String userName){
        //TODO: change this to call server to get user info;
        this.userName = userName;
        this.firstName = userName;
        this.lastName = userName;
        this.email = new Email(userName,userName);
    }

    /**
     * Methods removed to make this component independent from others
     *
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
    */


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
