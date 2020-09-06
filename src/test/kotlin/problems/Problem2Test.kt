package problems

import org.junit.Assert
import org.junit.Test

class Problem2Test {

  @Test
  fun problem2Below100() {
    Assert.assertEquals(44, Problem2.sumOfEvenFibonacciValues(100))
  }

  @Test
  fun problem2Below150() {
    Assert.assertEquals(188, Problem2.sumOfEvenFibonacciValues(150))
  }
}