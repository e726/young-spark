package com.young.datacheck.checker

import com.young.datacheck.config.CheckFunction
import com.young.datacheck.config.CheckResult
import scala.collection.mutable.HashMap


/**
 * @author Administrator
 * 检查器接口
 */
trait Checker {
  
  val checkPool = new HashMap[CheckType,Checker]
  
  def check(checkFunction: CheckFunction): CheckResult
}