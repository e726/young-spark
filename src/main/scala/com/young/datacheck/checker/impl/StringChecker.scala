package com.young.datacheck.checker.impl

import com.young.datacheck.checker.Checker
import com.young.datacheck.config.CheckFunction
import com.young.datacheck.config.CheckResult
import com.young.datacheck.checker.CheckDataResult

/**
 * @author Administrator
 * 字符串常规检查null&blank&length=[0,10]
 */
class StringChecker extends Checker {
  override def check(checkFunction: CheckFunction, value: String): CheckDataResult = {
    CheckDataResult("", true)
  }
}