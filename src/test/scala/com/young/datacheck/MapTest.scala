package com.young.datacheck

import scala.collection.mutable.HashMap

/**
 * @author dell
 */
object MapTest {
  
  case class Type(name:String)
  
  def main(args: Array[String]): Unit = {
    val map = new HashMap[String,Type]
    map.put("1", Type("1"))
    println(map)
    println(map.get("1").get)
  }
}