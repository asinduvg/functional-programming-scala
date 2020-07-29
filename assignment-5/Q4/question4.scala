class Account(val nic: String, val acNo: Int, var balance: Double = 0) {

  def transfer(account: Account, amount: Double): Unit = {
    this.balance -= amount
    account.balance += amount
  }

  def deposit(interest: Double): Unit = this.balance += this.balance * interest

  override def toString: String = s"[NIC: $nic, AccountNo: $acNo, Balance: $balance]"

}

object Account {

  def negativeAccounts(accounts: List[Account]): List[Account] = accounts.filter(_.balance < 0)

  def sumOfAccounts(accounts: List[Account]): Double = accounts.map(_.balance).sum

}


object Bank extends App {

  val accountList: List[Account] = List(new Account("971234567V", 1234, 100), new Account("981234567V", 5678, -50), new Account("991234567V", 123, 400.5), new Account("961234567V", 456, -3.3))

  println("account holders")
  accountList.foreach(println)

  println("\n4.1 -> list of accounts with negative values")
  Account.negativeAccounts(accountList).foreach(println)

  println("\n4.2 -> sum of all account balances")
  val sumOfPositiveBalanceAccounts = Account.sumOfAccounts(accountList.filter(_.balance > 0))
  val sumOfAllAccounts = Account.sumOfAccounts(accountList)
  println(sumOfPositiveBalanceAccounts)
  println(sumOfAllAccounts)

  println("\n4.3 -> final balances after adding interests")
  accountList.foreach(x => if (x.balance > 0) x.deposit(0.05) else x.deposit(0.1))
  accountList.foreach(println)

}


