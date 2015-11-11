package com.young.datacheck.checker



/**
 * @author Administrator
 */
sealed trait CheckType

case object RegexType extends CheckType

case object StringType extends CheckType