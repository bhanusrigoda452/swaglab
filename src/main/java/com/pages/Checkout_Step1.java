package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utility.Utility;

public class Checkout_Step1 extends Utility {
	
	@FindBy(id="first-name")
	private WebElement firstName;

	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement postalcode;
	
	@FindBy(tagName="h3")
	private WebElement errormsg;
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement Text;
	
	@FindBy(xpath="//*[@id='continue']")
	private WebElement Continue;
	
	
	
	
	public Checkout_Step1(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterFirstname(String fn) {
		firstName.sendKeys(fn);
	}	

	public void enterLastname(String ln) {
		lastName.sendKeys(ln);
	}
	public void enterPincode(String pc) {
		postalcode.sendKeys(pc);
	}
	public  Checkout_Step2 continueButton() {
		Continue.click();
		return new Checkout_Step2();
	}
	
	public String textCapture()
	{
		return Text.getText();
	}
	public String error_Message()
	{
		return errormsg.getText();
	}
//	if(lp.mobilenumber.isDisplayed()==true) {
//
//        System.out.println("elements are enabled");
//
//        Thread.sleep(5000);
//
//    }
//
//    else {
//
//        System.out.println("not working");
//
//    }
//	 logger.log(Status.INFO, "Step7 is executed");
}
