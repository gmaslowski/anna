package com.gmaslowski.anna.bootstrap

import akka.actor.Props
import com.gmaslowski.anna.model.{HiddenLayersDefinition, InputLayerDefinition, Network, OutputLayerDefinition}
import com.gmaslowski.anna.{AkkaComponents, AnnaConfigurationComponents}

object Application
  extends App
    with AnnaConfigurationComponents.Default
    with AkkaComponents.Default {

  private val networkProps: Props = Network.props(
    InputLayerDefinition(7),
    HiddenLayersDefinition(4, 12),
    OutputLayerDefinition(3)
  )

  system.actorOf(networkProps, "ann-network")

}