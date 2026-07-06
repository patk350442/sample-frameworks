package com.ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ecommerce.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".cartSection h3")
	List<WebElement> productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	/*
	 * cartProducts=driver.findElements(By.cssSelector("[class*='cartWrap']"));
	 * System.out.println(cartProducts.get(0).findElement(By.cssSelector("h3")).
	 * getText()); boolean
	 * b=cartProducts.stream().anyMatch(p->p.findElement(By.cssSelector("h3")).
	 * getText().equalsIgnoreCase(productName)); Assert.assertTrue(b);
	 * driver.findElement(By.cssSelector(".totalRow button")).click();
	 */
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match=productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout()
	{
		checkoutEle.click();
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		return checkoutpage;
		
	}

	
	
}
