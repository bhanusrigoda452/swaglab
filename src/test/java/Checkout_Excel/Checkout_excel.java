package Checkout_Excel;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.aventstack.extentreports.Status;
import com.pages.AddtoCart;
import com.pages.Checkout_Step1;
import com.pages.Checkout_Step2;
import com.pages.Checkout_complete;
import com.pages.LoginPage;
import com.pages.Product_List;
import com.utility.Config;
import com.utility.ExcelReader;
import com.utility.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout_excel extends Utility{
	public LoginPage lp;
	public Product_List pl;
	public  AddtoCart atc;
	public  Checkout_Step1 cs1;
	public Checkout_Step2 cs2;
	ExcelReader reader;
	
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
		browserMaximize();
	    Thread.sleep(2000);
	    String actualTitle = lp.validatePageTitle();
	    System.out.println(actualTitle);
	    Thread.sleep(2000);
	   
	}
	@Then("User navigates to login page")
	public void user_navigates_to_login_page() throws IOException, InterruptedException {
		objectMethod();
	    Thread.sleep(2000);
	    String actualTitle = lp.validatePageTitle();
	    System.out.println(actualTitle);
	    Thread.sleep(2000);
	   
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
		Utility.implicitWait();
		pl.addToCart();
		Thread.sleep(5000);
		pl.cartIcon();
		Thread.sleep(3000);
		atc.checkoutButton();
		Thread.sleep(3000);
	   
	}

	@Then("User fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InterruptedException, IOException, InvalidFormatException {
	    // Write code here that turns the phrase above into concrete actions
		objectMethod();
        reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData(Config.excelPath, sheetName);

        String fname = testData.get(rowNumber).get("firstName");
        String lname = testData.get(rowNumber).get("lastName");
        String pcode = testData.get(rowNumber).get("postalCode");
        cs1.enterFirstname(fname);
        cs1.enterLastname(lname);
        cs1.enterPincode(pcode);
        
        Utility.implicitWait();
	}
	@Then("User clicks on Continue button in checkout-step-one page")
	public void user_clicks_on_continue_button_in_checkout_step_one_page() throws IOException, InterruptedException {
		objectMethod();
		scroll();
		Thread.sleep(3000);
		cs1.continueButton();
		
	   
	}
	@Then("It navigates to checkout step-two-page")
	public void it_navigates_to_checkout_step_two_page() throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(4000);
		String actualText=cs2.textCapture();
	    String expectedText="Checkout: Overview";
		assertEquals(expectedText,actualText);
		System.out.println("Actual Text is"+actualText);
		Thread.sleep(5000);
	    
	}

}
