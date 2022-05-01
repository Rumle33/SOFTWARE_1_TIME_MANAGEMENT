# Anders

Feature: assign expected workhours
  Scenario: projectleader assigns expected workhours
    Given user is projectleader
    When user assigns expected workhours 9
    Then 9 workhours are assigned on activity

  Scenario: user fails to assign expected workhours
    Given user is not projectleader
    Then 2 workhours are not assigned