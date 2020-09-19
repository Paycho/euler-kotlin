package utils

import com.google.common.collect.ImmutableSortedMultiset
import com.google.common.collect.TreeMultiset

public object Primes {
  public fun isPrime(number: Long): Boolean {
    if (number <= 1) {
      return false
    }
    if (number <= 3) {
      return true
    }

    if (number % 2L == 0L || number % 3L == 0L) {
      return false
    }

    var test = 5L
    while (test * test <= number){
      if (number % test == 0L || number % (test + 2L) == 0L) {
        return false
      }
      test += 6L
    }
    return true
  }

  /**
   * Get the prime factorization of the number as a Multiset
   */
  public fun factor(number: Long): ImmutableSortedMultiset<Long> {
    val factors = TreeMultiset.create<Long>()
    var limit = number
    var test = 2L;
    while (test <= limit) {
      if (limit % test == 0L) {
        factors.add(test)
        limit /= test
        continue;
      }
      test++
    }
    return ImmutableSortedMultiset.copyOf(factors)
  }
}