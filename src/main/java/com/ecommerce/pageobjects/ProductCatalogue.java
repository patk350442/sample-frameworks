package com.ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	WebElement userEmail=driver.findElement(By.id("userEmail")).sendKeys("pratik350442@gmail.com");
//	driver.findElement(By.id("userPassword"))

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy= By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector(".ng-trigger-flyInOut");

	public List<WebElement> getProductList() throws InterruptedException
	{
		waitForElementToAppear(productsBy);
		return products;
		
	}
	
	public WebElement getProductByName(String ProductName) throws InterruptedException
	{
		WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(ProductName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		getProductByName(productName).findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForWebElementToDisappear(spinner);
		
		
	}
	
	
	
	
}
