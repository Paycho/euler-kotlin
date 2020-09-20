package problems.page1

import base.Problem
import utils.Primes

object Problem3 : Problem {

  fun largestPrimeFactor(number: Long): Long {
    val factors = Primes.factor(number)
    println("The factors of $number are ${factors.entrySet()}")
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