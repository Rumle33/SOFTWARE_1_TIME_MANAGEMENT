Feature: register workhours
  Scenario: register hours successfully
    Given user is projectleader
    And user input is 2.5 - hours worked
    When workhours are inputted
    Then workhours are registered

  Scenario: register hours with invalid input
    Given user is projectleader
    And user input is "to komma fem" - hours worked
#    When wrong workhours are inputted
#    Then workhours are not registered

  Scenario: register hours successfully
    Given user is developmentemployee
    And user input is 2.5 - hours worked
    When 2.5 is inputted - Developmentemployee
    Then 2.5 hours are registered

  Scenario: register hours successfully
    Given user is developmentemployee
    And user input is "to komma fem" - hours worked
    When "to komma fem" is inputted
    Then print error message "Invalid input"