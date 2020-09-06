import org.junit.Test
import org.junit.Assert;

class Problem2Test {

  @Test
  fun Problem2Below100() {
    Assert.assertEquals(44, Problem2.sumOfEvenFibonacciValues(100));
  }

  @Test
  fun Problem2Below150() {
    Assert.assertEquals(188, Problem2.sumOfEvenFibonacciValues(150));
  }
}