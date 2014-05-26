package com.miguel

import math.atan2

object GrahamScanScala {

  case class Point(x: Double, y: Double) {
    //improves readability
    def goesLeft(p0: Point, p1: Point): Boolean = (p1.x - p0.x) * (this.y - p0.y) - (this.x - p0.x) * (p1.y - p0.y) > 0
  }

  def scan(coords: List[Point]): List[Point] = {
    //instead of using PUSH and POP, foldRight
    def addToHull(hull: List[Point], new_point: Point): List[Point] = new_point :: hull.foldRight(List.empty[Point]) {
      case (next_top, currentHull@(top :: _)) => if (new_point.goesLeft(top, next_top)) next_top :: currentHull else currentHull
      case (next_top, currentHull) => next_top :: currentHull
    }
    val min = coords.minBy(_.y)
    //adding the min to close the polygon on octave
    min :: coords.sortBy(point => atan2(point.y - min.y, point.x - min.x)).foldLeft(List.empty[Point])(addToHull)
  }
}


