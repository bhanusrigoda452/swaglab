package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class Checkout_complete extends Utility{
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	private WebElement Heading;
	
	@FindBy(xpath="//button[@name='back-to-products']")
	private WebElement backtohome;
	
	public Checkout_complete(){
		PageFactory.initElements(driver, this);
	}

	public  Product_List backHomeButton() {
		backtohome.click();
		return new Product_List();
	}
	
	public String textCapture()
	{
		return Heading.getText();
	}
}
