
import base.Problem
import org.reflections.Reflections

object ProblemIndex {
  private val problemMap = HashMap<String, Problem>()

  fun generateProblemMap() {
    val reflections = Reflections("problems")
    val problemSet = reflections.getSubTypesOf(Problem::class.javaObjectType)
    for (entry in problemSet) {
      val problem = entry.kotlin.objectInstance
      if (problem != null) {
        problemMap[problem.getNumber()] = problem
      }
    }
  }

  fun printAvailableProblems() {
    println("Available problems: ${problemMap.keys}")
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