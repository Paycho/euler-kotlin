
import base.Problem

object ProblemIndex {
  private val problemMap = HashMap<String, Problem>()

  init {
    generateProblemMap();
  }

  private fun generateProblemMap() {
    for (page in 1 until 50) {
      for (problem in (50 * (page - 1)) until (50 * (page - 1) + 50)) {
        try {
          val className = "problems.page$page.Problem$problem";
          val problemClass: Class<*> = Class.forName(className);
          val problemInstance = problemClass.kotlin.objectInstance;
          problemMap[(problemInstance as Problem).getNumber()] = problemInstance;
        } catch (e: ClassNotFoundException) {
          // Expected, carry on!
        }
      }
    }
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