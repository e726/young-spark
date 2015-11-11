package com.young.spark.mr
import org.apache.spark.SparkContext._
import org.apache.spark.SparkContext

/**
 * @author Administrator
 */
object WordCount {
  
  val sparkContext = new SparkContext("local[2]","wordCount")
  
  def main(args: Array[String]): Unit = {
    val path = "E:\\data\\spark\\wordcount.txt"
    val result = sparkContext.textFile(path, 2).flatMap(_.split(" ")).map((_,1)).countByKey
    result.foreach(println _)
  }
}