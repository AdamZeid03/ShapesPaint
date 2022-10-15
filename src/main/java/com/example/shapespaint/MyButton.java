package com.example.shapespaint;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * This public class named MyButtons
 * is for creating and stylizing
 * custom JavaFx Buttons.
 *
 * @author Adam Zeid
 */
public class MyButton extends Button
{
    /**
     * Sets useful parameters to simple JavaFX Button.
     *
     * @param name is a text that will appear on the button.
     */
    public MyButton(final String name)
    {
        super(name);
        setMinWidth(300);
        setCursor(Cursor.HAND);
        setTextFill(Color.WHITE);
        setFont(new Font("Verdana",30));
        setStyle("-fx-background-color: #4f006b;");
    }
}
