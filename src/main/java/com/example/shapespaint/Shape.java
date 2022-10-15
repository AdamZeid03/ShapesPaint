package com.example.shapespaint;

/**
 * This class named Shape contains an enum that can return
 * an Object reading two set of parameters (x1,y1), (x2,y2).
 *
 * @author Adam Zeid
 */
public class Shape
{
    enum enumShapesEvents implements Methods
    {
        CIRCLE,
        RECTANGLE,
        TRIANGLE;

        /**
         * This public method from interface Methods is
         * doing calculations on Cartesian coordinate system
         * in order to return one of three objects MyPolygon,
         * MyRectangle or MyCircle.
         *
         * @return Circle or Rectangle or Triangle witch are a JavaFX Shapes
         */
        @Override
        public Object drawShape(final double x1, final double x2, final double y1, final double y2)
        {
            Object object;
            final double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            switch (this)
            {
                case CIRCLE ->
                {
                    object = new MyCircle(x1, y1, distance);
                }
                case RECTANGLE ->
                {
                    final double width = Math.abs(x1 - x2);
                    final double height = Math.abs(y1 - y2);
                    if (x1 > x2 && y1 > y2)
                    {
                        object = new MyRectangle(x2, y2, width, height);
                    }
                    else if (x1 > x2)
                    {
                        object = new MyRectangle(x2, y1, width, height);
                    }
                    else if (y1 > y2)
                    {
                        object = new MyRectangle(x1, y1, width, height);
                    }
                    else
                    {
                        object = new MyRectangle(x1, y1, width, height);
                    }
                }

                case TRIANGLE ->
                {
                    final double buildX1 = x2 - distance;
                    final double buildX3 = x2 + distance;

                    object = new MyTriangle(buildX1, y2, buildX3, y2, x1, y1);
                }
                default ->
                {
                    object = 0;
                }
            }
            return object;
        }
    }
}
