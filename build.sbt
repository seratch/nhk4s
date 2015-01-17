lazy val root = (project in file("."))
  .settings(
    organization := "com.github.seratch",
    name := "nhk4s",
    version := "1.0.0",
    scalaVersion := "2.11.5",
    crossScalaVersions := Seq("2.11.4", "2.10.5"),
    resolvers += "sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
    libraryDependencies ++= Seq(
      "joda-time"        %  "joda-time"       % "2.7",
      "org.joda"         %  "joda-convert"    % "1.7",
      "org.json4s"       %% "json4s-jackson"  % "3.2.11",
      "org.json4s"       %% "json4s-ext"      % "3.2.11",
      "org.scalatest"    %% "scalatest"       % "2.2.3"  % "test"
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
  ).settings(scalariformSettings: _*)
   .settings(sonatypeSettings: _*)
   .settings(net.virtualvoid.sbt.graph.Plugin.graphSettings: _*)

