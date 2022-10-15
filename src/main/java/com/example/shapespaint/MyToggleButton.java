package com.example.shapespaint;

import javafx.scene.Cursor;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Font;

/**
 * This public class named MyToggleButtons is
 * for creating and stylizing custom JavaFx ToggleButtons.
 *
 * @author Adam Zeid
 */
public class MyToggleButton extends ToggleButton
{
    private ToggleGroup tools;
    /**
     * This public method is a constructor of class MyToggleButton.
     * It sets useful parameters to simple JavaFX ToggleButton.
     *
     * @param name is a text that will appear on the button.
     */
    public MyToggleButton(final String name)
    {
        super(name);
        setFont(new Font("Verdana",30));
        setMinWidth(300);
        setMinHeight(70);
        setToggleGroup(tools);
        setCursor(Cursor.HAND);
    }
}
