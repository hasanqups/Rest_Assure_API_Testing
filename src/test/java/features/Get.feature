Feature: Get Request Go-Rest API

@Get
Scenario: Get Request GO-Rest API
  Given user wants to get all information
  And response 200 should be received
  And name should be "Aagam Kakkar DC"
  And email should be "kakkar_dc_aagam@crooks.com"
  Then gender should be "male"