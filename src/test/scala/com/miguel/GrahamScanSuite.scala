package com.miguel

import _root_.java.io.PrintWriter
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.miguel.GrahamScanScala.Point

/**
 * Created: Miguel A. Iglesias
 * Date: 5/22/14
 */
class GrahamScanSuite extends FunSuite with ShouldMatchers {

  val points = (1 to 80).map {
    _ =>
      Point(math.random, math.random)
  }.toList


  test("convex hull to plot on octave") {
    val p = new PrintWriter("graham_scala.m")
    import GrahamScanScala._
    val border = scan(points)
    p.println(
      s"""
      |X = [${points.map(_.x).mkString(" ")}];
      |Y = [${points.map(_.y).mkString(" ")}];
      |EX = [${border.map(_.x).mkString(" ")}];
      |EY = [${border.map(_.y).mkString(" ")}];
      |plot(EX,EY,"r-",X,Y,"b+");
    """.stripMargin
    )
    p.close()
  }


}