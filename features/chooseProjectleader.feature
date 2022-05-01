#Christian
Feature: choose Projectleader
  Scenario: projectleader is chosen successfully
    Given user is developmentemployee
    And chosen employee is developmentemployee
    When developmentemployee is chosen
    Then developmentemployee is projectleader
    And employee has same initials

  Scenario: invalid input for choosing projectleader
    Given user is not a developmentemployee
    And chosen employee is not a developmentemployee
    Then developmentemployee isnt projectleader