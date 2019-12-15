# Cucumber-Selenium-Java-Extent
Cucumber Selenium Java Project with Extent report

1. Extract the code and import it in Eclipse.

2. Install Eclipse Web Developers Tool Plugin in Eclipse from Eclipse marketplace.

3. Everything will run from a java class `TestRunner.java` which is present in the package `/CucumberFramework/src/test/java/runner/TestRunner.java`. 


## Main Features
1. Selenium Glue cases are present under `CucumberFramework/src/test/java/seleniumgluecode/SeleniumTest.java`

2. Before and After Hooks are present in `/CucumberFramework/src/test/java/utils/Hooks.java`

3. Web Driver Initialization in `CucumberFramework/src/test/java/utils/WebDriverInitialization.java`

4. Cucumber feature class is present under `/CucumberFramework/src/test/java/features/Test.feature`

## Additional Features

1. This Framework supports chrome and firefox browsers.

2. Package name : `CucumberFramework/src/test/java/utils`
	This contains 3 java files :
	
	a) Hooks :   
		It Captures Screenshot for the failures in Selenium with TestName and Time stamp appended. and this Screenshot will be present in test case name folder which is in Screenshot folder.
    This also have 1 Before and 2 After hooks

	b) PropUtilities :
		This will load the property file and return the values present in it.

	c) WebDriverInitialization :
		This class initializes the webdrivers

3. Generating a log file("execution.log") which will be helpful in code debugging in case of any failure. This file will be created in "execution_logs" folder.

4. Use of Properties File to avoid any kind of hard coding.

5. It supports chrome & Firefox browser.

6. Javadoc has been created for every method.

7. Using JUnit and log4j2 Frameworks.

8. Creates extent and junit reports

9. Extent report contains embeded screenshots for the failed scenarios.

		
## Important locations 

1. Response Files : targets Folder.
2. log4j2 properties file : `CucumberFramework/src/test/resources` folder.
3. Properties file : `CucumberFramework/src/test/resources` Folder5
4. Log file : execution_logs Folder
5. Failure Screenshots : `CucumberFramework/target/cucumber-reports/screenshots` folder.
6. code  : src package


# THE END :)
