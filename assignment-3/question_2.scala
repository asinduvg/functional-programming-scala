object Recursion extends App {
  
  @scala.annotation.tailrec
  def primeSeq(number: Int, begin: Int = 2): Unit = {
    
    @scala.annotation.tailrec
    def primeSeqHelper(start: Int, divider: Int = 2): Unit = 
      if(start == 2) print("2 ")
      else if(start % divider == 0) ()
      else if(divider == start - 1) print(s"${start} ")
      else primeSeqHelper(start, divider + 1)

    if(number <= 1) ()
    else if(begin <= number) {
      primeSeqHelper(begin)
      primeSeq(number, begin + 1)
    }

  }

  primeSeq(10)

}

