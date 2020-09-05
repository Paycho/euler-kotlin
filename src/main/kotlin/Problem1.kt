object Problem1 {
  public fun sumMultiplesBelow(limit: Int): Int {
    var result = 0;
    for (x in (limit - 1) downTo 3) {
      if (x % 5 == 0 || x % 3 == 0) {
        result += x;
      }
    }
    return result;
  }
}