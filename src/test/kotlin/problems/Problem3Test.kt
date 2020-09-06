package problems

import org.junit.Assert
import org.junit.Test

class Problem3Test {

  @Test
  fun problem3Input13195() {
    Assert.assertEquals(29L, Problem3.largestPrimeFactor(13195))
  }
}