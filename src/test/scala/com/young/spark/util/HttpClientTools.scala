package com.young.spark.util

import org.apache.http.impl.client.HttpClients
import org.apache.http.client.methods.HttpGet
import org.apache.commons.io.IOUtils
import java.io.FileOutputStream

/**
 * @author Administrator
 */
object HttpClientTools {
  def get(url:String,to:String)={
    val http = HttpClients.createDefault()
    val get = new HttpGet(url)
    val response = http.execute(get)
    IOUtils.copy(response.getEntity.getContent, new FileOutputStream(to))
  }
  def main(args: Array[String]): Unit = {
    val fromUrl = "http://www.apache.org"
    val to = "E:\\data\\spark\\wordcount.txt"
    HttpClientTools.get(fromUrl, to)
  }
}