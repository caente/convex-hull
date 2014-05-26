package com.miguel.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created: Miguel A. Iglesias
 * Date: 5/23/14
 */
public class GrahamScanJava {


    static private List<Point> addToHull(List<Point> hull, Point next) {
        while (hull.size() > 2 && !next.goesLeft(hull.get(hull.size() - 2), hull.get(hull.size() - 1))) {
            hull.remove(hull.size() - 1);
        }
        hull.add(next);
        return hull;
    }


    static public List<Point> scan(List<Point> coords) {
        Point min = coords.stream().min((o1, o2) -> o1.y.compareTo(o2.y)).get();
        List<Point> sorted = coords.stream()
                .sorted((o1, o2) -> Double.compare(Math.atan2(o1.y - min.y, o1.x - min.x), Math.atan2(o2.y - min.y, o2.x - min.x)))
                .collect(Collectors.toList());
        List<Point> hull = new ArrayList<>();
        for (Point coord : sorted) {
            hull = addToHull(hull, coord);
        }
        //adding the min to close the polygon on octave
        hull.add(min);
        return hull;
    }
}
