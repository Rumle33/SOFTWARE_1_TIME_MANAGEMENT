Feature: register workhours
  Scenario: register hours successfully
    Given user inputs hours worked
    And input is valid
    When hours are inputted
    Then workhours are registered

  Scenario: register hours with invalid input
    Given user inputs hours worked
    And input is invalid
    When hours are inputted
    Then workhours are not registered