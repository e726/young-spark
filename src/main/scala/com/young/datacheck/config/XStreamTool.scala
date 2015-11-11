package com.young.datacheck.config

import java.io.InputStream
import java.io.OutputStream
import com.thoughtworks.xstream.XStream
import scala.collection.mutable.ArrayBuffer

/**
 * @author Administrator
 */
object XStreamTool {
  val xstream = new XStream
  xstream.autodetectAnnotations(true)
  xstream.processAnnotations(classOf[DataCheck])
  xstream.processAnnotations(classOf[TaskParam])
  xstream.processAnnotations(classOf[CheckFunction])
  xstream.processAnnotations(classOf[CheckColumn])
  xstream.processAnnotations(classOf[AuditColumn])
  xstream.processAnnotations(classOf[AuditInfo])
  
  def toXML(obj: Any): String = xstream.toXML(obj)
  
  def toXMLOutput(obj:Any,output:OutputStream) = xstream.toXML(obj, output)
  
  def fromXML(input:InputStream):Any = xstream.fromXML(input)
  
  def fromXML(xml:String):Any = xstream.fromXML(xml)
}