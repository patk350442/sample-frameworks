package com.ecommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ecommerce.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	  
	  @FindBy(css="[placeholder='Select Country']")
	  WebElement country;
	  
	  @FindBy(css=".ta-item:nth-of-type(2)")
	  WebElement selectCountry;
	  
	  @FindBy(css=".action__submit")
	  WebElement  submit;
	  
	  By results=By.cssSelector(".ta-item:nth-of-type(2)");
	  
	  public void selectCountry(String countryName) throws InterruptedException
	  {
		 country.sendKeys(countryName);
		 waitForElementToAppear(results);
		 selectCountry.click(); 
		 
	  }
	  
	  public ConfirmationPage submitOrder()
	  {
		  submit.click();
		  ConfirmationPage confirmationpage=new ConfirmationPage(driver);
		  return confirmationpage;
	  }

}
