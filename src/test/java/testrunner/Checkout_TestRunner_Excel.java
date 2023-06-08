package testrunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		 features = {"src/test/resources/Features/Checkout_Excel.feature"},
		 glue={"Checkout_Excel","apphooks"},
		 plugin= {"pretty",
		 "json:cucumber-reports/cucumber.json",
				 "junit:cucumber-reports/cucumber.xml",
				 "html:cucumber-reports/cucumber"}
		
		 )
public class Checkout_TestRunner_Excel extends AbstractTestNGCucumberTests{

}
