object Recursion extends App {

  def fibonacci(number: Int, begin: Int = 3): Int = {
    
    @scala.annotation.tailrec
    def fibHelper(start: Int, prev: Int, beforePrev: Int): Int =
      if (start > number) prev
      else fibHelper(start + 1, prev + beforePrev, prev)

    if (number == 0) 0
    else if (number <= 2) 1
    else fibHelper(begin, 1, 1)
  
  }

  println(fibonacci(9))

}
