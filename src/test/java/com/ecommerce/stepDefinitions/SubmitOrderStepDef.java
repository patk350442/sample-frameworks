package com.ecommerce.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ecommerce.TestComponents.BaseTest;
import com.ecommerce.pageobjects.CartPage;
import com.ecommerce.pageobjects.CheckoutPage;
import com.ecommerce.pageobjects.ConfirmationPage;
import com.ecommerce.pageobjects.LandingPage;
import com.ecommerce.pageobjects.ProductCatalogue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitOrderStepDef extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartpage;
	public CheckoutPage checkoutpage;
	public ConfirmationPage confirmationpage;
	
	@Given("user lands on the Ecommerce page")
	public void User_lands_on_the_Ecommerce_page() throws IOException
	{
		landingPage=launchApplication();
	}
	
	@Given("^user logs in with email (.+) and password (.+)$")
	public void user_logs_in_with_email_and_password(String email, String password)
	{
		productCatalogue=landingPage.loginApplication(email, password); 
	}
//	user selects the <productName> and adds it to the cart
	@When("^user selects the (.+) and adds it to the cart$")
	public void user_selects_and_adds_it_to_the_cart(String productName) throws InterruptedException
	{
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^checks out the (.+) and submits the order$")
	public void checks_out_and_submits_the_order(String productName) throws InterruptedException
	{
		CartPage cartpage=productCatalogue.goToCartPage();
		Boolean match=cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkoutpage=cartpage.goToCheckout();
		checkoutpage.selectCountry("india");
		confirmationpage=checkoutpage.submitOrder();
	}
	
	@Then("{string} message is displayed on the confirmation page")
	public void message_is_displayed_on_the_confirmation_page(String string)
	{
		String confirmMessage=confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		
	}
	

	@Then("user encounters validation message {string}")
	public void user_encounters_validation_message(String string) throws InterruptedException
	{
		Assert.assertEquals(landingPage.getErrorMessage(), string);

	}
} 

