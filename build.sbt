organization := "com.gmaslowski"
name := "anna"

scalaVersion := "2.12.8"

val akkaV = "2.5.22"
val logbackV = "1.2.3"
val scalaconfV = "0.3"

libraryDependencies ++= Seq(
  // akka
  "com.typesafe.akka" %% "akka-actor" % akkaV,
  "com.typesafe.akka" %% "akka-slf4j" % akkaV,
  "com.typesafe.akka" %% "akka-stream" % akkaV,

  // scalaconf
  "com.github.andr83" %% "scalaconfig" % scalaconfV,

  // logging
  "ch.qos.logback" % "logback-classic" % logbackV
)
