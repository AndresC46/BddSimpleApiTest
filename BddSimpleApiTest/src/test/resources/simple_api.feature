Feature: RestApiTests
  In order to validate sample REST API
  As a QA Automation
  I want to verify TodoItems using BDD Statements

  @myRest
  Scenario: TC01 Simple GET Request for TodoItems
    Given a "LOCAL" simpleAPI
    When I make a GET API request for "SimpleGetAPI"
    Then the response status code is "200"
    And the response data is an empty set