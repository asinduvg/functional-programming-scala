object Bank extends App {

  class Account(private var balance: Double = 0) {

    def transfer(account: Account, amount: Double): Unit = {
      this.balance -= amount
      account.balance += amount
    }

  }

  val a1 = new Account(127.3)
  val a2 = new Account(10.5)

  a1.transfer(a2, 10)

}
