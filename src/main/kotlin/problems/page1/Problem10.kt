package problems.page1

import base.Problem
import utils.Primes

object Problem10 : Problem {

  fun sumPrimesBelow(limit: Long): Long {
    val primes = HashSet<Long>()
    for (x in 1L until limit) {
      if (Primes.isPrime(x)) {
        primes.add(x)
      }
    }
    return primes.reduce() {sum, element -> sum + element}
  }

  override fun getNumber(): String {
    return "10"
  }

  override fun getDescription(): String {
    return """
      The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

      Find the sum of all the primes below two million.
    """.trimIndent()
  }

  override fun solve(): String {
    return sumPrimesBelow(2000000).toString()
  }
}