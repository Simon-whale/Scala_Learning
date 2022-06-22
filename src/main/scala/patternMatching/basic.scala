package patternMatching

import scala.util.Random

object basic extends App {
  def convertToWord(value: Int): String = {
    value match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case _ => "other"
    }
  }

  println(convertToWord(Random.nextInt(3)))
  println(convertToWord(Random.nextInt(44)))
}
