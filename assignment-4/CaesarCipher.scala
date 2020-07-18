import java.util.Scanner

object CaesarCipher extends App {

  private val charsSimple: Seq[Char] = ('a' to 'z').toList
  private val charsCapital: Seq[Char] = ('A' to 'Z').toList
  private val numbers: Seq[Int] = (0 to 25).toList
  private val merged = charsSimple zip charsCapital zip numbers

  // algorithm
  val crypt = (c: Char, f: (Int, Int) => Int) => {

    val byteVal = c.toByte

    if (byteVal >= 65 && byteVal <= 90 || byteVal >= 97 && byteVal <= 122) {

      val res = merged.filter(f => f._1._1 == c || f._1._2 == c).head._2
      val en = f(res, key).abs
      if (c.isLower) merged.filter(f => f._2 == en).head._1._1
      else merged.filter(f => f._2 == en).head._1._2

    } else c

  }

  val isApproved = new PartialFunction[Int, Int] {
    override def apply(key: Int): Int = key

    override def isDefinedAt(key: Int): Boolean = key > 0 && key <= 25
  }

  val encrypt = (c: Char) => {
    crypt(c, (res: Int, key: Int) => (res + key) % 26)
  }

  val decrypt = (c: Char) => {
    crypt(c, (res: Int, key: Int) => (res - key + 26) % 26)
  }

  // inputs
  var in = new Scanner(System.in)
  println("Enter the message needed to be encrypted: ")
  val str = in.nextLine()
  println("Enter key: ")
  val key = in.nextInt()
  val encryptedMessage = if (isApproved.isDefinedAt(key)) str.map(encrypt) else ""
  println("Encrypting /...")
  if (!encryptedMessage.isEmpty) {
    println("Encrypted..")
    println(s"Encrypted message: ${encryptedMessage}")
    println("Enter following commands")
    println("1 -> Decrypt message")
    println("any number -> Exit")
    val choice = in.nextInt()
    choice match {
      case 1 => {
        println("Enter key: ")
        val inputKey = in.nextInt()
        if (key == inputKey) {
          println("Decrypting /..")
          println("Decrypted..")
          println(s"Decrypted message: ${encryptedMessage.map(decrypt)}")
        }
        else println("Entered key is wrong!!")
      }
      case _ => System.exit(0)
    }
  } else println("Key is not in range!!")

  in.close()

}
