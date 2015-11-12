package com.young.datacheck.mapreduce

import scala.util.Random

import org.apache.commons.logging.LogFactory
import org.apache.spark.SparkContext

import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamImplicit
import com.young.datacheck.config.DataCheck

/**
 * @author Administrator
 */
case class LineResult(message: String, flag: Boolean)
class CheckMR(sparkUrl: String) extends Serializable {

  val log = LogFactory.getLog(classOf[CheckMR])
  @transient
  val sparkContext = new SparkContext(sparkUrl, "checkMapReducer_" + System.currentTimeMillis())

  val rand = new Random

  def mainCheck(input: String, output: String, checkConfig: DataCheck, is_log: Boolean = false) = {
    val textFile = sparkContext.textFile(input)
    val checkResult = textFile.map(text => {
      val lineResult = checkLine(text, checkConfig)
      lineResult
    }).cache
    val correctData = checkResult.filter { lineResult => lineResult.flag }.map { _.message }
    val errorData = checkResult.filter { lineResult => !lineResult.flag }.map { _.message }
    //correctData.saveAsTextFile(output+File.separator+checkConfig.auditInfo.taskParam.correntOutput)
    //    errorData.saveAsTextFile(output+File.separator+checkConfig.auditInfo.taskParam.errorOutput)
    if (is_log) {
      correctData.collect().foreach { println _ }
      errorData.collect().foreach { println _ }
    }
  }

  private def checkLine(line: String, checkConfig: DataCheck): LineResult = {
    if (rand.nextInt(10) < 8)
      LineResult("correct:" + line, true)
    else
      LineResult("error:" + line, false)
  }
}