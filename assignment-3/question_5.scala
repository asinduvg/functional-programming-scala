object Recursion extends App {

  @scala.annotation.tailrec
  def additionOfEven(number: Int, acc: Int = 0): Int = {
    if (number == 0) acc
    else if (number % 2 == 0) additionOfEven(number - 2, acc + number)
    else additionOfEven(number - 1, acc)
  }

  println(additionOfEven(9))

}
