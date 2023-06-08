package testrunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		 features = {"src/test/resources/Features/Checkout_page_scenario.feature"},
		 glue={"Checkout_page_scenario_stepdefinitions","apphooks"},
		 monochrome=true
		)
public class Checkout_page_scenario_TestRunner extends AbstractTestNGCucumberTests{

}
