package edu.clients;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class FullName {
    String name;
    String secondName;
    String surname;

    toString() {
        return (surname + " " + name + " " + secondName);
    }
}
