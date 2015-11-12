package com.young.datacheck.checker

/**
 * @author Administrator
 */
case class CheckType(className: String) extends Equals{
  override def hashCode() = className.hashCode()
  override def toString() = className
}