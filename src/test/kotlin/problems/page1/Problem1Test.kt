package problems.page1

import org.junit.Assert
import org.junit.Test

class Problem1Test {

  @Test
  fun problem1KnownInputs() {
    Assert.assertEquals(23, Problem1.sumMultiplesBelow(10))
  }
}