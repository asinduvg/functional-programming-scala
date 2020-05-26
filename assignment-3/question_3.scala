object Recursion extends App {
  
  @scala.annotation.tailrec
  def addition(number: Int, acc: Int = 0): Int =
    if (number == 0) acc
    else addition(number - 1, acc + number)

  println(addition(5))

}
