package com.newexperience.maven.newExperience.steps;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.project.pom.SignIn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInStepDefinitions {
	
	private WebDriver driver;
	SignIn signIn;
	
	@Given("I want to log in with {} {}")
    public void givenNewUser(String mail, String pass)  {
		signIn = new SignIn(driver);
    	driver = signIn.ConnectionChrome();
    	signIn.web("http://automationpractice.com/index.php");
    	signIn.login(mail, pass);;
    }

    @When("I enter my account")
    public void whenRegister() {
    	signIn.checkInfo();
    }

    @Then("I find my information")
    public void thenRegistered() throws InterruptedException {
    	assertEquals("Yordan", signIn.chechMyInformation("firstname"));
    	assertEquals("Castelblanco", signIn.chechMyInformation("lastname"));
    	assertEquals("ycastelblancij@gmail.com", signIn.chechMyInformation("email"));
    	driver.quit();
    }

}
