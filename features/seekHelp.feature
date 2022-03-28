#Feature: seek help
#  Scenario: worker seeks help from another worker
#    Given user is not logged in as projectleader
#    And user has activity assigned
#    And user requested is available
#    When user asks for help
#    Then user asked for help, helps with the activity
#
#  Scenario: projectleader seeks help from another worker
#    Given user is logged in as projectleader
#    And user has activity assigned
#    And user requested is available
#    When user asks for help
#    Then user asked for help, helps with the activity
#
#  Scenario: worker without activities seeks help from another worker
#    Given user is not logged in as projectleader
#    And user does not have activity assigned
#    And user requested is available
#    When user asks for help
#    Then user request is denied
#
#  Scenario: projectleader without activities seeks help from another worker
#    Given user is logged in as projectleader
#    And user does not have activity assigned
#    And user requested is available
#    When user asks for help
#    Then user request is denied
#
#  Scenario: worker seeks help from another worker, whom is not available
#    Given user is not logged in as projectleader
#    And user has activity assigned
#    And user requested is not available
#    When user asks for help
#    Then user request is denied
#
#  Scenario: projectleader seeks help from another worker, whom is not available
#    Given user is logged in as projectleader
#    And user has activity assigned
#    And user requested is not available
#    When user asks for help
#    Then user request is denied