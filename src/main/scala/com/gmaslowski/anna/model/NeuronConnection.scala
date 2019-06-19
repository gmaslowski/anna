package com.gmaslowski.anna.model

import akka.actor.{Actor, ActorLogging, ActorRef, Props}

import scala.util.Random

object NeuronConnection {
  def props(from: ActorRef, to: ActorRef) = Props(classOf[NeuronConnection], from, to, randomWeight)

  def randomWeight = Random.nextDouble()
}

class NeuronConnection(val from: ActorRef, val to: ActorRef, val weight: Double)
  extends Actor
    with ActorLogging {

  override def receive: Receive = {
    case AnyRef => log.info("message")
  }

}
