package problems.page1

import base.Problem

object Problem5 : Problem{

  fun findSmallestDivisibleNumber(number: Int): Int {
    for (test in number until Int.MAX_VALUE step number) {
      var valid = true;
      for (divisor in number downTo 1) {
        if (test % divisor != 0) {
          valid = false;
        }
      }
      if (valid == true) {
        return test;
      }
    }
    throw RuntimeException("No number evenly divides the argument!");
  }

  override fun getNumber(): String {
    return "5"
  }

  override fun getDescription(): String {
    return """
      2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

      What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    """.trimIndent()
  }

  override fun solve(): String {
    return findSmallestDivisibleNumber(20).toString();
  }
}