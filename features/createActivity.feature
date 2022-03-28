#Feature: create activity
#  Scenario: activity is created successfully
#    Given user is logged in as projectleader
#    And activity is not vacation or alike
#    When activity is created
#    Then activity is added to project
#
#  Scenario: activity is created successfully
#    Given user is logged in as projectleader
#    And activity is vacation or alike
#    When activity is created
#    Then activity is
#
#  Scenario: activity is created successfully
#    Given user is not logged in as projectleader
#    And activity is not vacation or alike
#    When activity is created
#    Then activity fails to get created
#
#  Scenario: activity is created successfully
#    Given user is not logged in as projectleader
#    And activity is vacation or alike
#    When activity is created
#    Then activity fails to get created