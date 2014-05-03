import sbt._
import Keys._

object NHK4SProject extends Build {

  lazy val root = Project("root", file("."), settings = mainSettings)

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    organization := "com.github.seratch",
    name := "nhk4s",
    version := "0.1.2",
    scalaVersion := "2.10.3",
    // TODO waiting for json4s
    //crossScalaVersions := Seq("2.11.0", "2.10.3"),
    crossScalaVersions := Seq("2.10.3"),
    resolvers ++= Seq(
      "sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
      "sonatype snaphots" at "http://oss.sonatype.org/content/repositories/snapshots"
    ),
    libraryDependencies ++= Seq(
      "joda-time"        %  "joda-time"       % "2.3",
      "org.joda"         %  "joda-convert"    % "1.6",
      "org.json4s"       %% "json4s-jackson"  % "3.2.8",
      "org.json4s"       %% "json4s-ext"      % "3.2.8",
      "org.scalatest"    %% "scalatest"       % "2.1.3"  % "test"
    ),
    publishTo <<= version { (v: String) => 
      val nexus = "https://oss.sonatype.org/"
      if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
      else Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    publishMavenStyle := true,
    sbtPlugin := false,
    transitiveClassifiers in Global := Seq(Artifact.SourceClassifier),
    incOptions := incOptions.value.withNameHashing(true),
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
          <name>Kazuhiro Sera</name>
          <url>http://seratch.net/</url>
        </developer>
      </developers>
  )

}

