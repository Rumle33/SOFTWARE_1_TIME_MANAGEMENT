Feature: assign expected workhours
  Scenario: projectleader assigns expected workhours
    Given user is logged in as projectleader
    When user assigns expected workhours
    Then expected workhours are added and available on activity

  Scenario: user fails to assign expected workhours
    Given user is not logged in as projectleader
    When user assigns expected workhours
    Then expected workhours are not added to the activity