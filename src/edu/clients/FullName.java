package edu.clients;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class FullName {
    String name;
    String secondName;
    String surname;

    public FullName(String surname, String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
    }

    public String toString() {
        return (surname + " " + name + " " + secondName);
    }
}
