#Anders

#Feature: Assign work
#  Scenario: work assigned successfully
#    Given user is projectleader
#    And co-worker is assigned to same project as leader
#    And co-worker is available
#    When co-worker is assigned to activity
#    Then the co-worker is assigned

#  Scenario: co-worker not assigned on project
#    Given user is projectleader
#    And co-worker is not assigned to project
#    When co-worker is assigned to activity
#    Then print error message "co-worker not assigned to project"

#  Scenario: co-worker is not available
#    Given user is logged in as projectleader
#    And co-worker is not available
#    When co-worker is assigned to activity
#    Then print error message "co-worker not available"

#  Scenario: user is not projectleader
#    Given user is not projectleader
#    When co-worker is assigned to activity
#    Then print error message "co-worker not available"