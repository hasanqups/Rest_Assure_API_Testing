Feature: Put Request Go-Rest API


  @Put
  Scenario: Put Request GO-Rest API
    Given Update user to specific ID
    And Response body is
    And Response Message should "OK"
    And Name should be "Md Abir Abir"