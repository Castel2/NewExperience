package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccount extends BasePOM {

	By signIn = By.className("header_user_info");
	By mail = By.id("email_create");
	By create_account = By.id("SubmitCreate");
	By register = By.id("submitAccount");
	By from = By.id("account-creation_form");

	// Infomation Personal
	By name = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By password = By.id("passwd");
	By day = By.id("days");
	By month = By.id("months");
	By year = By.id("years");

	// Address
	By firstName = By.id("firstname");
	By lastNameAddress = By.id("lastname");
	By company = By.id("company");
	By address = By.id("address1");
	By city = By.id("city");
	By state = By.id("id_state");
	By postcode = By.id("postcode");
	By country = By.id("id_country");
	By mobile = By.id("phone_mobile");
	By alias = By.id("alias");

	public CreateAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void createAccount() {
		if (personalInformation()) {
			if (address()) {
				click(register);
			} else {
				System.err.println("No se encuentra la sección de Address");
			}
		} else {
			System.err.println("No se encuentra la sección de Información personal");
		}
	}

	public void newUser() throws InterruptedException {
		click(signIn);
		wait(3, create_account);
		if (isDisplayed(create_account)) {
			write("MariaCamila9@gmail.com", mail);
			click(create_account);
			Thread.sleep(5000);
		} else {
			System.err.println("No se encuentra la sección de Información personal");
		}
	}

	public Boolean personalInformation() {
		Boolean flag = false;
		if (isDisplayed(from)) {
			click(By.id("uniform-id_gender1"));
			write("Yordan", name);
			write("Castelblanco", lastName);
			write("123456789", password);
			select("12", day);
			select("9", month);
			select("2019", year);
			click(By.id("newsletter"));
			click(By.id("optin"));
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public Boolean address() {
		Boolean flag = false;
		if (isDisplayed(from)) {
			write("Yordan", firstName);
			write("Castelblanco Jiménez", lastNameAddress);
			write("Couchair", company);
			write("Couchair Bogóta", address);
			write("Bogóta", city);
			write("90598", postcode);
			write("3205689431", mobile);
			write("Castel", alias);
			select("12", state);
			select("21", country);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public String confirmRegistration() {
		wait(5, By.className("info-account"));
		return getText(By.className("info-account"));
	}

}
