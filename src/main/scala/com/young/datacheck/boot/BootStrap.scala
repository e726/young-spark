package com.young.datacheck.boot

import com.young.datacheck.config.DataCheck
import com.young.datacheck.config.TaskParam
import com.young.datacheck.config.AuditInfo
import com.young.datacheck.config.AuditColumn
import com.young.datacheck.config.CheckFunction
import com.young.datacheck.config.CheckColumn
import com.young.datacheck.tools.XStreamTool

/**
 * @author dell
 */
object BootStrap {
  /**
   * processAnnotations(classOf[DataCheck])
  ,xstream.processAnnotations(classOf[TaskParam])
  ,xstream.processAnnotations(classOf[CheckFunction])
  ,xstream.processAnnotations(classOf[CheckColumn])
  ,xstream.processAnnotations(classOf[AuditColumn])
  ,xstream.processAnnotations(classOf[AuditInfo])
   */
  
  private val classes = Array(classOf[DataCheck],classOf[TaskParam],classOf[CheckFunction],classOf[CheckColumn],classOf[AuditColumn],classOf[AuditInfo])
  
  private val xstream = new XStreamTool[Any](true,classes)
  
  private def loadConfig(configFile:String,configFileLocal:Boolean=true):DataCheck = {
    if(configFileLocal){
      val DataCheck = 
    }
  }
}