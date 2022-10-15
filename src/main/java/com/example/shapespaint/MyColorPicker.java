package com.example.shapespaint;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * This public class named MyColorPicker is for
 * creating and stylizing custom JavaFx ColorPicker.
 *
 * @author Adam Zeid
 */
public class MyColorPicker extends ColorPicker
{
    /**
     * This public method is a constructor of class MyColorPicker.
     * It sets useful parameters to simple JavaFX ColorPicker.
     *
     * @param color witch is the color that will be primly set
     *              on MyColorPicker
     */
    public MyColorPicker(final Color color)
    {
        super(color);
        setMinWidth(300);
        setMinHeight(50);
    }
}
