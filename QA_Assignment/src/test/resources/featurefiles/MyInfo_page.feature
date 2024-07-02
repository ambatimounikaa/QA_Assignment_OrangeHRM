#Author: your.email@your.domain.com

Feature: My Info page of OrangeHRM application

	Background: 
		Given the User is logged into the OrangeHRM application
		When user navigates to the My Info section
		Then PIM dashboard should be displayed

  Scenario Outline: Navigate and Update Personal details
    When the user selects Personal Details 
    Then Personal Details dashboard should be displayed
    And enter Employee Full Name from "<Sheetname>" and <RowNumber>
    And enter Employee Id and Other Id from "<Sheetname>" and <RowNumber>
    And enter Drivers License Number from "<Sheetname>" and <RowNumber>
    And enter License Expiry Date from "<Sheetname>" and <RowNumber>
    And select Nationality from the dropdown
    And enter Date of Birth from "<Sheetname>" and <RowNumber>
    Then click on Save
    Then user should get the Success alert
    
    Examples:
    |Sheetname				|RowNumber|
    |personalDetails	|0				|
    
	Scenario: Navigate and Update Personal details while leaving required fields blank
		When the user selects Personal Details 
    Then Personal Details dashboard should be displayed
    Then empty the Employee Full Name 
    Then click on Save
    Then the user should get an error indicating both First Name and Last Name are required
    
    
  Scenario Outline: Navigate and Update Contact Details
    When the user selects Contact Details
    Then Contact Details dashboard should be displayed
    And enter Street 1, Street 2 and City from "<Sheetname>" and <RowNumber>
    And enter State, Zip from "<Sheetname>" and <RowNumber> and Country from dropdown
    And enter Work Email and Other Email from "<Sheetname>" and <RowNumber>
    Then click on Save
    Then user should get the Success alert

    Examples: 
      | Sheetname  			| RowNumber |
      | contactDetails 	|     0 		|
	
	Scenario Outline: Navigate and Update Contact details with invalid Email format
		When the user selects Contact Details 
    Then Contact Details dashboard should be displayed
    And enter invalid Work Email from "<Sheetname>" and <RowNumber>
    Then click on Save
    Then the user should get an error indicating Expected Format is different
    
    Examples: 
      | Sheetname  			| RowNumber |
      | contactDetails 	|     1 		|
  	 
    
   Scenario Outline: Navigate and Update Emergency Contacts
   	When the user selects Emergency Contacts
   	Then Emergency Contacts should be displayed
   	Then click on Add button
   	Then Save Emergency Contact should be displayed
   	And enter Name and Relationship from "<Sheetname>" and <RowNumber>
   	And Enter Mobile from "<Sheetname>" and <RowNumber>
   	Then click on Save
   	Then user should get the Success alert
   	
   	Examples: 
      | Sheetname  					| RowNumber |
      | emergencyDetails 	|     0 		|
      
   Scenario: Navigate and Update Emergency Contacts while leaving required fields blank
		When the user selects Emergency Contacts
    Then Emergency Contacts should be displayed
    And click on Add button
    Then Save Emergency Contact should be displayed
    And clear Name, Relationship and Mobile fields
    Then click on Save
    Then the user should get an error indicating Name, Relationship and At least one phone number are required