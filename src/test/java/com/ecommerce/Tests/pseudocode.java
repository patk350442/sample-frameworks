package com.ecommerce.Tests;

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

import com.ecommerce.pageobjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pseudocode {

	
	public static void main(String[] args) throws InterruptedException
	{
		String productName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("pratik350442@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@12345");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		//prod.findElement(By.xpath("//div[@class='card']/div/button[2]")).click();
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']"))); 
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts=driver.findElements(By.cssSelector("[class*='cartWrap']"));
		System.out.println(cartProducts.get(0).findElement(By.cssSelector("h3")).getText());
		boolean b=cartProducts.stream().anyMatch(p->p.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(productName));
		Assert.assertTrue(b);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("india");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirmMsg);
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}
		           
		           
	}              

