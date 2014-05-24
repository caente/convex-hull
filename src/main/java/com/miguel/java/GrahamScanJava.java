package com.miguel.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created: Miguel A. Iglesias
 * Date: 5/23/14
 */
public class GrahamScanJava {


    static private List<Coordinate> addToHull(List<Coordinate> hull, Coordinate next) {
        while (hull.size() > 2 && !next.goesLeft(hull.get(hull.size() - 2), hull.get(hull.size() - 1))) {
            hull.remove(hull.size() - 1);
        }
        hull.add(next);
        return hull;
    }


    static public List<Coordinate> scan(List<Coordinate> coords) {
        Coordinate min = coords.stream().min((o1, o2) -> o1.y.compareTo(o2.y)).get();
        List<Coordinate> sorted = coords.stream()
                .sorted((o1, o2) -> Double.compare(Math.atan2(o1.y - min.y, o1.x - min.x), Math.atan2(o2.y - min.y, o2.x - min.x)))
                .collect(Collectors.toList());
        List<Coordinate> hull = new ArrayList<>();
        for (Coordinate coord : sorted) {
            hull = addToHull(hull, coord);
        }
        //adding the min to close the polygon on octave
        hull.add(min);
        return hull;
    }
}
