package problems.page1

import base.Problem
import utils.Primes
import java.util.*

object Problem12 : Problem {

  val divisorMap = HashMap<Long, Long>()

  fun getTriangleNumberWithMoreThanNDivisors(n: Int): Long {
    var triangleIndex = 1L
    var divisors = 0L
    var triangleNumber = 1L
    while(divisors <= n) {
      triangleNumber = (triangleIndex*(triangleIndex + 1))/2
      divisors = findDivisors(triangleNumber)
      triangleIndex++
    }
    verify(triangleNumber, divisors)
    return triangleNumber
  }

  /**
   * Gets the number of divisors by using the count of elements in the prime factorization of the number
   */
  private fun findDivisors(number: Long): Long {
    val factors = Primes.factor(number)
    var divisors = 1L;
    for (entry in factors.entrySet()) {
      divisors *= (entry.count + 1)
    }
    return divisors;
  }

  /**
   * Verifies the number of divisors by slowly iterating through all possible divisors
   */
  private fun verify(triangleNumber: Long, numDivisors: Long) {
    println("Verifying that $triangleNumber has $numDivisors divisors...")
    val divisors = TreeSet<Long>()
    divisors.add(triangleNumber)
    divisors.add(1L)
    var divisor = 2L
    while (divisor < divisors.last()) {
      if (triangleNumber % divisor == 0L) {
        divisors.add(divisor)
        divisors.add(triangleNumber / divisor)
      }
      divisor++
    }
    if (divisors.size == numDivisors.toInt()) {
      println("Verified.")
      return
    }
    println("Actually, $triangleNumber has ${divisors.size} divisors :(")
    throw RuntimeException("Could not verify divisor count")
  }

  override fun getNumber(): String {
    return "12"
  }

  override fun getDescription(): String {
    return """
      The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 
      1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

      1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

      Let us list the factors of the first seven triangle numbers:

       1: 1
       3: 1,3
       6: 1,2,3,6
      10: 1,2,5,10
      15: 1,3,5,15
      21: 1,3,7,21
      28: 1,2,4,7,14,28
      We can see that 28 is the first triangle number to have over five divisors.

      What is the value of the first triangle number to have over five hundred divisors?
    """.trimIndent()
  }

  override fun solve(): String {
    return getTriangleNumberWithMoreThanNDivisors(500).toString()
  }
}