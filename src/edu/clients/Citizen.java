package edu.clients;

import edu.communications.Emailable;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class Citizen implements Emailable{
    FullName fullName;

    public String getFullName() {
        return fullName.toString();
    }
}
