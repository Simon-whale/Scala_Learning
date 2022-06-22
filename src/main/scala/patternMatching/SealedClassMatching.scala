package patternMatching

import Models.{ Furniture, Couch, Desk, Chair }

object SealedClassMatching extends App {
  def FindPlaceToSit(piece: Furniture): String =
    piece match {
      case a: Couch => "Lie on couch"
      case b: Chair => "Sit on Chair"
      // unless we have the default it will raise an exception on execution
      case _ => "Nothing to sit on"
    }

  val comfyChair = Chair()
  val niceSofa = Couch()
  val desk = Desk()

  println(FindPlaceToSit(comfyChair))
  println(FindPlaceToSit(niceSofa))
  println(FindPlaceToSit(desk))
}
