package problems.page1

import base.Problem
import kotlin.math.pow

object Problem4 : Problem {

  fun findBiggestPalindrome(digits: Int): Int {
    var biggestPalindrome = 0;
    val maximum = 10.toDouble().pow(digits.toDouble()).toInt();
    for (x in (maximum - 1) downTo 0) {
      for (y in (maximum - 1) downTo 0) {
        val product = x.times(y);
        if (isPalindrome(product) && biggestPalindrome < product) {
          biggestPalindrome = product;
        }
      }
    }
    return biggestPalindrome;
  }

  private fun isPalindrome(number: Int): Boolean {
    val numberAsString = number.toString();
    for (x in numberAsString.indices) {
      if (numberAsString[x] != numberAsString[numberAsString.lastIndex - x]) {
        return false;
      }
    }
    return true;
  }

  override fun getNumber(): String {
    return "4";
  }

  override fun getDescription(): String {
    return """
    A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit numbers.
    """
  }

  override fun solve(): String {
    return findBiggestPalindrome(3).toString();
  }
}