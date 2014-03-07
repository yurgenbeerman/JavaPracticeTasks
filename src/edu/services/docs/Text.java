package edu.services.docs;

/**
 * Created by yurii.pyvovarenko on 05.03.14.
 */
public abstract class Text {
    String text;
    boolean isFinalized = false;

    public abstract String getText();

    public abstract void setText(String text);
}
