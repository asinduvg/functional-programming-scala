object Salary {
  def main(args: Array[String]): Unit = {
    println(s"Takehome Salary is: ${takeHomeSalary()}")
  }
  
  def normalSalary(hours: Int, payment: Int = 150): Int = hours * payment
  def OTSalary(hours: Int, payment: Int = 75): Int = normalSalary(hours, payment)
  def fullSalary(normalWorkingHours: Int, otHours: Int): Int = normalSalary(normalWorkingHours) + OTSalary(otHours)
  def tax(income: Int): Double = income * 0.1
  def takeHomeSalary(normalWorkingHours: Int = 40, otHours: Int = 20): Double = {
    val income = fullSalary(normalWorkingHours, otHours)
    income - tax(income)
  }
}

