package problems.page1

import org.junit.Assert
import org.junit.Test

class Problem12Test {

  @Test
  fun problem12Test() {
    Assert.assertEquals(28, Problem12.getTriangleNumberWithMoreThanNDivisors(5))
  }
}