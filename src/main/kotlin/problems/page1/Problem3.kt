package problems.page1

import base.Problem
import java.util.*

object Problem3 : Problem {

  fun largestPrimeFactor(number: Long): Long {
    var limit = number
    var test = 2L
    val factors = TreeSet<Long>()
    var factorString = "The factors of $number are: "
    while (test < limit) {
      if (limit % test == 0L) {
        factorString += " $test"
        factors.add(test)
        limit /= test
        continue
      }
      test++
    }
    factors.add(limit)
    println(factorString)
    return factors.last()
  }

  override fun getNumber(): String {
    return "3"
  }

  override fun getDescription(): String {
    return "The prime factors of 13195 are 5, 7, 13 and 29.\n" +
        "\n" +
        "What is the largest prime factor of the number 600851475143?"
  }

  override fun solve(): String {
    return largestPrimeFactor(600851475143).toString()
  }
}