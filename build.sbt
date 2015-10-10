lazy val root = (project in file("."))
  .settings(
    organization := "com.github.seratch",
    name := "nhk4s",
    version := "1.1.0",
    scalaVersion := "2.11.7",
    crossScalaVersions := Seq("2.11.7", "2.10.6"),
    resolvers += "sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
    libraryDependencies ++= Seq(
      "joda-time"        %  "joda-time"       % "2.8.2",
      "org.joda"         %  "joda-convert"    % "1.8.1",
      "org.json4s"       %% "json4s-jackson"  % "3.3.0",
      "org.json4s"       %% "json4s-ext"      % "3.3.0",
      "org.scalatest"    %% "scalatest"       % "2.2.5"  % "test"
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
   .settings(net.virtualvoid.sbt.graph.Plugin.graphSettings: _*)

