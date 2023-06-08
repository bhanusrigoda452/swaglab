package testrunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		 features = {"src/test/resources/Features/Checkout_page_scenario_outline.feature"},
		 glue={"Checkout_page_scenario_outline_stepdefinitions","apphooks"},
		 plugin= {"pretty",
		 "json:cucumber-reports/cucumber.json",
				 "junit:cucumber-reports/cucumber.xml",
				 "html:cucumber-reports/cucumber"}
		
		 )
public class Checkout_page_scenario_outlines_TestRunner extends AbstractTestNGCucumberTests{
	
	
}
