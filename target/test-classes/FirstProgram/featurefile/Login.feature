Feature: Login to account
				Existing user should be able to login to account using correct credentials
				
Scenario: Log into account with correct credentials
Given User navigates to Stackoverflow website 
And User clicks on the login button   
And User enters the valid username 
And User enters the valid password   
When User clicks on login button   
Then User should be taken to the successful login page 