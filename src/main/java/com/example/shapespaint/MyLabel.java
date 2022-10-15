package com.example.shapespaint;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * This public class named MyLabels is for
 * creating and stylizing custom JavaFX Labels.
 *
 * @author Adam Zeid
 */
public class MyLabel extends Label
{
    /**
     * This public method is a constructor of class MyLabels.
     * It sets useful parameters to simple JavaFX Label.
     *
     * @param text is the text that MyLabel will show.
     */
    public MyLabel(final String text)
    {
        super(text);
        setFont(new Font("Verdana",30));
        setTextFill(Color.web("#ffffff"));
    }
}
