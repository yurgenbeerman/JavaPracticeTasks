package edu.communications;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public interface Emailable {
    String emailAddress;

    String getEmailAddress() {
        return emailAddress;
    }

    void setEmailAddress(String emailAddress) {
        Emailable.emailAddress = emailAddress;
    }
}
