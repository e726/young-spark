package com.young.datacheck.tools

import java.io.InputStream
import java.net.URI

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path

/**
 * @author Administrator
 */
class HDFSTool(hdfsUrl: String, hadoopUser: String) {

  private val fileSystem = FileSystem.get(URI.create(hdfsUrl), new Configuration(), hadoopUser)

  def put(localPath: String, hdfsPath: String, delLocalPath: Boolean = false, overwrite: Boolean = false) {
    fileSystem.copyFromLocalFile(delLocalPath, overwrite, new Path(localPath), new Path(hdfsPath))
  }

  def readHdfsFile(hdfsFile: String, encode: String = "utf-8"): String = {
    FileUtil.readFile(getStream(hdfsFile), encode, "\n")
  }

  def getStream(hdfsFile: String): InputStream = {
    val inputStream = fileSystem.open(new Path(hdfsFile))
    inputStream
  }

}