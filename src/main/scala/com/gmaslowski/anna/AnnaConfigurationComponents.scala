package com.gmaslowski.anna

import com.typesafe.config.{Config, ConfigFactory}

object AnnaConfigurationComponents {

  trait Provides {
    def config: Config
    def annaConfiguration: AnnaConfiguration
  }

  trait Default
    extends Provides {

    import com.github.andr83.scalaconfig._

    override lazy val config: Config = ConfigFactory.load()
    override lazy val annaConfiguration: AnnaConfiguration = config.as[AnnaConfiguration]("anna")
  }

}
