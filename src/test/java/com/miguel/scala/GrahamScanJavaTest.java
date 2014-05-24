package com.miguel.scala;

import com.miguel.java.Coordinate;
import com.miguel.java.GrahamScanJava;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** 
* GrahamScanJava Tester. 
* 
* @author <Authors name> 
* @since <pre>May 23, 2014</pre> 
* @version 1.0 
*/ 
public class GrahamScanJavaTest {

    Random rnd = new Random();

    List<Coordinate> coordinates = IntStream.rangeClosed(1,40).mapToObj(t -> new Coordinate(rnd.nextDouble(), rnd.nextDouble())).collect(Collectors.toList());

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: scan(List<Coordinate> coordinates)
* 
*/ 
@Test
public void testConvexHull() throws Exception {
    PrintWriter p = new PrintWriter("graham_java.m");
    p.print("X = [");
    coordinates.stream().map(c -> c.x.toString() + " ").forEach(p::print);
    p.println("];");
    p.print("Y = [");
    coordinates.stream().map(c -> c.y.toString() + " ").forEach(p::print);
    p.println("];");
    List<Coordinate> border = GrahamScanJava.scan(coordinates);
    p.print("EX = [");
    border.stream().map(c -> c.x.toString() + " ").forEach(p::print);
    p.println("];");
    p.print("EY = [");
    border.stream().map(c -> c.y.toString() + " ").forEach(p::print);
    p.println("];");
    p.println("plot(EX,EY,\"r-\",X,Y,\"b+\");");
    p.println();
    p.close();
}


}
