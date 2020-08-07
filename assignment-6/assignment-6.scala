case class Point(x: Int, y: Int) {
  def +(p1: Point, p2: Point): Point = Point(p1.x + p2.x, p1.y + p2.y)

  def move(dx: Int, dy: Int): Point = Point(x + dx, y + dy)

  def distance(p1: Point, p2: Point): Point = Point(p1.x - p2.x, p1.y - p2.y)

  def invert: Point = Point(y, x)

}

object Test extends App {
  val p1 = Point(2, 3)

  val p2 = Point(4, 7)

  val adding = p1.+(p1, p2)
  println(adding)

  val moving = p1.move(3, 4)
  println(moving)

  val dist = p1.distance(p1, p2)
  println(dist)

  val inverting = p1.invert
  println(inverting)

}
