package edu.usc.trojanow.user;

/**
 * Created by abdulmajeed on 3/24/15.
 */
public class Email {
    private String emailID;
    private String domain;

    public Email(String emailID, String domain) {
        this.emailID = emailID;
        this.domain = domain;
    }

    // this method return the email address in this format:
    // "emailID@domain.com"
    public String getEmail(){
        return emailID + "@" + domain;
    }

}
