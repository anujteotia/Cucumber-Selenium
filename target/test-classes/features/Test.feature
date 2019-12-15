@LoginAndSearchFeature
Feature: Login And Search Feature
  Verify if user is able to Login in to the site

	@scenarioTag
	Scenario: Login as a authenticated user and validate search result
	    Given open animana web ui
	    When user enters username and Password
	    Then login is successfull
	    When select location
	    Then validate new contact icon
	    When select patient from dropdown
	    And search for a term
	    Then assert search term