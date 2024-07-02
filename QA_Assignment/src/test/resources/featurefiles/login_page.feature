#Author: mounikaambati378@gmail.com


Feature: OrangeHRM Login page 

  Background: 
  	Given The user is on the OrangeHRM Loginpage
  	
  Scenario Outline: Login into the application using valid credentials
    When the user enter "<Sheetname>" and <RowNumber> to get the valid username and password
    And click on the login button
    Then user should be redirected to the OrangeHRM dashboard
  	Examples: 
  	|Sheetname | RowNumber |
  	|Sheet1		 |0|
  	
  Scenario Outline: Login using invalid credentials
  	When the user enter the "<Sheetname>" and <RowNumber> to get the valid username and invalid password
  	And click on the login button
  	Then the user should see an error message indicating invalid Credentials
  	
  	Examples:
  	|Sheetname | RowNumber |
  	|Sheet1    | 1				 |
  
  Scenario Outline: Login using Non-existent username
  	When the user enter the "<Sheetname>" and <RowNumber> to get invalid username and any password
  	And click on the login button
  	Then the user should see an error message indicating invalid Credentials
  		
  Examples:
  |Sheetname | RowNumber |
  |Sheet1    | 2				 |
  	
  Scenario: Login using blank username and password
  	When the user leaves the username and password fields blank
  	And click on the login button
  	Then the user should see the error messages indicating that both fields are required
  	
  Scenario Outline: Login using blank username and valid password
  	When the user leave the username field blank and enter "<Sheetname>" and <RowNumber> to get password
  	And click on the login button
  	Then the user should see the error message indicating that username is required
	
	Examples:
	|Sheetname | RowNumber |
  |Sheet1    | 3				 |
  
  Scenario Outline: Login using valid username and blank password
  	When the user enters the "<Sheetname>" and <RowNumber> to get valid username and leave the password field blank
  	And click on the login button
  	Then the user should see the error message indicating that password is required
  
  Examples:
  |Sheetname | RowNumber |
  |Sheet1    | 4				 |
  
  Scenario Outline: Forgot password functionality of the login page
  	When the user click on Forgot your password? link
  	Then the user should be redirected to the reset password page
  	And user enters "<Sheetname>" and <RowNumber> to get the username
  	And click on the Reset Password button
  	Then the user should get a message indicating that Reset password link is sent successfully
  	
  	Examples: 
  	|Sheetname | RowNumber |
  	|Sheet1    | 5				 |
  	
  	
  Scenario: Reset Password with invalid data
  When the user click on Forgot your password? link
  Then the user should be redirected to the reset password page
  And leave the username field blank and click on the Reset button
  Then the user should get an error indicating username is required
  
  
  Scenario: Cancelling the Forgot password functionality
  	When the user click on Forgot your password? link
  	Then the user should be redirected to the reset password page
  	And click on the Cancel button
  	Then the user should be redirected back to the login page
