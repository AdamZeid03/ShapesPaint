package com.example.shapespaint;

import javafx.scene.shape.Rectangle;

/**
 * This public class is for creating a new type shape
 * object MyRectangle witch can be moved or resized on pane.
 *
 * @author Adam Zeid
 */
public class MyRectangle extends Rectangle
{
    private static double startX;
    private static double startY;

    /**
     * This public method is a constructor of class
     * MyRectangle witch extends class Rectangle.
     *
     * @param x is an x coordinate of first node of Rectangle.
     * @param y is a y coordinate of first node of Rectangle.
     * @param height is a height of Rectangle.
     * @param width is a width of Rectangle.
     */
    public MyRectangle(final double x, final double y, final double width, final double height)
    {
        super(x, y, width, height);
        setOnMousePressed(new MyRectangleEventHandler());
        setOnMouseDragged(new MyRectangleEventHandler());
        setOnScroll(new MyRectangleScrollHandler());
    }

    /**
     * This public method is for checking if the object MyRectangle was or wasn't hit.
     *
     * @param x double value witch is an x coordinate taken from pane.
     * @param y double value witch is a y coordinate taken from pane.
     * @return getBoundsInLocal().contains(x, y) witch is boolean type witch
     * returns false if object wasn't hit or true if object was hit.
     */
    public boolean isHit(final double x, final double y)
    {
        return getBoundsInLocal().contains(x, y);
    }

    /**
     * This public void method is for setting value StartX
     * and StartY witch are coordinates of point from where
     * shape will be moved.
     *
     * @param x is an x coordinate taken from pane minus TranslateX.
     * @param y is a y coordinate taken from pane minus TranslateY.
     */
    public void setStart(final double x, final double y)
    {
        startX = x;
        startY = y;
    }

    /**
     * This public method is a getter that returns
     * previously set StartX.
     *
     * @return StartX is an x coordinate of a point
     * from where moving was started.
     */
    public double getStartX()
    {
        return startX;
    }

    /**
     * This public method is a getter that returns
     * previously set StartY.
     *
     * @return StartX witch is a y coordinate of a point
     * from where moving is started.
     */
    public double getStartY()
    {
        return startY;
    }

    /**
     * This void type method is for adding and setting
     * new width value to the old one as long as it is needed.
     *
     * @param width is value witch extends when right event was used.
     */
    public void addWidth(final double width)
    {
        setWidth(getWidth() + width);
    }

    /**
     * This void type method is for adding and setting
     * new height value to the old one as long as it is needed
     *
     * @param height is value witch extends when right event was used.
     */
    public void addHeight(final double height)
    {
        setHeight(getHeight() + height);
    }

    /**
     * This public void type method is for adding and setting
     * new Rotate value to the old one as long as it
     * is needed in order to rotate Rectangle.
     *
     * @param rotator double value witch is set after right event was used.
     */
    public void toRotate(final double rotator)
    {
        setRotate(getRotate() + rotator);
    }
}
