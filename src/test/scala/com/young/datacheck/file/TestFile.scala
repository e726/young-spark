package com.young.datacheck.file

import scala.io.Source
import java.io.FileInputStream

/**
 * @author Administrator
 */
object TestFile {
  def main(args: Array[String]): Unit = {
    val file = "E:\\data\\spark\\check.xml"
    val string = Source.fromInputStream(new FileInputStream(file), "utf-8").getLines()
    println(string.mkString("\n"))
  }
}