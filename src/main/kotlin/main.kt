import utilities.ProblemIndex

fun main(args: Array<String>) {
  println("Enter a problem number, or press Ctrl-D to quit.");
  var input: String? = readLine();
  while (input != null) {
    val solution: String? = ProblemIndex.solveProblem(input);
    if (solution == null) {
      println("Invalid input.");
      ProblemIndex.printProblems();
    } else {
      println("The solution to problem $input is $solution.");
    }
    println("Enter a problem number, or press Ctrl-D to quit.");
    input = readLine();
  }
}