package performancetests

import io.gatling.core.Predef._
import io.gatling.core.controller.inject.RampInjection
import performancetests.scenarios.{HomepageScenario, SearchScenario}

import scala.concurrent.duration._
import scala.language.postfixOps

class SearchSimulation extends Simulation with SearchScenario with HomepageScenario {

  val usersPerMinute = 1

  setUp(
    searchScn.inject(setupUsers(durationInMinutes, usersPerMinute, loadFactor))
    .protocols(httpProtocol)
  ).assertions(
    global.failedRequests.count.is(0),
    global.responseTime.percentile1.lessThan(500), // 50% of the calls
    global.responseTime.percentile3.lessThan(1000), // 95% of the calls
    global.responseTime.max.lessThan(3000) // all the calls
  )

  def setupUsers(minutes: Int, perMinute: Int, loadFactor: Double): RampInjection =
    rampUsers(Math.ceil(perMinute * minutes * loadFactor).toInt).over(minutes minutes)

}