package base

interface Problem {
  fun getNumber(): String;
  fun getDescription(): String;

  fun solve(): String;
}