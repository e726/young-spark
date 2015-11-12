package com.young.datacheck.checker

import com.young.datacheck.checker.impl.NumberRangerChecker

/**
 * @author dell
 */
object NumberCheckerTest {
  def main(args: Array[String]): Unit = {
    val checker = new NumberRangerChecker
    val range = "[1.1,10)"
    val value = 1.1
   // println(checker.numberRangeCheck(range, value))
  }
}