package problems.page1

import base.Problem

object Problem6 : Problem {

  fun squareyDifference(number: Int) : Int {
    var sumOfSquares = 0;
    var squareOfSum = 0;
    for (x in 1..number) {
      sumOfSquares += (x * x);
      squareOfSum += x;
    }
    return (squareOfSum * squareOfSum) - sumOfSquares
  }

  override fun getNumber(): String {
    return "6"
  }

  override fun getDescription(): String {
    return """
      The sum of the squares of the first ten natural numbers is 385

      The square of the sum of the first ten natural numbers is 3025

      Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 2640.

      Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
    """.trimIndent()
  }

  override fun solve(): String {
    return squareyDifference(100).toString()
  }
}