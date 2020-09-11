
import base.Problem

object ProblemIndex {
  private val problemMap = HashMap<String, Problem>()
  val minimumProblem = 1;
  var maximumProblem = 1;

  fun generateProblemMap() {
    for (page in 1 until 50) {
      for (problem in (50 * (page - 1)) until (50 * (page - 1) + 50)) {
        try {
          val className = "problems.page$page.Problem$problem";
          val problemClass: Class<*> = Class.forName(className);
          val problemInstance = problemClass.kotlin.objectInstance;
          problemMap[(problemInstance as Problem).getNumber()] = problemInstance;
          if (problem > maximumProblem) {
            maximumProblem = problem;
          }
        } catch (e: ClassNotFoundException) {
          // Expected, carry on!
        }
      }
    }
  }

  fun solveProblem(number: String) {
    println("Solving problem $number:")
    println(problemMap[number]?.solve() ?: "Invalid Problem Number")
  }

  fun describe(number: String) {
    println("Describing problem $number:")
    println(problemMap[number]?.getDescription()?.trimIndent() ?: "Invalid Problem Number")
  }
}