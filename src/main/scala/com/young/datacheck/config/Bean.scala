package com.young.datacheck.config

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection
import scala.beans.BeanProperty
import com.thoughtworks.xstream.annotations.XStreamImplicit
import com.thoughtworks.xstream.annotations.XStreamAsAttribute
/**
 * @author Administrator
 */
@BeanProperty
@XStreamAlias("datacheck")
@XStreamImplicit(itemFieldName = "auditInfo")
case class DataCheck(taskId: String, checkName: String,auditInfo:AuditInfo)
@BeanProperty
@XStreamAlias("taskparam")
case class TaskParam(isCounter: Boolean, inputSplitPattern: String, outputSplitPattern: String, splitLimit: Int, correntOutput: String, errorOutput: String)
@BeanProperty
@XStreamAlias("checkfunction")
case class CheckFunction(funcFormula:String,columnJavaType:String,checkType:String,checkerClassName:String,checkLevel:String)
@BeanProperty
@XStreamAlias("checkcolumn")
@XStreamImplicit(itemFieldName = "checks")
case class CheckColumn(checks:Array[CheckFunction])
@BeanProperty
@XStreamAlias("auditcolumn")
@XStreamImplicit(itemFieldName = "check")
case class AuditColumn(columnIndex:Int,columnName:String,check:CheckColumn)
@BeanProperty
@XStreamAlias("auditinfo")
@XStreamImplicit(itemFieldName = "checkColumns")
case class AuditInfo(taskParam: TaskParam,checkColumns:Array[AuditColumn])