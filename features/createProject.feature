Feature: create project
  Scenario: user creates project successfully
    Given user is logged in as projectleader
    When project is created, Casper
    Then project is added to users projectlist, Casper

  Scenario: user is not authorized to create project
    Given user is logged in as developmentemployee
    When project is created, Jens
    Then project is added to users projectlist, Jens