package utils

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
}