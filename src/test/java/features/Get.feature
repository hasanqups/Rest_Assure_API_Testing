Feature: Get Request Go-Rest API

@Get
Scenario: Get Request GO-Rest API
  Given user wants to get all information
  And response 200 should be received
  And name should be "Md Ausssl khan"
  And email should be "abul@bsabssusls.com"
  Then gender should be "male"