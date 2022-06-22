package Models

case class Watch(model: String) extends Device {
  def shutDown = "Turning Off - This should return anything"
}
