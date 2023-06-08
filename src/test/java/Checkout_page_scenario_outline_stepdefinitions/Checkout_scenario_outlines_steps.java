package Checkout_page_scenario_outline_stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.pages.AddtoCart;
import com.pages.Checkout_Step1;
import com.pages.Checkout_Step2;
import com.pages.LoginPage;
import com.pages.Product_List;
//import com.utility.Config;
import com.utility.Utility;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout_scenario_outlines_steps extends Utility{
	public LoginPage lp;
	public Product_List pl;
	public  AddtoCart atc;
	public  Checkout_Step1 cs1;
	public Checkout_Step2 cs2;
	
	
	public void objectMethod() throws IOException {
		lp = new LoginPage();
		pl=new Product_List();
		atc=new  AddtoCart();
		cs1=new Checkout_Step1();
		cs2=new Checkout_Step2();
		
	}
	@Given("Chrome is launched and Swaglabs is opened")
	public void chrome_is_launched_and_swaglabs_is_opened() throws IOException, InterruptedException {
	    objectMethod();
	    logger = report.createTest("test01");

        logger.log(Status.INFO, "Swag labs page is opened");
	    String actualTitle = lp.validatePageTitle();
	    System.out.println(actualTitle);
	    Thread.sleep(2000);
	
	}
	@Then("User navigates to login page")
	public void user_navigates_to_login_page() throws IOException, InterruptedException {
		objectMethod();
	    
	    String expectedTitle = "Swag Labs";
	    String actualTitle = lp.validatePageTitle();
	    logger.log(Status.INFO, "Step 2 is executed");
	    assertEquals(actualTitle, expectedTitle);
	    System.out.println(actualTitle);
	    
	}
	@When("User loged into swaglabs with Username {string} and Password {string}")
	public void user_loged_into_swaglabs_with_username_and_password(String username, String password) throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		lp.loginUserName(username);
		Utility.implicitWait();
		lp.loginPassword(password);
		Thread.sleep(3000);
		lp.loginButton();
		 logger.log(Status.INFO, "Step3 is executed");
		Utility.implicitWait();
	}
	
	@When("User add the product to the cart and click on check out page")
	public void user_add_the_product_to_the_cart_and_click_on_check_out_page() throws IOException, InterruptedException {
		objectMethod();
		
		pl.addToCart();
		Thread.sleep(5000);
		pl.cartIcon();
		scroll();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Step 4 is executed");
		
		
	}
	@Then("User enters {string} and {string} and {string}")
	public void user_enters_and_and(String firstName, String lastName, String postalCode) throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(3000);
		
		atc.checkoutButton();
		cs1.enterFirstname(firstName);
		cs1.enterLastname(lastName);
		cs1.enterPincode(postalCode);
		Thread.sleep(4000);
		logger.log(Status.INFO, "Step 5 is executed");
		
	}
	@Then("User clicks on Continue button in checkout information page")
	public void user_clicks_on_continue_button_in_checkout_information_page() throws InterruptedException, IOException{
		objectMethod();
		cs1.continueButton();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Step 6 is executed");
	}
	@Then("It navigates to checkout overview page")
	public void it_navigates_to_checkout_overview_page() throws IOException, InterruptedException {
		objectMethod();
	    String actualText=cs2.textCapture();
	    String expectedText="Checkout: Overview";
		assertEquals(expectedText,actualText);
		System.out.println("Actual Text is"+actualText);
		logger.log(Status.INFO, "Step 7 is executed");
		Thread.sleep(5000);
		
	}

	
	@Then("It shows error message enter postal code")
	public void it_shows_error_message_enter_postal_code() throws IOException, InterruptedException {
		objectMethod();
		String exp="Error: Postal Code is required";
		String act=cs1.error_Message();
		Thread.sleep(4000);
		Assert.assertEquals(exp,act);
		System.out.println(act);
		logger.log(Status.INFO, "Step 7 is executed");
		
	}
	

	
}
