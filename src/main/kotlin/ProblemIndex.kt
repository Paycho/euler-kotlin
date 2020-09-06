import base.Problem
import problems.Problem1
import problems.Problem2
import problems.Problem3

object ProblemIndex {
  private val problemMap = HashMap<String, Problem>()

  init {
    problemMap[Problem1.getNumber()] = Problem1
    problemMap[Problem2.getNumber()] = Problem2
    problemMap[Problem3.getNumber()] = Problem3
  }

  fun printProblems() {
    println("Available Problems:")
    for (problem in problemMap.values) {
      println(problem.getNumber() + " : " + problem.getDescription())
    }
  }

  fun solveProblem(number: String): String? {
    return problemMap[number]?.solve()
  }
}