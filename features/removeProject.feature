Feature: remove project
  Scenario: project is removed
    Given user is logged in as projectleader
    And projectleader has project assigned
    And developmentemployee is assigned to project
    When project is removed
    Then project is removed from all users assigned, and no longer available