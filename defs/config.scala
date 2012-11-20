
// don't delete this ===>
import jp.co.nksol.letthempass._
implicit val env = new ConfigBuffer
// <=== don't delete this

val mx = List("bbb", "ccc")

//"aaa" ==> "bbb"
mx :+ "aaa" ==> mx

List("kida", "taro") ==> List("wada", "akiko")

// don't delete this  ===>
env
// <=== don't delete this
