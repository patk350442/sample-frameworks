package com.ecommerce.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ecommerce.TestComponents.BaseTest;
import com.ecommerce.pageobjects.LandingPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

	public  LandingPage landingPage;
/*	
	@Before
	public void setUp() throws IOException
	{
		landingPage=launchApplication();
	}

	@After
	public void tearDown() {
	    driver.quit();
	    
	}   


    @AfterStep
    public void addScreenshot(Scenario scenario) {
        
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
      
    }
*/	
	
}
