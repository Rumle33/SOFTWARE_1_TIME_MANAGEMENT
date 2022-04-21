#Feature: register workhours
#  Scenario: register hours successfully
#    Given user inputs hours worked
#    And input is valid
#    When workhours are inputted
#    Then workhours are registered
#
#  Scenario: register hours with invalid input
#    Given user inputs hours worked
#    And input is invalid
#    When workhours are inputted
#    Then workhours are not registered

  Scenario: register hours successfully
    Given user is developmentemployee
    And user input is valid - hours worked
    When workhours are inputted
    Then workhours are registered

  Scenario: register hours successfully
    Given user is developmentemployee
    And user input is valid - hours worked
    When workhours are inputted
    Then workhours are registered