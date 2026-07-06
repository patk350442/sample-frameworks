Feature: Complete order of an item from the ecommerce website

Background: 
Given user lands on the Ecommerce page

@Regression
Scenario Outline: Positive scenario of submitting the order 
	Given user logs in with email <email> and password <password>
	When user selects the <productName> and adds it to the cart
	And checks out the <productName> and submits the order
	Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page
	
	Examples:
	|email|password|productName|
	|pratik350442@gmail.com|Test@12345|ZARA COAT 3|