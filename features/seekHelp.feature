# Anders

Feature: seek help
  Scenario: Employee seeks help from another worker
    Given user is employee
    And user has activity assigned
    And co-worker requested is available
    And co-worker requested is assigned to same project
    When user asks for help
    And co-worker requested accepts
    Then co-worker helps with the activity

  Scenario: Employee without activities seeks help from another worker
    Given user is employee
    And user does not have activity assigned
    When user asks for help
    Then co-worker is not requested

  Scenario: Employee seeks help from another worker, whom is not available
    Given user is employee
    And user has activity assigned
    And user requested is not available
    When user asks for help
    Then co-worker is not requested

  Scenario: Employee seeks help from another worker from another project
    Given user is employee
    And user has activity assigned
    And co-worker requested is available
    And co-worker requested is not assigned to same project
    When user asks for help
    Then co-worker is not requested

  Scenario: Employee seeks help from another worker, but co-worker denies
    Given user is employee
    And user has activity assigned
    And co-worker requested is available
    And co-worker requested is assigned to same project
    When user asks for help
    And co-worker requested denies
    Then co-worker is not put on the requested activity