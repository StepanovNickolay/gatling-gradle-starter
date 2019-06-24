package scenarios

import _root_.configuration.Environment
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

trait RequestBase extends Environment {

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(baseUrl)
    .userAgentHeader("Gatling!")

  val httpProtocolWithResources: HttpProtocolBuilder = http
    .baseUrl(baseUrl)
    .userAgentHeader("Gatling!")
    .inferHtmlResources()

}