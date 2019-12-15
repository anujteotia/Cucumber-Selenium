# Cucumber-Selenium-Java-Extent
Cucumber Selenium Java Project with Extent report

- Extract the code and import it in Eclipse.

- Install Eclipse Web Developers Tool Plugin in Eclipse from Eclipse marketplace.

- Everything will run from a java class 
```console 
TestRunner.java
``` 
which is present in the package 
```console
/CucumberFramework/src/test/java/runner/TestRunner.java
``` 


## Main Features ##
- Selenium Glue cases are present under `CucumberFramework/src/test/java/seleniumgluecode/SeleniumTest.java`

- Before and After Hooks are present in `/CucumberFramework/src/test/java/utils/Hooks.java`

- Web Driver Initialization in `CucumberFramework/src/test/java/utils/WebDriverInitialization.java`

- Cucumber feature class is present under `/CucumberFramework/src/test/java/features/Test.feature`

## Additional Features

- This Framework supports chrome and firefox browsers both locally and on sauce labs.

- Package name : `CucumberFramework/src/test/java/utils`
	- This contains 4 java utility files :
	
		- Hooks :   
			It Captures Screenshot for the failures in Selenium with TestName and Time stamp appended. and this Screenshot will be present in test case name folder which is in Screenshot folder.
    		This also have 1 Before and 2 After hooks

		- PropUtilities :
			This will load the property file and return the values present in it.

		- WebDriverInitialization :
			This class initializes the webdrivers
			
		- CreateFolder :
			This file creates `screenshots` folder to store failed test case screenshots

- Generating a log file("execution.log") which will be helpful in code debugging in case of any failure. This file will be created in "execution_logs" folder.

- Use of Properties File to avoid any kind of hard coding.

- It supports chrome & Firefox browser.

- Javadoc has been created for every method.

- Using JUnit and log4j2 Frameworks.

- Creates extent and junit reports

- Extent report contains embeded screenshots for the failed scenarios.

		
## Important locations ##

- Reports: `targets` folder. This folder contains two more sub folders to store two diffrent types of reports.
	- Extent Report: `target/cucumber-reports/extentReport.html` folder
	- Junit Report: `target/junit-reports/index.html` folder
- log4j2 properties file: `CucumberFramework/src/test/resources` folder.
- Properties file: `CucumberFramework/src/test/resources` folder
- Log file : `execution_logs` folder
- Failure Screenshots: `screenshots` folder.
- feature file: `src/test/java/features/` folder
- selenium glue tests: `src/test/java/seleniumgluecode` folder
- Runner: `src/test/java/runner` folder
- Utilities: `src/test/java/utils` folder
- Resources: `src/test/resources` foler. It contains properties files and log4j2 configuration file.


# THE END :)
