package problems.page1

import base.Problem

object Problem1 : Problem {
  fun sumMultiplesBelow(limit: Int): Int {
    var result = 0
    for (x in (limit - 1) downTo 3) {
      if (x % 5 == 0 || x % 3 == 0) {
        result += x
      }
    }
    return result
  }

  override fun getNumber(): String {
    return "1"
  }

  override fun getDescription(): String {
    return "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.\n" +
        "Find the sum of all the multiples of 3 or 5 below 1000."
  }

  override fun solve(): String {
    return sumMultiplesBelow(1000).toString()
  }
}