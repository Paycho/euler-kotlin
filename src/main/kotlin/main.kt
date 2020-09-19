import kotlin.system.measureNanoTime

private val helpString = """

  Available commands:
    desc  [problem number] - print description of problem from project Euler
    solve [problem number] - print solution/timing for problem
""".trimIndent()

fun main(unusedArgs: Array<String>) {
  ProblemIndex.generateProblemMap()
  println(helpString)
  println("Problem numbers go from ${ProblemIndex.minimumProblem} to ${ProblemIndex.maximumProblem}\n\n")
  var input: String? = readLine()
  while (input != null) {
    var command = input.split(" ")
    if (command.size == 1) {
      input = "solve $input"
      command = input.split(" ")
    }
    when {
      command[0] == "desc" -> {
        ProblemIndex.describe(command[1])
      }
      command[0] == "solve" -> {
        val executionTime = measureNanoTime {
          ProblemIndex.solveProblem(command[1])
        }
        val seconds: Double = executionTime.div(1000000000.0)
        println("Problem solved in $seconds seconds.")
      }
      else -> {
        println("Invalid input.")
      }
    }
    println(helpString)
    println("Problem numbers go from ${ProblemIndex.minimumProblem} to ${ProblemIndex.maximumProblem}\n\n")
    input = readLine()
  }
}