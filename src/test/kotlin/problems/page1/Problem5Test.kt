package problems.page1

import org.junit.Assert
import org.junit.Test

class Problem5Test {

  @Test
  fun problem5Test() {
    Assert.assertEquals(2520, Problem5.findSmallestDivisibleNumber(10));
  }
}