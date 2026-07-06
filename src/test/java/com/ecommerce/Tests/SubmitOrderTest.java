package com.ecommerce.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.TestComponents.BaseTest;
import com.ecommerce.pageobjects.CartPage;
import com.ecommerce.pageobjects.CheckoutPage;
import com.ecommerce.pageobjects.ConfirmationPage;
import com.ecommerce.pageobjects.LandingPage;
import com.ecommerce.pageobjects.OrdersPage;
import com.ecommerce.pageobjects.ProductCatalogue;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	
	String productName="ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Sanity"})
	public void submitOrder(HashMap<String,String> map) throws IOException, InterruptedException
	{
	
		ProductCatalogue productCatalogue=landingPage.loginApplication(map.get("email"), map.get("password"));
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(map.get("productName"));
		CartPage cartpage=productCatalogue.goToCartPage();
		Boolean match=cartpage.VerifyProductDisplay(map.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage=cartpage.goToCheckout();
		checkoutpage.selectCountry("india");
		ConfirmationPage confirmationpage=checkoutpage.submitOrder();
		String confirmMessage=confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		
	}

	

	@Test (dependsOnMethods= {"submitOrder"})
	public void orderHistory() throws InterruptedException
	{
		ProductCatalogue productCatalogue=landingPage.loginApplication("pratik350442.1@gmail.com", "Test@123456");
		OrdersPage ordersPage=productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	
	
/*	  @DataProvider 
 *    public Object[][] getData() 
	  {
		  Object[][] data={{"pratik350442@gmail.com", "Test@12345","ADIDAS ORIGINAL"},{"pratik350442.1@gmail.com","Test@123456","ZARA COAT 3"}};
		  return data; 
		  
	  } */
	 
/*	@DataProvider
	public Object[][] getData()
	{
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email", "pratik350442@gmail.com");
		map1.put("password", "Test@12345");
		map1.put("productName", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map2=new HashMap<String,String>();
		map2.put("email", "pratik350442.1@gmail.com");
		map2.put("password", "Test@123456");
		map2.put("productName", "ZARA COAT 3");
		
		Object[][] data={{map1},{map2}};
		
		//return data;
		
		return new Object[][] {{map1},{map2}};
		
	}*/
	
	@DataProvider
	public Object[][] getData() throws IOException
	{


		List<HashMap<String,String>> data=getJsonDataMap(System.getProperty("user.dir")+"//src//test//java//com//ecommerce//data//SubmitOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}

}
