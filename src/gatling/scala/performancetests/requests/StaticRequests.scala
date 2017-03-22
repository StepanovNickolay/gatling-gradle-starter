package performancetests.requests

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import performancetests.scenarios.RequestBase

trait StaticRequests extends RequestBase {

  val openHomePage: ChainBuilder =
    exec(
      get("Open homepage", "/")
        .check(status.is(200))
    ).exitHereIfFailed

}
