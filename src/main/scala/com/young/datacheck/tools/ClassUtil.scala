package com.young.datacheck.tools

/**
 * @author dell
 */
object ClassUtil {
  def loadClass(className:String):Any={
    val any = Class.forName(className).newInstance()
    any
  }
}