#Christian

Feature: choose Projectleader
  Scenario: projectleader is chosen successfully
    Given user is developmentemployee
    And chosen employee is developmentemployee
    When developmentemployee is chosen
    Then developmentemployee becomes projectleader

#  Scenario: invalid input for vote
#    Given user votes for another user
#    And input is invalid
#    When user votes
#    Then vote is not registered