
package jp.co.nksol.letthempass {

import com.twitter.util.Eval

object Letthempass extends App {
  val configEnv = (new Eval).apply[ConfigEnv](new java.io.File("defs/config.scala"))
  configEnv.buffer foreach { println _ }

}

trait ConfigEnv {
  val buffer = collection.mutable.ListBuffer.empty[(String, String)]

  def register(from: String, to: String): Unit
}

class ConfigBuffer extends ConfigEnv {
  def register(from: String, to: String) {
    buffer += (from -> to)
  }
}

class ConfigRepl extends ConfigEnv {
  def register(from: String, to: String) {
    println("%s ==> %s".format(from, to))
  }
}

case class Entry(from: String) {
  def expand(str: String) = {
    List(str)
  }

  val expanded = expand(from)

  def ==>(to: String)(implicit configEnv: ConfigEnv) {
  	expanded foreach { configEnv.register(_, to) }
  }

  def ==>(tos: List[String])(implicit configEnv: ConfigEnv) {
  	for(f <- expanded; to <- tos; val xtos = expand(to); xto <- xtos) {
      configEnv.register(f, xto)
  	}
  }
}

}

package jp.co.nksol {
package object letthempass {
  implicit def string2entry(from: String) = Entry(from)
  implicit def stringList2entry(froms: List[String]) = Entry(froms.mkString("{", ",", "}"))
}
}
