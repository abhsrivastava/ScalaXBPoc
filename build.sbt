val dispatchVersion = "0.11.3"

lazy val myproject = (project in file("."))
   .enablePlugins(ScalaxbPlugin)
   .settings(
      name := "ScalaXBPoc",
      version := "1.0",
      scalaVersion := "2.11.8",
      libraryDependencies ++= Seq(
         "org.scala-lang" % "scala-xml" % "2.11.0-M4",
         "org.scala-lang" % "scala-parser-combinators" % "2.11.0-M4",
         "net.databinder.dispatch" % "dispatch-core_2.11" % dispatchVersion
      ),
      scalaxbDispatchVersion in (Compile, scalaxb) := dispatchVersion,
      scalaxbPackageName in (Compile, scalaxb) := "com.abhi.hotelrewards.service",
      scalaxbAsync in (Compile, scalaxb) := true,
      sourceGenerators in Compile <+= scalaxb in Compile
   )