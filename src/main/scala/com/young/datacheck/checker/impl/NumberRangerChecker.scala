package com.young.datacheck.checker.impl

import com.young.datacheck.config.CheckFunction
import com.young.datacheck.config.CheckResult
import com.young.datacheck.checker.Checker
import java.lang.{ Double => JDouble }
import com.young.datacheck.checker.CheckDataResult

/**
 * @author Administrator
 */
class NumberRangerChecker extends Checker {
  /**
   * 判断是否是数字
   */
  private def isNumber(number: String): Boolean = {
    try {
      JDouble.parseDouble(number)
      true
    } catch {
      case e: Exception =>
        e.printStackTrace()
        false
    }
  }
  /**
   * 判断数字区间[1,10],(1,10),(1,10],[1,10)
   */
  private def numberRangeCheck(range: String, value: Double): Boolean = {
    val temp = range.trim().split(",")
    val left = temp(0)
    val right = temp(1)
    val min = left.substring(1, left.length()).toDouble
    val max = right.substring(0, right.length() - 1).toDouble
    val minflag = if (left.contains("[")) value >= min else value > min
    val maxflag = if (right.contains("]")) value <= max else value < max
    minflag && maxflag
  }

  /**
   * 检查实现
   */
  override def check(checkFunction: CheckFunction, value: String): CheckDataResult = {
    if (!isNumber(value)) {
      CheckDataResult("[" + value + "] is not number", false)
    }
    if (!numberRangeCheck(checkFunction.funcFormula, JDouble.parseDouble(value))) {
      CheckDataResult("[" + value + "] is not int range " + checkFunction.funcFormula, false)
    } else
      CheckDataResult("correct", true)
  }
}