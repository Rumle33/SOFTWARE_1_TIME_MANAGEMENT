Feature: UPN Calculator addition
Scenario: adding two numbers 
	Given the first input is 1
	And the second input is 3 
	When the add button is pressed
	Then 4 is shown on the display.

Feature: Assign work
	Scenario: work assigned succsefully
		Given user is projectleader
		And co-worker is assigned to project
		And co-worker are available
		When co-worker is assigned to activity
		Then then the co-worker is assigned :)

	Scenario: co-worker not assigned on project
		Given user is projectleader
		And co-worker is not assigned to project
		When co-worker is assigned to activity
		Then print error message "co-worker not assigned to project"

	Scenario:
		Given user is projectleader
		And co-worker is not available
		When co-worker is assigned to activity
		Then print error message "co-worker not available"

	Scenario:
		Given user is not projectleader
		And co-worker is not available
		When co-worker is assigned to activity
		Then print error message "co-worker not available"



