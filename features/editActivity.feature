Feature: edit start and deadline activity
  Scenario: start and deadline set for activity successfully
    Given user assigns start and deadline for activity
    And user is logged in as projectleader
    And
    When the start and deadline of the activity is set
    Then the activity registers start and deadline

  Scenario: start and deadline set for activity successfully
    Given user assigns start and deadline for activity
    And user is logged in as projectleader
    When the start and deadline of the activity is set
    Then the activity registers start and deadline

  Scenario: start and deadline set for activity unsuccessfully
    Given user assigns start and deadline for activity
    And user is not logged in as projectleader
    When the activity´s start and deadline is set
    Then the activity fails to register start and deadline

  Scenario: start and deadline set for activity successfully
    Given user assigns start and deadline for activity
    And user is not logged in as projectleader
    When the start and deadline of the activity is set
    Then the activity registers start and deadline