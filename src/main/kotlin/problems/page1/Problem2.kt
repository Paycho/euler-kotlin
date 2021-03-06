package problems.page1

import base.Problem

object Problem2 : Problem {
  fun sumOfEvenFibonacciValues(limit: Int): Int {
    var f1 = 1
    var f2 = 0
    var next: Int;
    var sum = 0
    while (true) {
      next = f1 + f2
      f2 = f1
      f1 = next
      if (next > limit) {
        break
      }
      if (f1 % 2 == 0) {
        sum += f1
      }
    }
    return sum
  }

  override fun getNumber(): String {
    return "2"
  }

  override fun getDescription(): String {
    return "Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:\n" +
        "\n" +
        "1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...\n" +
        "\n" +
        "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms."
  }

  override fun solve(): String {
    return sumOfEvenFibonacciValues(4000000).toString()
  }
}