package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class Product_List extends Utility{
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement product;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cartitems;
	
	@FindBy(xpath="//span [@class='title']")
	private WebElement productpage;
	
	public Product_List() {
		PageFactory.initElements(driver, this);
	}
	public void addToCart() {
		product.click();
	}

	public  AddtoCart cartIcon() {
		cartitems.click();
		return new AddtoCart();
	}
	
	public String textCapture()
	{
		return productpage.getText();
	}
}
