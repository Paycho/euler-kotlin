import kotlin.system.measureNanoTime

fun main(args: Array<String>) {
  println("Enter a problem number, or press Ctrl-D to quit.")
  var input: String? = readLine()
  while (input != null) {
    val solution: String?
    val executionTime = measureNanoTime {
      solution = ProblemIndex.solveProblem(input!!)
    }
    if (solution == null) {
      println("Invalid input.")
      ProblemIndex.printProblems()
    } else {
      val seconds: Double = executionTime.div(1000000000.0);
      println("The solution to problem $input is $solution. Solved in $seconds seconds.")
    }
    println("Enter a problem number, or press Ctrl-D to quit.")
    input = readLine()
  }
}