Feature: create activity
  Scenario: activity is created
    Given user is logged in as projectleader
    When activity is created and added to project
    And activity is not vacation or alike
    Then activity is available in project

  Scenario: personal activity is added to employee
    Given user is logged in as projectleader
    When projectleader creates activity for user
    And activity is vacation or alike
    Then activity is created and added to employee

#  Scenario: activity is created unsuccessfully
#    Given user is logged in as developmentemployee, test 1
#    When activity is created
#    And activity is not vacation or alike
#    Then activity fails to get created, because user is unauthorized

  Scenario: personal activity is added to user
    Given user is logged in as developmentemployee
    When personal activity is created
    And activity is vacation or alike
    Then activity is created and added to users activitylist

  Scenario: activity already exists in project
    Given user is logged in as projectleader
    And activity with the same name already exists in project
    When activity with the same name "Activity" is created
    Then activity fails to get created, because activity already exists
