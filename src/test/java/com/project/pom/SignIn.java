package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn extends BasePOM {

	By signIn = By.className("header_user_info");
	By mail = By.id("email");
	By password = By.id("passwd");
	By sing = By.id("SubmitLogin");
	By name = By.xpath("//span[text()='Yordan Castelblanco']");

	private String[] information = new String[] { "Order history and details", "My credit slips", "My addresses",
			"My personal information", "My wishlists" };

	
	public SignIn(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void login(String email, String pass) {
		click(signIn);
		wait(3, By.id("login_form"));
		if (isDisplayed(mail) && isDisplayed(password)) {
			write(email, mail);
			write(pass, password);
			click(sing);
		} else {
			System.err.println("No se encuentra la sección de Iniciar Sesión");
		}
	}

	public void checkInfo() {
		if (isDisplayed(name)) {
			for (int i = 0; i < information.length; i++) {
				if (!(isDisplayed(By.xpath("//span[text()='" + information[i] + "']")))) {
					System.out.println("NO Encontro el area de información " + information[i]);
				}
			}
		}
		click(By.xpath("//span[text()='" + information[3] + "']"));
	}
	
	public String chechMyInformation(String info) throws InterruptedException {
		return getValue(By.id(info));
	}

}