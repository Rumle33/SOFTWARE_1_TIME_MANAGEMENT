#Hákun

Feature: edit start and deadline activity
  Scenario: user successfully sets start and deadline for activity
    Given user is logged in as projectleader
    And input is valid - startDate "30/04/2022" endDate "30/05/2022"
    When the start and deadline of the activity is set
    Then the activity registers start and deadline

  Scenario: user sets invalid input for start and deadline
    Given user is logged in as projectleader
    And input is invalid - wrong format - startDate "tredivte i femte" endDate "tredivte i sjette"
    When the start and deadline of the activity is set
    Then the activity does not register start and deadline

  Scenario: user sets invalid input for start and deadline
    Given user is logged in as projectleader
    And input is invalid - year too early and month out of range - startDate "15/00/2019" endDate "10/14/2022"
    When the start and deadline of the activity is set
    Then the activity does not register start and deadline

  Scenario: user sets invalid input for start and deadline
    Given user is logged in as projectleader
    And input is invalid - days out of range for this month - startDate "18/07/2022" endDate "31/04/2022"
    When the start and deadline of the activity is set
    Then the activity registers start but not deadline

  Scenario: deadline is before start, so inputs are invalid
    Given user is logged in as projectleader
    And input is invalid - deadline before start - startDate "14/07/2022" endDate "30/06/2022"
    When the start and deadline of the activity is set
    Then the activity registers start but not deadline

  Scenario: user is not logged in as projectleader
    Given user is logged in as developmentemployee
    And input is valid - startDate "30/04/2022" endDate "30/05/2022"
    When the start and deadline of the activity is set - developmentemployee
    Then the activity does not register start and deadline

  Scenario: Too many forward slashes
    Given user is logged in as projectleader
    And Input is invalid - too many forward slashes - startDate "24/05/2022/35" endDate "14/08/2022/6"
    When the start and deadline of the activity is set
    Then the activity does not register start and deadline