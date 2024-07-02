#Author: mounikaambati378@gmail.com

Feature: Apply leave in the Leave page of OrangeHRM application

	Background: 
	Given the user is logged into the OrangeHRM application
	When user navigates to the Leave section
	And the user selects Apply
	Then Apply Leave dashboard should be displayed

  Scenario Outline: Apply leave for Full day 
    When the user selects Leave Type from the dropdown
    And verify the leave balance
    And selects same From Date and To Date from "<Sheetname>" and <RowNumber>
    And selects Full Day from Duration dropdown
    And add comments in Comments field from "<Sheetname>" and <RowNumber>
    Then click on apply button
    Then Success alert should be displayed
    
	Examples:
	|Sheetname | RowNumber |
	|testData	 | 0         |

  Scenario Outline: Apply leave for Half Day - Morning
    When the user selects Leave Type from the dropdown
    And verify the leave balance
    And selects same From Date and To Date from "<Sheetname>" and <RowNumber>
    And selects Half Day - Morning from the Duration dropdown
    And add comments in Comments field from "<Sheetname>" and <RowNumber>
    Then click on apply button
    Then Success alert should be displayed

    Examples: 
      | Sheetname  | RowNumber |
      | testData 	 |     1     | 
      
  Scenario Outline: Apply leave for Half Day - Afternoon
    When the user selects Leave Type from the dropdown
    And verify the leave balance
    And selects same From Date and To Date from "<Sheetname>" and <RowNumber>
    And selects Half Day - Afternoon from the Duration dropdown
    And add comments in Comments field from "<Sheetname>" and <RowNumber>
    Then click on apply button
    Then Success alert should be displayed

    Examples: 
      | Sheetname  | RowNumber |
      | testData 	 |     2     | 
      
  Scenario Outline: Apply leave for Specify time
    When the user selects Leave Type from the dropdown
    And verify the leave balance
    And selects same From Date and To Date from "<Sheetname>" and <RowNumber>
    And selects Specify Time from the dropdown
    Then From,To,Duration fields should be displayed
    And add From, To time from "<Sheetname>" and <RowNumber> and validate Duration is accurate
    And add comments in Comments field from "<Sheetname>" and <RowNumber>
    Then click on apply button
    Then Success alert should be displayed
    
    Examples: 
      | Sheetname  | RowNumber |
      | testData 	 |     3     | 
      
  Scenario Outline: Apply leave for All days
  	When the user selects Leave Type from the dropdown
  	And verify the leave balance
  	And selects From Date and To Date from "<Sheetname>" and <RowNumber>
  	And select All Days from the Partial Days dropdown
  	And select Half Day Morning from Duration dropdown
  	And add comments in Comments field from "<Sheetname>" and <RowNumber>
  	Then click on apply button
  	Then Success popup should be displayed
  	
  	Examples: 
      | Sheetname  | RowNumber |
      | testData 	 |     4     | 
	
	
	Scenario Outline: Apply leave for Start Day Only
  	When the user selects Leave Type from the dropdown
  	And verify the leave balance
  	And selects From Date and To Date from "<Sheetname>" and <RowNumber>
  	And select Start Day Only from the Partial Days dropdown
  	And select Half Day Afternoon from Duration dropdown
  	And add comments in Comments field from "<Sheetname>" and <RowNumber>
  	Then click on apply button
  	Then Success alert should be displayed
  	
  	Examples: 
      | Sheetname  | RowNumber |
      | testData 	 |     5     | 
      
  Scenario Outline: Apply leave for End Day Only
  	When the user selects Leave Type from the dropdown
  	And verify the leave balance
  	And selects From Date and To Date from "<Sheetname>" and <RowNumber>
  	And select End Day Only from the Partial Days dropdown
  	And select Scepify time from Duration dropdown
  	Then From,To,Duration fields should be displayed
    And add From, To time from "<Sheetname>" and <RowNumber> and validate Duration is accurate
  	And add comments in Comments field from "<Sheetname>" and <RowNumber>
  	Then click on apply button
  	Then Success alert should be displayed
  	
  	Examples: 
      | Sheetname  | RowNumber |
      | testData 	 |     6     | 
      
  Scenario Outline: Apply leave for Start and End Day
  	When the user selects Leave Type from the dropdown
  	And verify the leave balance
  	And selects From Date from "<Sheetname>" and <RowNumber>
  	And selects To Date from "<Sheetname>" and <RowNumber>
  	And select Start and End Day from the Partial Days dropdown
  	Then Start Day and End Day dropdowns should be displayed
  	And select Half Day Morning from Start Day dropdown
  	And Select Half Day Afternoon from End Day dropdown
  	And add comments in Comments field from "<Sheetname>" and <RowNumber>
  	Then click on apply button
  	Then Success alert should be displayed
  	
  	Examples: 
      | Sheetname  | RowNumber |
      | testData 	 |     7     | 
      
  Scenario: Apply leave while leaving the required fields blank
   	When the user selects Leave Type from the dropdown
   	And verify the leave balance
   	Then click on apply button
   	Then user should get an error indicating that From Date and To Date is required

   	
   	