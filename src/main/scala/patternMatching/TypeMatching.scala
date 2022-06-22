package patternMatching

import Models.{Computer, Device, Phone, Watch}

object TypeMatching extends App {
  def goIdle(device: Device) = device match {
    case p: Phone => p.ScreenOff
    case c: Computer => c.screenSaverOn
    // If you pass something that doesn't get matched it will
    // throw an exception unless you add a catch ALL
    case _ => "Nothing to see here"
  }

  val phone = Phone("Samsung")
  val pc = Computer("Microsoft Surface")
  val watch = Watch("Pebble")

  println(goIdle(phone))
  println(goIdle(pc))
  println(goIdle(watch))
}
