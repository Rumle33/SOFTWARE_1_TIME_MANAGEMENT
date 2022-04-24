# Anders

Feature: seek help
  Scenario: Employee seeks help from another worker
    Given user is employee
    And user has activity assigned
    And co-worker requested is available
    When user asks for help
    Then co-worker helps with the activity

  Scenario: Employee without activities seeks help from another worker
    Given user is employee
    And user does not have activity assigned
    When user asks for help
    Then user request is denied

  Scenario: Employee seeks help from another worker, whom is not available
    Given user is employee
    And user has activity assigned
    And user requested is not available
    When user asks for help
    Then user request is denied
