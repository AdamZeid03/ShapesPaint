package com.example.shapespaint;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


/**
 * This public class named MyDrawings is for creating toolBar and drawingPane.
 * It is also a class where shapes are being put on the Pane.
 *
 * @author Adam Zeid
 */
public class MyDrawings
{
    private final BorderPane drawingPane;
    private final VBox toolBar;
    private transient final MyToggleButton rectangle;
    private transient final MyToggleButton triangle;
    private transient final MyToggleButton circle;
    private transient final MyColorPicker cpLine;
    private transient final MyColorPicker cpFill;
    private transient final MySlider slider;
    private transient final MyLabel lineColor;
    private transient final MyLabel fillColor;
    private transient final MyLabel lineWidth;
    private transient final MyButton clear;
    private static double x1;
    private static double x2;
    private static double y1;
    private static double y2;

    /**
     * This public method is a constructor of class MyDrawings.
     */
    public MyDrawings()
    {
        //pane
        drawingPane = new BorderPane();
        //toolBar
        toolBar = new VBox(10);
        //toggleButtons
        circle = new MyToggleButton("CIRCLE");
        rectangle = new MyToggleButton("RECTANGLE");
        triangle = new MyToggleButton("TRIANGLE");
        //color pickers
        cpLine = new MyColorPicker(Color.BLACK);
        cpFill = new MyColorPicker(Color.TRANSPARENT);
        //slider
        slider = new MySlider(1, 50, 3);
        //buttons
        clear = new MyButton("CLEAR");
        //labels
        lineColor = new MyLabel("LINE COLOR");
        fillColor = new MyLabel("FILL COLOR");
        lineWidth = new MyLabel("LINE WIDTH");
    }

    /**
     * This public method is a getter that returns custom JavaFX Vbox named toolBar.
     *
     * @return toolBar witch is a JavaFX VBox with set parameters
     */
    public VBox getToolBar()
    {
        toolBar.getChildren().addAll(circle, rectangle, triangle, lineColor, cpLine, fillColor, cpFill, lineWidth, slider, clear);
        toolBar.setPadding(new Insets(5));
        toolBar.setStyle("-fx-background-color: #2a2626");
        toolBar.setPrefWidth(300);

        return toolBar;
    }

    /**
     * This public method is a getter that returns
     * custom JavaFX BorderPane named drawingPane.
     * It is also able to draw shapes on pane
     * by reading users mouse events.
     *
     * @return drawingPane witch is a JavaFX BorderPane with set parameters
     */
    public BorderPane getDrawingPane()
    {
        //When mouse is pressed
        drawingPane.setOnMousePressed
                (e ->
                {
                    if(rectangle.isSelected())
                    {
                        x1 = e.getX();
                        y1 = e.getY();
                    }
                    else if(circle.isSelected())
                    {
                        x1 = e.getX();
                        y1 = e.getY();
                    }
                    else if(triangle.isSelected())
                    {
                        x1 = e.getX();
                        y1 = e.getY();
                    }
                });

        //When mouse is released
        drawingPane.setOnMouseReleased
                (e ->
                {
                    //draw rectangle
                    if(rectangle.isSelected())
                    {
                        x2 = e.getX();
                        y2 = e.getY();

                        final MyRectangle rectangle = (MyRectangle) Shape.enumShapesEvents.RECTANGLE.drawShape(x1,x2,y1,y2);
                        assert rectangle != null;
                        rectangle.setStroke(cpLine.getValue());
                        rectangle.setFill(cpFill.getValue());
                        rectangle.setStrokeWidth(slider.getValue());
                        drawingPane.getChildren().add(rectangle);
                    }

                    //draw circle
                    else if(circle.isSelected())
                    {
                        x2 = e.getX();
                        y2 = e.getY();

                        final MyCircle circle = (MyCircle) Shape.enumShapesEvents.CIRCLE.drawShape(x1,x2,y1,y2);
                        assert circle != null;
                        circle.setStroke(cpLine.getValue());
                        circle.setFill(cpFill.getValue());
                        circle.setStrokeWidth(slider.getValue());
                        drawingPane.getChildren().add(circle);
                    }

                    //draw triangle
                    else if(triangle.isSelected())
                    {
                        x2 = e.getX();
                        y2 = e.getY();

                        final MyTriangle triangle = (MyTriangle) Shape.enumShapesEvents.TRIANGLE.drawShape(x1,x2,y1,y2);
                        assert triangle != null;
                        triangle.setStroke(cpLine.getValue());
                        triangle.setFill(cpFill.getValue());
                        triangle.setStrokeWidth(slider.getValue());
                        drawingPane.getChildren().add(triangle);
                    }
                });
        //clear button
        clear.setOnAction(e -> drawingPane.getChildren().clear());
        return drawingPane;
    }
}
