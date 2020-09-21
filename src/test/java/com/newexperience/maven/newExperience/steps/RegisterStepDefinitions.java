package com.newexperience.maven.newExperience.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.project.pom.CreateAccount;

public class RegisterStepDefinitions {

    private WebDriver driver;
    CreateAccount createAccount;

    @Given("I am a new user")
    public void givenNewUser() throws InterruptedException {
    	createAccount = new CreateAccount(driver);
    	driver = createAccount.ConnectionChrome();
    	createAccount.web("http://automationpractice.com/index.php");
    	createAccount.newUser();
    }

    @When("I create an account")
    public void whenRegister() {
    	createAccount.createAccount();
    }

    @Then("it was registered")
    public void thenRegistered() {
    	assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", createAccount.confirmRegistration());
    	driver.quit();
    }

}
