package base

interface Problem {
  /**
   * Get the problem number as a string, e.g. "1"
   */
  fun getNumber(): String;

  /**
   * Get the description of the problem (typically pasted from Project Euler).
   */
  fun getDescription(): String;

  /**
   * Return the solution as a String, e.g. "233168"
   */
  fun solve(): String;
}