package utilities

import Problem1
import base.Problem

object ProblemIndex {
  private val problemMap = HashMap<String, Problem>();
  init {
    problemMap[Problem1.getNumber()] = Problem1;
  }

  fun printProblems() {
    println("Available Problems:")
    for(problem in problemMap.values) {
      println(problem.getNumber() + " : " + problem.getDescription());
    }
  }

  fun solveProblem(number: String): String? {
    return problemMap[number]?.solve();
  }
}