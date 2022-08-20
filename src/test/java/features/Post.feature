Feature: Post Request Go-Rest API


  @Post
  Scenario: Post Request GO-Rest API
    Given Post user into Go Rest API
    And Response body
    And Response Message should be "Created"
    And Name should be string "Md Mojibur khan"
    Then Email shoud be String "mojibur@khanss.com"