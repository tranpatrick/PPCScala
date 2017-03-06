lazy val root = (project in file(".")).
  settings(
    name := "bach",
    version := "1.0",
    scalaVersion := "2.11.7"
  )
  


libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.0"
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.4.0"



