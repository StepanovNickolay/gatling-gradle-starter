package performancetests.scenarios

import performancetests.Environment
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.http.request._
import io.gatling.http.request.builder.HttpRequestBuilder

trait RequestBase extends Environment {

  val httpProtocol: HttpProtocolBuilder = http
    .baseURL(baseUrl)
    .userAgentHeader("Gatling!")

  val httpProtocolWithResources: HttpProtocolBuilder = http
    .baseURL(baseUrl)
    .userAgentHeader("Gatling!")
    .inferHtmlResources()

  def get(name: String, url: String): HttpRequestBuilder =
    http(name)
      .get(url)
      .extraInfoExtractor(ExtraInfo => {
          println("URL: "+ ExtraInfo.request.getUrl)
        Nil
      })

  def post(name: String, url: String): HttpRequestBuilder =
    http(name)
      .post(url)
      .extraInfoExtractor(extraFailureInfo)

  def put(name: String, url: String): HttpRequestBuilder =
    http(name)
      .put(url)
      .extraInfoExtractor(extraFailureInfo)



  def extraFailureInfo: ExtraInfoExtractor = { extraInfo =>
    extraInfo.status match {
      case io.gatling.commons.stats.OK => List(extraInfo.request)
      case io.gatling.commons.stats.KO => List(extraInfo.request)
      case _ => List(extraInfo.request)
    }
  }

}