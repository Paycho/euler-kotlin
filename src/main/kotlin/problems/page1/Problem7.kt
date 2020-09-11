package problems.page1

import kotlin.math.sqrt

import base.Problem
import utils.Primes.isPrime

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