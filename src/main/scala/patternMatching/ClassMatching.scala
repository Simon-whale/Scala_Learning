package patternMatching

import Models.{ Notification, Email, SMS, VoiceRecording}

object ClassMatching extends App {
  def showNotification(n: Notification): String = {
    n match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name!  Click the link to hear it: $link"
      case _ => "Nothing to see here people"
    }
  }

  val someSms = SMS("12345","Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms))
  println(showNotification(someVoiceRecording))
}
