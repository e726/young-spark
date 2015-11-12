package com.young.datacheck.checker

import scala.collection.mutable.HashMap

import com.young.datacheck.config.CheckFunction
import com.young.datacheck.tools.ClassUtil
import scala.Option

/**
 * @author Administrator
 * 检查器接口
 */
case class CheckDataResult(msg: String, flag: Boolean)
trait Checker {
  private val checkPool = new HashMap[CheckType, Checker]()

  private def initChecker(checkType: CheckType): Checker = ClassUtil.loadClass(checkType.className).asInstanceOf[Checker]

  protected def getChecker(checkType: CheckType): Checker = {
    if (checkPool.contains(checkType)) {
      val checker = checkPool.get(checkType).get
      checker
    } else {
      val checker = initChecker(checkType)
      checkPool.put(checkType, checker)
      checker
    }
  }

  def check(checkFunction: CheckFunction, value: String): CheckDataResult
}