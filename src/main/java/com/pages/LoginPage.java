package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class LoginPage extends Utility{
	@FindBy(name="user-name")
	private WebElement userName;

	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(xpath="//*[@id='login-button']")
	private WebElement loginButton;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginUserName(String un) {
		userName.sendKeys(un);
	}	

	public void loginPassword(String pw) {
		passWord.sendKeys(pw);
	}
	public  Product_List loginButton() {
		loginButton.click();
		return new Product_List();
	}
}
