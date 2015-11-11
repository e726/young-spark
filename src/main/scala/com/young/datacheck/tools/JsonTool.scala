package com.young.datacheck.tools

import org.codehaus.jackson.map.ObjectMapper

/**
 * @author Administrator
 */
object JsonTool {

  val mapper = new ObjectMapper

  def toJson(obj: Any): String = mapper.writeValueAsString(obj)
}