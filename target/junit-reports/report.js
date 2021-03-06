$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Test.feature");
formatter.feature({
  "line": 2,
  "name": "Login And Search Feature",
  "description": "Verify if user is able to Login in to the site and then able to search",
  "id": "login-and-search-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@LoginAndSearchFeature"
    }
  ]
});
formatter.before({
  "duration": 3910930665,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Login as a authenticated user and validate search result",
  "description": "",
  "id": "login-and-search-feature;login-as-a-authenticated-user-and-validate-search-result",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@scenarioTag"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "open animana web ui",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user enters username and Password",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "login is successfull",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "select location",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "validate new contact icon",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "select patient from dropdown",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "search for a term",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "assert search term",
  "keyword": "Then "
});
formatter.match({
  "location": "SeleniumTest.goToAnimana()"
});
formatter.result({
  "duration": 1226300920,
  "status": "passed"
});
formatter.match({
  "location": "SeleniumTest.user_enters_username_and_Password()"
});
formatter.result({
  "duration": 1088426342,
  "status": "passed"
});
formatter.match({
  "location": "SeleniumTest.login_is_successfull()"
});
formatter.result({
  "duration": 886352745,
  "status": "passed"
});
formatter.match({
  "location": "SeleniumTest.select_location()"
});
formatter.result({
  "duration": 1519567560,
  "status": "passed"
});
formatter.match({
  "location": "SeleniumTest.validate_new_contact_icon()"
});
formatter.result({
  "duration": 488538195,
  "status": "passed"
});
formatter.match({
  "location": "SeleniumTest.select_patient_from_dropdown()"
});
formatter.result({
  "duration": 3515518330,
  "status": "passed"
});
formatter.match({
  "location": "SeleniumTest.search_for_a_term()"
});
formatter.result({
  "duration": 267477522,
  "status": "passed"
});
formatter.match({
  "location": "SeleniumTest.assert_search_term()"
});
formatter.result({
  "duration": 3374274211,
  "status": "passed"
});
formatter.after({
  "duration": 620212,
  "status": "passed"
});
formatter.after({
  "duration": 235473208,
  "status": "passed"
});
});