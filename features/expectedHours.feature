Feature: assign expected workhours
  Scenario: projectleader assigns expected workhours
    Given user is projectleader
    When user assigns expected workhours 9
    Then 9 workhours are added on activity
    And 9 workhours are available on activity

  Scenario: user fails to assign expected workhours
    Given user is not projectleader
    When user assigns expected workhours
    Then expected workhours are not added to the activity