Feature: remove activity
  Scenario: projectleader removes activity
    Given user is logged in as projectleader
    And activity with the same name already exists in project
    And developmentemployee is assigned to activity
    When projectleader removes activity
    Then activity is removed from all users assigned, and no longer available