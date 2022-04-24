Feature: register workhours
  Scenario: register hours successfully
    Given user is projectleader
    And user input is valid - 2.5
    When 2.5 is inputted
    Then 2.5 is registered

  Scenario: register hours with invalid input
    Given user is projectleader
    And user input is invalid - "to komma fem"
    When "to komma fem" is inputted
    Then nothing is not registered

  Scenario: register hours successfully
    Given user is developmentemployee
    And user input is valid - 2.5
    When 2.5 is inputted - Developmentemployee
    Then 2.5 is registered

  Scenario: register hours successfully
    Given user is developmentemployee
    And user input is invalid - "to komma fem"
    When "to komma fem" is inputted - Developmentemployee
    Then nothing is not registered