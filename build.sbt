name := "young-spark"
 
version := "1.0"
 
scalaVersion := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")
 
resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
                  "Maven Repository" at "http://repo1.maven.org/maven2/")
 
libraryDependencies ++=
{
     val spark_version = "1.5.1"
     val httpclient_version = "4.4.1"
     val xstream_version = "1.4.8"
     Seq(
         "org.apache.spark" %% "spark-core" % spark_version,
         "org.apache.spark" %% "spark-sql" % spark_version,
         "org.apache.spark" %% "spark-streaming" % spark_version,
         "org.apache.spark" %% "spark-mllib" % spark_version,
         "org.apache.spark" %% "spark-hive" % spark_version,
         "org.apache.spark" %% "spark-yarn" % spark_version,
         "org.apache.spark" %% "spark-repl" % spark_version,
         "org.apache.httpcomponents" % "httpclient" % httpclient_version,
         "org.apache.httpcomponents" % "httpcore" % httpclient_version,
         "com.thoughtworks.xstream" % "xstream" % xstream_version
         )
}