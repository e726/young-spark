package com.young.datacheck.tools

import java.io.InputStream
import scala.io.Source

/**
 * @author Administrator
 */
object FileUtil {
  def readFile(input: InputStream, encode: String = "utf-8", mkString: String = "\n"): String = {
    val result = Source.fromInputStream(input, encode).mkString(mkString)
    result
  }
}