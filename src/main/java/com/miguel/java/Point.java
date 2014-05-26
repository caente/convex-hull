package com.miguel.java;


/**
 * Created: Miguel A. Iglesias
 * Date: 5/23/14
 */

public class Point {

    //In "real" live I might use getters and setters, but in this case I didn't see the need
    public final Double x;
    public final Double y;

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;

    }

    //improves readability
    public Boolean goesLeft(Point p0, Point p1) {
        return (p1.x - p0.x) * (this.y - p0.y) - (this.x - p0.x) * (p1.y - p0.y) > 0;
    }
}
