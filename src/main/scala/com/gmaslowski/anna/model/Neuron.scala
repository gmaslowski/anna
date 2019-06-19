package com.gmaslowski.anna.model

import akka.actor.{Actor, ActorLogging, Props}

object Neuron {
  def props = Props(classOf[Neuron])
}

class Neuron
  extends Actor
    with ActorLogging {

  override def receive: Receive = {
    case AnyRef => log.info("message")
  }
  
}
