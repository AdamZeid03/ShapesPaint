package com.example.shapespaint;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This public class is for creating a new EventHandler
 * for object MyCircle that gives it an ability to be
 * moved around the screen, resized and to be rotated
 * using mouse.
 *
 * @author Adam Zeid
 */
public class MyCircleEventHandler implements EventHandler <MouseEvent>
{
    private static MyCircle circle;
    private static double x;
    private static double y;

    /**
     * This private void method is checking if
     * MyCircle was hit and if it was it gives it
     * an ability to be moved around the screen.
     *
     * @param event witch is set after right MouseEvent was used.
     */
    private void doMove(final MouseEvent event)
    {
        final double dx = event.getX() - x;
        final double dy = event.getY() - y;

        //check if circle was hit
        if(circle.isHit(x, y))
        {
            circle.addX(dx);
            circle.addY(dy);
        }
        x += dx;
        y += dy;
    }

    /**
     * This public overridden void method is for setting new type of event handling.
     * It gives MyCircle an ability to move, change color and be rotated using mouse.
     *
     * @param event witch is set after right MouseEvent was used.
     */
    @Override
    public void handle(final MouseEvent event)
    {
        circle = (MyCircle) event.getSource();

        //set points/set as active
        if(event.getEventType() == MouseEvent.MOUSE_PRESSED && event.getButton() == MouseButton.PRIMARY)
        {
            x = event.getX();
            y = event.getY();
        }

        //move
        if(event.getEventType() == MouseEvent.MOUSE_DRAGGED && event.getButton() == MouseButton.PRIMARY)
        {
            doMove(event);
        }

        //change color
        if(event.getEventType() == MouseEvent.MOUSE_PRESSED && event.getButton() == MouseButton.SECONDARY)
        {
            final Stage colorPickerStage = new Stage();
            final MyColorPicker cpFill = new MyColorPicker(Color.TRANSPARENT);
            final Scene window = new Scene(cpFill);
            colorPickerStage.setScene(window);
            colorPickerStage.setTitle("Color Picker");
            colorPickerStage.setHeight(140);
            colorPickerStage.setWidth(240);
            colorPickerStage.setResizable(false);
            colorPickerStage.showAndWait();

            circle.setFill(cpFill.getValue());
        }

        //rotate
        if(event.getEventType() == MouseEvent.MOUSE_PRESSED && event.getButton() == MouseButton.MIDDLE) {
            final Scene scene = circle.getScene();
            scene.setOnKeyPressed
                    (e ->
                    {
                        switch (e.getCode())
                        {
                            case D -> circle.toRotate(1);

                            case A -> circle.toRotate(-1);

                            default -> circle.toRotate(0);
                        }
                    });
        }
    }
}
