package com.example.shapespaint;

import javafx.scene.shape.Circle;

/**
 * This public class is for creating a new
 * type shape object MyCircle witch can
 * be moved or resized on pane.
 *
 * @author Adam Zeid
 */
public class MyCircle extends Circle
{
    /**
     * This public method is a constructor
     * of class MyCircle witch extends class Circle.
     *
     * @param x x coordinate of circle center.
     * @param y y coordinate of circle center.
     * @param radius double value witch is a radius of circle.
     */
    public MyCircle(final double x, final double y, final double radius)
    {
        super(x, y, radius);
        setOnMousePressed(new MyCircleEventHandler());
        setOnMouseDragged(new MyCircleEventHandler());
        setOnScroll(new MyCircleScrollEventHandler());
    }

    /**
     * This public method is for checking if
     * the object MyCircle was or wasn't hit.
     *
     * @param x x coordinate taken from pane.
     * @param y y coordinate taken from pane.
     * @return boolean type witch returns false
     * if object wasn't hit or true if object was hit.
     */
    public boolean isHit(final double x, final double y)
    {
        return getBoundsInLocal().contains(x, y);
    }

    /**
     * This public void type method is for adding
     * and setting new x value to the old one as
     * long as it is needed in order to move
     * x coordinate of center of Circle.
     *
     * @param x witch is an x coordinate taken from pane.
     */
    public void addX(final double x)
    {
        setCenterX(getCenterX() + x);
    }

    /**
     * This public void type method is for adding and setting new y
     * value to the old one as long as it is needed in order to move
     * y coordinate of center of Circle.
     *
     * @param y y coordinate taken from pane.
     */
    public void addY(final double y)
    {
        setCenterY(getCenterY() + y);
    }

    /**
     * This public void type method is for adding and
     * setting new radius value to the old one as long
     * as it is needed in order to resize Circle.
     *
     * @param radius value witch extends when right event was used.
     */
    public void addRadius(final double radius)
    {
        setRadius(getRadius() + radius);
    }

    /**
     * This public void type method is for adding and
     * setting new Rotate value to the old one as long
     * as it is needed in order to rotate Circle.
     *
     * @param rotator value witch is set after right event was used.
     */
    public void toRotate(final double rotator)
    {
        setRotate(getRotate() + rotator);
    }
}
