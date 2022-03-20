Feature: edit start and deadline activity
  Scenario: user successfully sets start and deadline for activity
    Given user assigns start and deadline for activity
    And user is logged in as projectleader
    And input is valid
    When the start and deadline of the activity is set
    Then the activity registers start and deadline

  Scenario: user sets invalid input for start and deadline
    Given user assigns start and deadline for activity
    And user is logged in as projectleader
    And input is invalid
    When the start and deadline of the activity is set
    Then the activity fails to register start and deadline

  Scenario: user sets start and deadline unsuccessfully
    Given user assigns start and deadline for activity
    And user is not logged in as projectleader
    When the start and deadline of the activity is set
    Then the activity fails to register start and deadline