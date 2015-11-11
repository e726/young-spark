package com.young.datacheck

import com.young.datacheck.config.DataCheck
import com.thoughtworks.xstream.XStream
import com.young.datacheck.config.AuditInfo
import com.young.datacheck.config.TaskParam
import com.young.datacheck.config.CheckFunction
import com.young.datacheck.config.CheckFunction
import com.young.datacheck.config.AuditColumn
import com.young.datacheck.config.CheckColumn
import com.young.datacheck.config.AuditColumn
import com.young.datacheck.tools.XStreamTool
import java.io.FileOutputStream
import java.io.FileInputStream
import java.io.File

/**
 * @author Administrator
 */
object BeanTest {
  
  val file = "E:\\data\\spark\\check.xml"
  
  def writeConfig={
    val taskParam = new TaskParam(true, ",", ":", 10, "correct", "error")
    var checkFunctions = for(i<-1 to 10) yield new CheckFunction("funcFormula_"+i,"columnJavaType_"+i,"checkType_"+i,"checkerClassName_"+i,"level_"+i)
    val auditColumn = new AuditColumn(0,"column_0",new CheckColumn(checkFunctions.toArray))
    var auditColumns = Array[AuditColumn](auditColumn)
    val auditInfo = new AuditInfo(taskParam,auditColumns)
    val check = new DataCheck("taskId_1","checkName_1",auditInfo)
    XStreamTool.toXMLOutput(check, new FileOutputStream(file))
    println(XStreamTool.toXML(check))
  }
  
  def readConfig={
    val check:DataCheck = XStreamTool.fromXML(new FileInputStream(file)).asInstanceOf[DataCheck]
    println(check.auditInfo.checkColumns(0).check.checks(0).checkerClassName)
  }
  def main(args: Array[String]): Unit = {
    writeConfig
    readConfig
  }
}