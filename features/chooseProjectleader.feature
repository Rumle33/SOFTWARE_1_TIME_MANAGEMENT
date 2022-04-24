#Christian
Feature: choose Projectleader
  Scenario: projectleader is chosen successfully
    Given user is developmentemployee
    And chosen employee is developmentemployee
    When developmentemployee is chosen
    Then developmentemployee is projectleader
    And employee has same initials

  Scenario: invalid input for vote
    Given user is not a developmentemployee
    And chosen employee is not a developmentemployee
    When developmentemployee is not chosen
    Then developmentemployee isnt projectleader