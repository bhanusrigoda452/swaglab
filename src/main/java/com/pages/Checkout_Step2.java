package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class Checkout_Step2 extends Utility{
	
	
	@FindBy(xpath="//*[text()='Checkout: Overview']")	
	private WebElement textElement;
	
	@FindBy(xpath="//*[text()='Finish']")
	private WebElement Finish;
	
	
	public Checkout_Step2(){
		PageFactory.initElements(driver, this);
	}
	
	public  Checkout_complete finishButton() {
		Finish.click();
		return new Checkout_complete();
	}
	
	public String textCapture()
	{
		return textElement.getText();
	}
	
}
