Feature: Assign work
  Scenario: work assigned successfully
    Given user is logged in as projectleader
    And co-worker is assigned to project
    And co-worker is available
    When co-worker is assigned to activity
    Then then the co-worker is assigned :)

  Scenario: co-worker not assigned on project
    Given user is logged in as projectleader
    And co-worker is not assigned to project
    When co-worker is assigned to activity
    Then print error message "co-worker not assigned to project"

  Scenario: co-worker is not available
    Given user is logged in as projectleader
    And co-worker is not available
    When co-worker is assigned to activity
    Then print error message "co-worker not available"

  Scenario: user is not projectleader
    Given user is not projectleader
    And co-worker is not available
    When co-worker is assigned to activity
    Then print error message "co-worker not available"