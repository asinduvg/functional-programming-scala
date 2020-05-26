object Recursion extends App {
  
  @scala.annotation.tailrec
  def prime(number: Int, divider: Int = 2): Boolean = 
    if(number == 1) false
    else if(number == 2) true
    else if(divider == number - 1) true
    else if(number % divider == 0) false
    else prime(number, divider + 1)
  

  println(prime(1))
  println(prime(2))
  println(prime(5))
  println(prime(8))

}
