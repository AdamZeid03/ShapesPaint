package com.example.shapespaint;

import javafx.scene.control.Slider;

/**
 * This public class named MySliders is for
 * creating and stylizing custom JavaFx Sliders.
 *
 * @author Adam Zeid
 */
public class MySlider extends Slider
{
    /**
     * This public method is a constructor of class MySliders.
     * It sets useful parameters to simple JavaFX Slider.
     *
     * @param v it's a start value that will appear on MySlider
     * @param v1 it's a middle value that will appear on MySlider
     * @param v2 it's an end value that will appear on MySlider
     */
    public MySlider(final double v, final double v1, final double v2)
    {
        super(v, v1, v2);
        setShowTickMarks(true);
        setShowTickLabels(true);
    }
}
