Feature: create project
  Scenario: developmentemployee creates project
    Given user is logged in as developmentemployee
    When developmentemployee creates project
    Then project is added to developmentemployees projectlist

  Scenario: projectleader creates project
    Given user is logged in as projectleader
    When projectleader creates project
    Then project is added to projectleaders projectlist