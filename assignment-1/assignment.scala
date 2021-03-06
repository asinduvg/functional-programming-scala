object Problems {
  def main(args: Array[String]): Unit = {
    println(convert(35))
    println(volume(3))
    println(booksPrice(60) - discount(booksPrice(60)) + shippingCost(60))
  }

  def convert(temp: Double): Double = temp * 1.8000 + 32.00
  def volume(r: Double): Double = 4.0 / 3.0 * math.Pi * math.pow(r, 3)
 
  def booksPrice(copies: Int): Double = 24.95 * copies
  def discount(amount: Double): Double = amount * 40 / 100
  def shippingCost(copies: Int):Double = if(copies <= 50) 3 * copies else (50 * 3) + (copies - 50) * 0.75
}
