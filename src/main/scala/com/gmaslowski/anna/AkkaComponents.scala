package com.gmaslowski.anna

import akka.actor.ActorSystem

object AkkaComponents {

  trait Requires
    extends AnnaConfigurationComponents.Provides

  trait Provides {
    val system: ActorSystem
  }

  trait Default
    extends Provides
      with Requires {

    implicit val system: ActorSystem = ActorSystem(annaConfiguration.systemName)
  }
}
