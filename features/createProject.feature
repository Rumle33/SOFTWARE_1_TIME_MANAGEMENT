Feature: create project
  Scenario: project created successfully
    Given user is logged in as projectleader
    When project is created
    Then project is created and available

  Scenario: project creation failed
    Given user is not logged in as projectleader
    When project is created
    Then project is not created