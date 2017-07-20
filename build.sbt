val dispatchVersion = "0.12.0"

lazy val myproject = (project in file("."))
   .enablePlugins(ScalaxbPlugin)
   .settings(
      name := "ScalaXBPoc",
      version := "1.0",
      scalaVersion := "2.11.8",
      libraryDependencies ++= Seq(
         "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
         "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6",
         "net.databinder.dispatch" %% "dispatch-core" % dispatchVersion
      ),
      scalaxbDispatchVersion in (Compile, scalaxb) := dispatchVersion,
      scalaxbPackageName in (Compile, scalaxb) := "com.abhi.hotelrewards.service",
      scalaxbAsync in (Compile, scalaxb) := true,
      sourceGenerators in Compile <+= scalaxb in Compile
   )