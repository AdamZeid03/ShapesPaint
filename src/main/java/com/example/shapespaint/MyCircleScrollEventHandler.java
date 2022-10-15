package com.example.shapespaint;

import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

/**
 * This public class is for creating a new EventHandler for
 * object MyCircle that gives it an ability to be resized using mouse scroll.
 *
 * @author Adam Zeid
 */
public class MyCircleScrollEventHandler implements EventHandler<ScrollEvent>
{
    private static MyCircle circle;

    /**
     * This private void type method is checking if MyCircle object
     * was hit and if it was it gives it an ability to be resized on screen.
     *
     * @param scrollEvent witch is set after right MouseEvent was used.
     */
    private void doScale(final ScrollEvent scrollEvent)
    {
        final double x = scrollEvent.getX();
        final double y = scrollEvent.getY();

        //check if the circle was hit
        if(circle.isHit(x, y))
        {
            circle.addRadius(scrollEvent.getDeltaY()*0.2);
        }
    }

    /**
     * This overridden public void type method is
     * for setting new type of event handling.
     * It gives an ability to resize MyCircle using
     * mouse scroll.
     *
     * @param scrollEvent witch is set after right MouseEvent was used.
     */
    @Override
    public void handle(final ScrollEvent scrollEvent)
    {
        circle = (MyCircle) scrollEvent.getSource();

        //resize
        if(scrollEvent.getEventType() == ScrollEvent.SCROLL)
        {
            doScale(scrollEvent);
        }
    }
}
