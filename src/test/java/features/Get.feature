Feature: Get Request Go-Rest API

@Get
Scenario: Get Request GO-Rest API
  Given user wants to get all information
  And response 200 should be received
  And name should be "Mohan Naik"
  And email should be "naik_mohan@cummerata.net"
  Then gender should be "female"