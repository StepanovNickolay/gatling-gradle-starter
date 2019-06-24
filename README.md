# Performance tests

Starter project for writing performance tests with Gatling, using Gradle as buildtool.

## Running locally
Simulations can be run locally using Gradle.
```./gradlew gatlingRun``` runs all simulations, ```./gradlew gatlingRun-SimpleSimulation``` runs the specific simulation.

## Gatling DSL
Gatling provides its own DSL to elegantly build tests. A few of the most important concepts are listed below. For more information, see the Gatling documentation: https://gatling.io/docs/current/

### Scenario's
A scenario contains at least one request. Typically, this is a HTTP request.

### Checks
Checks are used to validate responses, and to extract data from said responses.

### Simulations
A simulation can be seen as the actual test. It determines what scenario's should be run, and how many users should be simulated over the scenario's.

### Assertions
Asserts the outcomes of the simulation results.

### Expression language
In order to make tests data-driven, values can be made dynamic throughout requests. Gatling will substitute ```${value}``` with the actual value of the variable, if available. Value's can be injected into sessions through feeders or by extracting them from responses.

### Feeders
Feeders take data from various sources, and inject them into a session.

## Viewing reports
Reports get saved to the ```build/reports/gatling``` folder.
