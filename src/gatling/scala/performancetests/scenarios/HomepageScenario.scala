package performancetests.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import performancetests.requests.StaticRequests

trait HomepageScenario extends StaticRequests {

  val homeScn: ScenarioBuilder = scenario("Open homepage")
    .group("Open homepage") {
      exec(
        openHomePage
      )
    }
}
