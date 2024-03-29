package com.young.datacheck.tools

import java.io.InputStream
import java.io.OutputStream

import com.thoughtworks.xstream.XStream
import com.young.datacheck.config.AuditColumn
import com.young.datacheck.config.AuditInfo
import com.young.datacheck.config.CheckColumn
import com.young.datacheck.config.CheckFunction
import com.young.datacheck.config.DataCheck
import com.young.datacheck.config.TaskParam
import java.lang.{Class=>JClass}

/**
 * @author Administrator
 * 用来解析检核配置文件
 */
class XStreamTool[A <: AnyRef](autodetectAnnotations:Boolean,classes:Array[Class[A]]) {
  val xstream = new XStream
  xstream.autodetectAnnotations(autodetectAnnotations)
  for(clazz<-classes){
    xstream.processAnnotations(clazz)
  }
  /**
   * 将对象转换成xml字符串
   */
  def toXML(obj: Any): String = xstream.toXML(obj)
  /**
   * 将对象写入OutputStream中
   */
  def toXMLOutput(obj:Any,output:OutputStream) = xstream.toXML(obj, output)
  /**
   * 从InputStream中读取xml文件并转换成对象
   */
  def fromXML(input:InputStream):Any = xstream.fromXML(input)
  /**
   * 从xml字符串中解析对象
   */
  def fromXML(xml:String):Any = xstream.fromXML(xml)
}