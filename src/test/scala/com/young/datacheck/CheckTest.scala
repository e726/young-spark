package com.young.datacheck

import com.young.datacheck.mapreduce.CheckMR

/**
 * @author Administrator
 */
object CheckTest {
  def main(args: Array[String]): Unit = {
    val input = "E:\\data\\spark\\wordcount.txt"
    val output = "E:\\data\\spark\\output.txt"
    val check = new CheckMR("local[2]")
    check.mainCheck(input, output, null,true)
  }
}