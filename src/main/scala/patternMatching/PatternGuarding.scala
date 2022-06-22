package patternMatching

import Models.{ Notification, Email, SMS, VoiceRecording}

object PatternGuarding extends App {
  def showNotification(n: Notification): String = {
    n match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name!  Click the link to hear it: $link"
    }
  }

  def showImportantNotification(n: Notification, importantPeopleInfo: Seq[String]): String = {
    n match {
      case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
        "You got an email from someone special"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        "You got a message, you got a message from someone special!"
      case other =>
        showNotification(other)
    }
  }

  val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com", "07899123455", "jen@gmail.com")

  val someSms = SMS("123-4567", "Are you there?")
  val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
  val isItImportant = Email("jennifer@gmail.com", "hi", "what ya doing")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
  val importantSms = SMS("867-5309", "I'm here! Where are you?")

  println(showImportantNotification(someSms, importantPeopleInfo)) // prints You got an SMS from 123-4567! Message: Are you there?
  println(showImportantNotification(isItImportant, importantPeopleInfo))
  println(showImportantNotification(importantEmail, importantPeopleInfo)) // prints You got an email from special someone!
  println(showImportantNotification(someVoiceRecording, importantPeopleInfo)) // prints You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
  println(showImportantNotification(importantSms, importantPeopleInfo)) // prints You got an SMS from special someone!
}
