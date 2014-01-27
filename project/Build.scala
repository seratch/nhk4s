import sbt._
import Keys._

object NHK4SProject extends Build {

  lazy val root = Project("root", file("."), settings = mainSettings)

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    organization := "com.github.seratch",
    name := "nhk4s",
    version := "0.1.2",
    scalaVersion := "2.10.3",
    libraryDependencies ++= Seq(
      "joda-time"        %  "joda-time"       % "2.3",
      "org.joda"         %  "joda-convert"    % "1.5",
      "org.json4s"       %% "json4s-jackson"  % "3.2.6",
      "org.json4s"       %% "json4s-ext"      % "3.2.6",
      "org.scalatest"    %% "scalatest"       % "1.9.2"  % "test"
    ),
    publishTo <<= version { (v: String) => 
      val nexus = "https://oss.sonatype.org/"
      if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
      else Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    publishMavenStyle := true,
    sbtPlugin := false,
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { x => false },
    pomExtra := <url>https://github.com/seratch/nhk4s</url>
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:seratch/nhk4s.git</url>
        <connection>scm:git:git@github.com:seratch/nhk4s.git</connection>
      </scm>
      <developers>
        <developer>
          <id>seratch</id>
          <name>Kazuhuiro Sera</name>
          <url>http://seratch.net/</url>
        </developer>
      </developers>
  )

}

