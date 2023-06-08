--------------------------------------------------------------------------------------------------
Project structure:

src/main/java:
	com.config:
		Config.properties
		
	com.pages:
		LoginPage.java
		ProductDetails.java
		Addtocart.java
		Checkout_information.java
		Checkout_overview.java
		Checkout_complete.java
	
	com.testdata:
		testdata.xlsx
			
	com.utility:
		Config.java
		ConfigReader.java
		ExcelReader.java
		ExtentReporterManager.java
		Utility.java
		
src/test/java:
	apphooks:
		ApplicationHooks.java
		
	Checkout_Excel:
		Checkout_excel.java
		
	Checkout_page_scenario_outline_stepdefinitions:
		Checkout_scenario_outlines_steps.java
		
	Checkout_page_scenario_stepdefinitions:
		Checkout_scenario_steps.java
	
	com.testrunner:
		Checkout_page_scenario_outlines_TestRunner.java	
		Checkout_page_scenario_TestRunner.java
		Checkout_TestRunner_Excel.java
		
src/main/resources:
		ReadMe
						
src/test/resources:
	testng.xml
	features folder
			Checkout_page_scenario.feature
			Checkout_page_scenario_outline.feature
			Checkout_Excel.feature

drivers folder:
	chromedriver.exe
	geckodriver.exe
	
screenshots folder:
	file.png
		
extent_reports folder:
	file.html
	
cucumber_report folder:
    cucumber.html
    cucumber.json
    cucumber.xml


pom.xml            
	
pom.xml			
--------------------------------------------------------------------------------------------------
Project creation sequence:

Create maven project
Add the dependencies in pom.xml
Maven project will have 4 sections by default(if not then create them):
	src/main/java
	src/main/resources
	src/test/java
	src/test/resources

Create the required packages, classes, files in them as per below sequence:

Step 1 --> Create Feature file
Step 2 --> Create Config.java
Step 3 --> Create Config.properties
Step 4 --> Create ConfigReader.java
Step 5 --> Create ExtentReader.java
Step 6 --> Create ExtentReportManager.java
Step 7 --> Create Utility.java
Step 8 --> Create LoginPage.java
Step 9 --> Create ProductDetails.java
Step 10 --> Create Addtocart.java
Step 11 --> Create Checkout_Step1.java.
Step 12 --> Create Checkout_Step2.java
Step 13 --> Create Checkout_complete.java
Step 14 --> Create ApplicationHooks.java
Step 15 -->Create Checkout_scenario_steps.java
Step 16 -->Create Checkout_scenario_outlines_steps.java	
Step 17 -->Create Checkout_excel.java		
Step 18 --> Create Checkout_page_scenario_TestRunner.java	
Step 19 --> Create Checkout_page_scenario_outlines_TestRunner.java
Step 20 --> Create Checkout_TestRunner_Excel.java
step 21--->Create testng.html
Create the drivers folder and keep driver in it
Create the screenshots folder to keep screenshots in it
Run the tests by using Test class(individual test class) or pom.xml

See the reports in test-output folder(created by testng)
See the reports in target folder(created by maven)
