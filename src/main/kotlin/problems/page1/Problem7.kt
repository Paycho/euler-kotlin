package problems.page1

import base.Problem
import kotlin.math.sqrt

object Problem7 : Problem {

  fun findNthPrime(nth: Long): Long {
    var numberToTest = 4L;
    val primeSet = HashSet<Long>()
    primeSet.add(2)
    primeSet.add(3)
    while(primeSet.size < nth) {
      numberToTest++
      if (isPrime(numberToTest)) {
        primeSet.add(numberToTest)
      }

      for (prime in primeSet) {
        if (prime > sqrt(numberToTest.toDouble())) {
          break;
        }
        if (numberToTest % prime == 0L) {
          break;
        }
        if (primeSet.last() == prime) {
          primeSet.add(numberToTest)
          break;
        }
      }
    }
    return numberToTest
  }

  private fun isPrime(number: Long): Boolean {
    if (number <= 1) {
      return false
    }
    if (number <= 3) {
      return true
    }

    if (number % 2L == 0L || number % 3L == 0L) {
      return false
    }

    var test = 5L
    while (test * test <= number){
      if (number % test == 0L || number % (test + 2L) == 0L) {
        return false
      }
      test += 6L
    }
    return true
  }

  override fun getNumber(): String {
    return "7"
  }

  override fun getDescription(): String {
    return """
      By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

      What is the 10,001st prime number?
    """.trimIndent()
  }

  override fun solve(): String {
    return findNthPrime(10001).toString()
  }

}