Feature: choose projectleader
  Scenario: projectleader is chosen successfully
    Given user votes for another user
    And input is valid
    When user votes
    Then vote is registered

  Scenario: invalid input for vote
    Given user votes for another user
    And input is invalid
    When user votes
    Then vote is not registered