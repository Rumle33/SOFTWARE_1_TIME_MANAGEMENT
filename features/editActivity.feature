Feature: edit start and deadline activity
#  Scenario: user successfully sets start and deadline for activity
#    Given user is logged in as projectleader
#    And input is valid - startDate "30/04/2022" endDate "30/05/2022"
#    When the start and deadline of the activity is set
#    Then the activity registers start and deadline
#
#  Scenario: user sets invalid input for start and deadline
#    Given user is logged in as projectleader
#    And input is invalid - wrong format - startDate "tredivte i femte" endDate "tredivte i sjette"
#    When the start and deadline of the activity is set
#    Then the activity does not register start and deadline
#
#  Scenario: user sets invalid input for start and deadline
#    Given user is logged in as projectleader
#    And input is invalid - date invalid - startDate "35/00/2019" endDate "00/14/2020"
#    When the start and deadline of the activity is set
#    Then the activity does not register start and deadline

  Scenario: deadline is before start, so inputs are invalid
    Given user is logged in as projectleader
    And input is invalid - deadline before start - startDate "14/07/2022" endDate "30/08/2022"
    When the start and deadline of the activity is set
    Then the activity registers start but not deadline
#
#  Scenario: user sets start and deadline unsuccessfully
#    Given user assigns start and deadline for activity
#    And user is not logged in as projectleader
#    When the start and deadline of the activity is set
#    Then the activity fails to register start and deadline