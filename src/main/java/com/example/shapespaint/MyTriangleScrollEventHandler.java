package com.example.shapespaint;

import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

/**
 * This public class is for creating a new EventHandler for
 * object MyTriangle that gives it an ability to be resized using mouse scroll.
 *
 * @author Adam Zeid
 */
public class MyTriangleScrollEventHandler  implements EventHandler <ScrollEvent>
{
    private static MyTriangle triangle;

    /**
     * This public void type method is checking if MyRectangle
     * was hit and if it was it gives it an ability to be resized on screen.
     *
     * @param scrollEvent witch is set after right MouseEvent was used.
     */
    private void doScale(final ScrollEvent scrollEvent)
    {
        final double x = scrollEvent.getX();
        final double y = scrollEvent.getY();

        if(triangle.isHit(x, y))
        {
            triangle.toResizeX(scrollEvent.getDeltaY() * 0.0005);
            triangle.toResizeY(scrollEvent.getDeltaY() * 0.0005);
        }
    }

    /**
     * This overridden public void type method is
     * for setting new type of event handling.
     * It gives an ability to resize MyRectangle using mouse scroll.
     *
     * @param scrollEvent witch is set after right MouseEvent was used.
     */
    @Override
    public void handle(final ScrollEvent scrollEvent)
    {
        triangle = (MyTriangle) scrollEvent.getSource();
        if(scrollEvent.getEventType() == ScrollEvent.SCROLL)
        {
            doScale(scrollEvent);
        }
    }
}
