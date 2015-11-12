package com.young.datacheck.checker.impl

import com.young.datacheck.checker.Checker
import com.young.datacheck.config.CheckFunction
import com.young.datacheck.config.CheckResult
import com.young.datacheck.checker.CheckDataResult
import scala.collection.mutable.HashMap
import java.util.regex.Pattern

/**
 * @author Administrator
 * 正则表达式检查器
 */
class RegexChecker extends Checker {

  private val regexPool = new HashMap[String, Pattern]

  private def getRegexPattern(regex: String): Pattern = {
    if (regexPool.contains(regex)) {
      val pattern = regexPool.get(regex).get
      pattern
    } else {
      val pattern = Pattern.compile(regex)
      regexPool.put(regex, pattern)
      pattern
    }
  }
  /**
   * 判断是否匹配正则表达式
   */
  private def checkRegex(regex: String, value: String): Boolean = {
    val pattern = getRegexPattern(regex)
    val flag = pattern.matcher(value).matches()
    flag
  }

  override def check(checkFunction: CheckFunction, value: String): CheckDataResult =
    if (checkRegex(checkFunction.funcFormula, value))
      CheckDataResult("correct", true)
    else
      CheckDataResult("[" + value + "] not match pattern [" + checkFunction.funcFormula + "]", false)

}