package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import requests.StaticRequests

trait HomepageScenario extends StaticRequests {

  val homeScn: ScenarioBuilder = scenario("Open homepage")
    .group("Open homepage") {
      exec(
        openHomePage
      )
    }
}
