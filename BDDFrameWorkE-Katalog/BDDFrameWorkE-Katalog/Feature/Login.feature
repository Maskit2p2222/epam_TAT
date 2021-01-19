Feature: Login
	login to E-katalog application

@smoke
Scenario: Perform login to E-katalog application site
	Given I launch the application
	And I click login button 
	And I click email login button 
	And I enter login information
		| UserName | Password |
		| test     | test     |
	When I click login button
	Then I should see userName near logout button

@smoke
Scenario: Perform login to E-katalog application site with wrong password
	Given I launch the application
	And I click login button 
	And I click email login button 
	And I enter login information
		| UserName | Password	|
		| test     | test23     |
	When I click login button
	Then I should see error message