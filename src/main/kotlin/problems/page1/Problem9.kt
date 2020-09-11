package problems.page1

import base.Problem

object Problem9 : Problem {

  fun findPythagoreanTriplet(): Long {
    for (c in 3L..1000L) {
      for (b in 2L..1000L) {
        for (a in 1L..1000L) {
          if (a >= b || b >= c || a + b + c != 1000L) {
            continue
          }
          if (a*a + b*b == c*c) {
            return a*b*c
          }
        }
      }
    }
    throw RuntimeException("No valid triplet!")
  }

  override fun getNumber(): String {
    return "9"
  }

  override fun getDescription(): String {
    return """
      A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

      a^2 + b^2 = c^2
      For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

      There exists exactly one Pythagorean triplet for which a + b + c = 1000.
      Find the product abc.
    """.trimIndent()
  }

  override fun solve(): String {
    return findPythagoreanTriplet().toString()
  }

}