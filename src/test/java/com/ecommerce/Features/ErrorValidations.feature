Feature: Validating error scenarios


@ErrorValidation
Scenario Outline: Verifying validation message on login with incorrect details
	Given user lands on the Ecommerce page
	When user logs in with email <email> and password <password>
	Then user encounters validation message "Incorrect email or password."
	Examples:
	|email|password|
	|pratik350442@gmail.com|Test@1234512|
	
	
