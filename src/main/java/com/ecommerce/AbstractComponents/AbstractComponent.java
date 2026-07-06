package com.ecommerce.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecommerce.pageobjects.CartPage;
import com.ecommerce.pageobjects.OrdersPage;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	 

	public void waitForElementToAppear(By locator) throws InterruptedException
	{
		
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForWebElementToAppear(WebElement element) throws InterruptedException
	{
		
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForWebElementToDisappear(WebElement Element) throws InterruptedException
	{
		Thread.sleep(500);
	//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	//	wait.until(ExpectedConditions.invisibilityOf(Element));
		
	}
	
	public void waitForWebElementTobeClickable(WebElement element)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public CartPage goToCartPage() throws InterruptedException 
	{
		
		cartHeader.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	public OrdersPage goToOrdersPage() throws InterruptedException
	{
		
		orderHeader.click();
		OrdersPage ordersPage=new OrdersPage(driver);
		return ordersPage;
	}
	
	public void test1()
	{
		
		
	}
	
	public void test1_QA1()
	{
		
		
	}
}
