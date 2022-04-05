Feature: register workhours
  Scenario: register hours successfully
    Given user input is valid - hours worked
    When workhours are inputted
    Then workhours are registered

  Scenario: register hours with invalid input
    Given user input is not valid - hours worked
#    When wrong workhours are inputted
#    Then workhours are not registered