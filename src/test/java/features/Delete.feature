Feature: Delete Request in GoRest API


  @Delete
  Scenario: Delete Request in GORest API
    Given Delete user to specific ID
    And Response Message should Return "No Content"