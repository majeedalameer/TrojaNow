package edu.usc.trojanow.messages;

import java.util.ArrayList;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class Inbox {
    private ArrayList<DirectMessage> directMessages;

    private Inbox( ArrayList<DirectMessage> directMessages ){
        this.directMessages = directMessages;
    }

    // getter for direct messages
    public ArrayList<DirectMessage> getDirectMessages() {
        return directMessages;
    }


}
