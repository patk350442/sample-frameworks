package com.ecommerce.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.TestComponents.BaseTest;
import com.ecommerce.TestComponents.Retry;
import com.ecommerce.pageobjects.CartPage;
import com.ecommerce.pageobjects.CheckoutPage;
import com.ecommerce.pageobjects.ConfirmationPage;
import com.ecommerce.pageobjects.LandingPage;
import com.ecommerce.pageobjects.ProductCatalogue;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidations extends BaseTest {

	@Test(retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException
	{
	
	
		ProductCatalogue productcatalogue=landingPage.loginApplication("pratik350442@gmail.com", "Test@123451");
		Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email   password.");
	
	}
	
	@Test(groups= {"ErrorHandling","Smoke"})
	public void productErrorValidation() throws IOException, InterruptedException
	{
	
		String productName="ADIDAS ORIGINAL";
		ProductCatalogue productcatalogue=landingPage.loginApplication("pratik350442@gmail.com", "Test@12345");
		List<WebElement> products=productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		CartPage cartpage=productcatalogue.goToCartPage();
		Boolean match=cartpage.VerifyProductDisplay("ZARA COAT 3");
		Assert.assertFalse(match);
		
	}

}
