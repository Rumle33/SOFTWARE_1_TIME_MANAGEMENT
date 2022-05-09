#Hákun

Feature: create project
  Scenario: developmentemployee creates project
    Given user is logged in as developmentemployee
    When developmentemployee creates project
    Then project is added to developmentemployees projectlist

  Scenario: projectleader creates project
    Given user is logged in as projectleader
    When projectleader creates project
    Then project is added to projectleaders projectlist

  Scenario: project already exists
    Given user is logged in as projectleader
    And project with the same name already exists
    When project with the same name "Project" is created
    Then project fails to get created, because project already exists

  Scenario: project already exists
    Given user is logged in as developmentemployee
    And dev has a project with the same name
    When project with the same name "Project" is created by dev
    Then project fails to get created, because dev already has project