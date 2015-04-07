package edu.usc.trojanow.messages;

import java.util.Date;

import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class DirectMessage {
    private User sender;
    private User receiver;
    private String messageText;
    private Date messageTime;

    public DirectMessage(User sender, User receiver, String messageText, Date messageTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageText = messageText;
        this.messageTime = messageTime;
    }


    // Getters for Direct Message attributes
    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getMessageText() {
        return messageText;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    // Setters for Direct Message
    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }
}
