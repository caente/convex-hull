package com.miguel

import math.atan2

object GrahamScanScala {

  case class Coordinate(x: Double, y: Double) {
    //improves readability
    def goesLeft(p0: Coordinate, p1: Coordinate): Boolean = (p1.x - p0.x) * (this.y - p0.y) - (this.x - p0.x) * (p1.y - p0.y) > 0
  }

  def scan(coords: List[Coordinate]): List[Coordinate] = {
    //instead of using PUSH and POP, foldRight
    def addToHull(hull: List[Coordinate], next: Coordinate): List[Coordinate] = next :: hull.foldRight(List.empty[Coordinate]) {
      case (top, currentHull@(head :: _)) => if (next.goesLeft(head, top)) top :: currentHull else currentHull
      case (top, currentHull) => top :: currentHull
    }
    val min = coords.minBy(_.y)
    //adding the min to close the polygon on octave
    min :: coords.sortBy(point => atan2(point.y - min.y, point.x - min.x)).foldLeft(List.empty[Coordinate])(addToHull)
  }
}


