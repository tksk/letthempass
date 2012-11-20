
name := "letthempass"

organization := "jp.co.nksol"

resolvers += "T repo" at "http://maven.twttr.com/"

libraryDependencies ++= Seq(
  "com.twitter" % "util-eval" % "5.3.13",
  "com.github.scopt" %% "scopt" % "2.1.0",
  "log4j" % "log4j" % "1.2.17"
)

initialCommands := "import jp.co.nksol.letthempass._; implicit val env = new ConfigRepl"
