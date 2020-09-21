package com.newexperience.maven.newExperience.steps;


import org.openqa.selenium.WebDriver;

import com.project.pom.Order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrder {
	
	private WebDriver driver;
    Order order;

    @Given("I want to place an order")
    public void givenNewUser() throws InterruptedException {
    	order = new Order(driver);
    	driver = order.ConnectionChrome();
    	order.web("http://automationpractice.com/index.php");
    	order.selectProducts();
    }

    @When("I complete the order")
    public void whenRegister() throws InterruptedException {
    	order.completeOrder();
    }

    @Then("The order is generated")
    public void thenRegistered() {
    	order.checkOrder();
    	driver.quit();
    }

}
