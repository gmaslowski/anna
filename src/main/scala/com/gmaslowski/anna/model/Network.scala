package com.gmaslowski.anna.model

import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object Network {
  def props(inputLayerSize: LayerDefinition, hiddenLayerSize: LayerDefinition, outputLayerSize: LayerDefinition) =
    Props(classOf[Network], inputLayerSize, hiddenLayerSize, outputLayerSize)
}

class Network(val inputLayerSize: LayerDefinition, val hiddenLayerSize: LayerDefinition, val outputLayerSize: LayerDefinition)
  extends Actor
    with ActorLogging {

  var inputLayer: ActorRef = ActorRef.noSender
  var outputLayer: ActorRef = ActorRef.noSender
  var hiddenLayers: List[ActorRef] = List()

  override def preStart() = {
    inputLayer = context.system.actorOf(Layer.props(inputLayerSize.neurons), s"${context.self.path.name}-inputLayer")
    outputLayer = context.system.actorOf(Layer.props(outputLayerSize.neurons), s"${context.self.path.name}-outputLayer")
    hiddenLayers = List.range(0, hiddenLayerSize.count).map(i => context.system.actorOf(Layer.props(hiddenLayerSize.neurons), s"hiddenLayer-$i"))
  }

  override def receive: Receive = {
    case AnyRef => log.info("message")
  }
}
