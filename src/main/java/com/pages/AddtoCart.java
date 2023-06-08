package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class AddtoCart extends Utility {
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkout;
	
	public AddtoCart() {
		PageFactory.initElements(driver, this);
	}
	
	public  Checkout_Step1 checkoutButton() {
		checkout.click();
		return new Checkout_Step1();
	}
}
