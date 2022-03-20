Feature: create project
  Scenario: user creates project successfully
    Given user is logged in as projectleader
    When project is created
    Then project is created and available

  Scenario: user is not authorized to create project
    Given user is not logged in as projectleader
    When project is created
    Then project is not created