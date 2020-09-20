package problems.page1

import base.Problem
import com.google.common.collect.ImmutableList

object Problem14: Problem {

  val knownLengths = HashMap<Long, Long>()

  fun longestCollatzSequence(limit: Long): Long {
    var longestSequence = 0L
    var longestStartingNumber = 1L
    for (candidate in 1L until limit) {
      if (candidate % 1000L == 0L) {
        println("analyzing $candidate...")
      }
      val collatzSequenceLength = findSequenceLength(candidate)
      if (collatzSequenceLength > longestSequence) {
        longestSequence = collatzSequenceLength
        longestStartingNumber = candidate
      }
    }
    return longestStartingNumber
  }

  fun findSequenceLength(number: Long): Long {
    var n = number
    var collatzSequence = ImmutableList.builder<Long>()
    while (true) {
      if (knownLengths.containsKey(n)) {
        val partialSequence = collatzSequence.build()
        addSequenceLengthsToCacheWithPartialList(partialSequence, knownLengths[n]!!)
        return partialSequence.size + knownLengths[n]!!
      }
      collatzSequence.add(n)
      if (n % 2L == 0L) {
        n /= 2L
      } else {
        n = (3L*n) + 1L
      }
      if (n == 1L) {
        collatzSequence.add(n)
        break;
      }
    }

    val finalSequence = collatzSequence.build()
    addSequenceLengthsToCache(finalSequence)
    return finalSequence.size.toLong()
  }

  private fun addSequenceLengthsToCacheWithPartialList(sequence: ImmutableList<Long>, priorlength: Long) {
    for (n in sequence.indices) {
      knownLengths[sequence[n]] = sequence.subList(n, (sequence.lastIndex + 1L).toInt()).size + priorlength
    }
  }

  private fun addSequenceLengthsToCache(sequence: ImmutableList<Long>) {
    for (n in sequence.indices) {
      knownLengths[sequence[n]] = sequence.subList(n, (sequence.lastIndex + 1L).toInt()).size.toLong()
    }
  }

  override fun getNumber(): String {
    return "14"
  }

  override fun getDescription(): String {
    return """
      The following iterative sequence is defined for the set of positive integers:

      n → n/2 (n is even)
      n → 3n + 1 (n is odd)

      Using the rule above and starting with 13, we generate the following sequence:

      13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
      It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

      Which starting number, under one million, produces the longest chain?

      NOTE: Once the chain starts the terms are allowed to go above one million.
    """.trimIndent()
  }

  override fun solve(): String {
    return longestCollatzSequence(1000000).toString()
  }
}