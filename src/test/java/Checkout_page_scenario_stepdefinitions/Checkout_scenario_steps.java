package Checkout_page_scenario_stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import com.aventstack.extentreports.Status;
import com.pages.AddtoCart;
import com.pages.Checkout_complete;
import com.pages.Checkout_Step1;
import com.pages.Checkout_Step2;
import com.pages.LoginPage;
import com.pages.Product_List;
import com.utility.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout_scenario_steps extends Utility{
	public LoginPage lp;
	public Product_List pl;
	public  AddtoCart atc;
	public  Checkout_Step1 cs1;
	public Checkout_Step2 cs2;
	public Checkout_complete cc;
	
	public void objectMethod() throws IOException {
		lp = new LoginPage();
		pl=new Product_List();
		atc=new  AddtoCart();
		cs1=new Checkout_Step1();
		cs2=new Checkout_Step2();
		cc=new Checkout_complete();
	}
	

	@Given("Chrome is launched and swaglabs is opened")
	public void chrome_is_launched_and_swaglabs_is_opened() throws IOException, InterruptedException {
		objectMethod();
		logger = report.createTest("test01");
        logger.log(Status.INFO, "Swag labs page is opened");
        
	    String actualTitle = lp.validatePageTitle();
	    String expectedTitle = "Swag Labs";
	    System.out.println(actualTitle);
	    try {
            assertEquals(actualTitle, expectedTitle);
            logger.log(Status.PASS, "Step1 is passed");
            System.out.println(actualTitle);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Step1 is failed");
            captureScreenshotOnFailure();
            assert false;
        }
	    Thread.sleep(2000);
	    
	    
	}
	@Then("User navigates to login page")
	public void user_navigates_to_login_page() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
	    String expectedTitle = "Swag Labs";
	    String actualTitle = lp.validatePageTitle();
	    assertEquals(actualTitle, expectedTitle);
	    System.out.println(actualTitle);
	   
	    try {
	    	logger.log(Status.INFO, "Step2 is executed");
            assertEquals(actualTitle, expectedTitle);
            logger.log(Status.PASS, "Step 2 is passed");
            System.out.println(actualTitle);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Step 2 is failed");
            captureScreenshotOnFailure();
            assert false;
        }
	    
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

	@When("User Go cart page and click on checkout page")
	public void user_go_cart_page_and_click_on_checkout_page() throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(2000);
		pl.addToCart();
		Thread.sleep(5000);
		pl.cartIcon();
		Thread.sleep(5000);
		atc.checkoutButton();
		Thread.sleep(4000);
		 logger.log(Status.INFO, "Step4 is executed");
	}
	@Then("User navigates to checkout page")
	public void user_navigates_to_checkout_page() throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(3000);
		String actualText=cs1.textCapture();
	    String expectedText="Checkout: Your Information";
		System.out.println("Actual Text is"+actualText);

		
		 try {
			 logger.log(Status.INFO, "Step 5 is executed");
	            assertEquals(actualText, expectedText);
	            logger.log(Status.PASS, "Step 5 is passed");
	            System.out.println(actualText);
	            assert true;
	        } catch (AssertionError e) {
	            e.printStackTrace();
	            logger.log(Status.FAIL, "Step 5 is failed");
	            captureScreenshotOnFailure();
	            assert false;
	        }
		
	}
	@When("User entered firstname {string},lastname {string} and zipcode {string}")
	public void user_entered_firstname_lastname_and_zipcode(String firstname, String lastname, String zipcode) throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(3000);
		cs1.enterFirstname(firstname);
		cs1.enterLastname(lastname);//4/3
		cs1.enterPincode(zipcode);
		Thread.sleep(4000);
		 logger.log(Status.INFO, "Step5 is executed");
	}

	
	
	
	
	@When("click on continue button of checkout information page")
	public void click_on_continue_button_of_checkout_information_page() throws IOException, InterruptedException {
		objectMethod();
		scroll();
		Thread.sleep(4000);
		cs1.continueButton();
		 logger.log(Status.INFO, "Step6 is executed"); //5/3     5/4
		 
	}
	@Then("It shows elements of checkout overview page")
	public void it_shows_elements_of_checkout_overview_page() throws IOException, InterruptedException {
		objectMethod();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String actualText=cs2.textCapture();
	    String expectedText="Checkout: Overview";
	    try {
            logger.log(Status.INFO, "Step 7 is executed");

            assertEquals(actualText, expectedText);
            logger.log(Status.PASS, "Test 7 is passed");
            System.out.println(actualText);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Test 7 is failed");
            captureScreenshotOnFailure();
            assert false;
        }

		Thread.sleep(4000);
		
	    
	}
	
	
	
	
	@When("User clicks on Finish button")
	public void user_clicks_on_finish_button() throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(4000);
		cs2.finishButton();
		Thread.sleep(3000);
		 logger.log(Status.INFO, "Step6 is executed");
	    
	}
	
	@Then("User navigates to Checkout complete page")
	public void user_navigates_to_checkout_complete_page() throws IOException, InterruptedException {
		objectMethod();
		String actualText=cc.textCapture();
	    String expectedText="Checkout: Complete!";
		System.out.println("Actual Text is"+actualText);
		Thread.sleep(5000);
		try {
            logger.log(Status.INFO, "Step 7 is executed");

            assertEquals(actualText, expectedText);
            logger.log(Status.PASS, "Test  is passed");
            System.out.println(actualText);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Test  is failed");
            captureScreenshotOnFailure();
            assert false;
        }
	}
	
	@When("User clicks on Back Home button")
	public void user_clicks_on_back_home_button() throws IOException, InterruptedException {
	    objectMethod();
	    Thread.sleep(5000);
		cc.backHomeButton();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Step8 is executed");
	}
	@Then("User navigates to Products list page")
	public void user_navigates_to_products_list_page() throws IOException, InterruptedException {
		objectMethod();
		String actualText=pl.textCapture();
	    String expectedText="Products";
		System.out.println("Actual Text is"+actualText);
	    try {
	    	 logger.log(Status.INFO, "Step9 is executed");
            assertEquals(actualText, expectedText);
            logger.log(Status.PASS, "Step9 is passed");
            System.out.println(actualText);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Step9 is failed");
            captureScreenshotOnFailure();
            assert false;
        }
		Thread.sleep(5000);
		
		
	}
	
}
