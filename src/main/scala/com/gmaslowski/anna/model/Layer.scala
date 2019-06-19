package com.gmaslowski.anna.model

import akka.actor.{Actor, ActorLogging, ActorRef, Props}

// @formatter:OFF
sealed trait LayerDefinition { val count, neurons: Int }
case class InputLayerDefinition(neurons: Int) extends LayerDefinition { val count = 1 }
case class OutputLayerDefinition(neurons: Int) extends LayerDefinition { val count = 1 }
case class HiddenLayersDefinition(count: Int, neurons: Int) extends LayerDefinition
// @formatter:ON

object Layer {
  def props(neuronCount: Int) = Props(classOf[Layer], neuronCount)
}

class Layer(val neuronCount: Int)
  extends Actor
    with ActorLogging {

  var neurons: List[ActorRef] = List()

  override def preStart(): Unit = {
    neurons = List.range(0, neuronCount).map(i => context.system.actorOf(Neuron.props, s"${self.path.name}-neuron-$i"))
  }

  override def receive: Receive = {
    case AnyRef => log.info("message")
  }
}
