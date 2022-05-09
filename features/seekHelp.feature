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

  Scenario: projectleader asks developmentemployee for assistance
    Given user is logged in as projectleader
    And projectleader has activity assigned
    And developmentemployee requested is available
    And co-worker requested is assigned to same project
    When projectleader asks for help
    And developmentemployee requested accepts
    Then developmentemployee helps with the activity

  Scenario: developmentemployee denies request for assistance
    Given user is logged in as projectleader
    And projectleader has activity assigned
    And developmentemployee requested is available
    And co-worker requested is assigned to same project
    When projectleader asks for help
    And developmentemployee requested denies
    Then developmentemployee is not put on activity

  Scenario: projectleader seeks help from developmentemployee from another project
    Given user is logged in as projectleader
    And projectleader has activity assigned
    And developmentemployee requested is available
    And co-worker requested is not assigned to same project
    When projectleader asks for help
    Then developmentemployee is not requested