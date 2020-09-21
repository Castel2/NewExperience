package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Order extends BasePOM {

	float total_products = 0;
	float total = 0;
	SignIn login;

	By secctionWomen = By.xpath("//a[text()='Women']");
	By list = By.className("icon-th-list");
	By button = By.className("cross");
	By products = By.id("total_product");
	By price = By.id("total_price");

	By signIn = By.className("header_user_info");
	By mail = By.id("email");
	By password = By.id("passwd");
	By sing = By.id("SubmitLogin");

	public Order(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void selectProducts() throws InterruptedException {
		click(secctionWomen);
		Thread.sleep(5000);
		click(list);
		for (int i = 1; i <= 4; i++) {
			click(By.xpath("//a[@data-id-product=" + i + "]"));
			Thread.sleep(3000);
			if (i != 4) {
				click(button);
			} else {
				click(By.xpath("//*[@class='btn btn-default button button-medium' and @title='Proceed to checkout']"));
			}
		}
	}

	public void completeOrder() throws InterruptedException {
		total_products = Float.parseFloat((getText(products).replaceAll("\\$", "")))
				+ Float.parseFloat(getText(By.id("total_shipping")).replaceAll("\\$", ""));
		total = Float.parseFloat(getText(price).replaceAll("\\$", ""));
		if (total_products == total) {
			click(By.xpath(
					"//*[@class='button btn btn-default standard-checkout button-medium' and @title='Proceed to checkout']"));
			wait(3, By.id("login_form"));
			if (isDisplayed(mail) && isDisplayed(password)) {
				write("MariaCamila9@gmail.com", mail);
				write("123456789", password);
				click(sing);
				if(isDisplayed(By.xpath("//span[text()='Proceed to checkout']"))) {
					click(By.xpath("//span[text()='Proceed to checkout']"));
					click(By.id("cgv"));
					click(By.name("processCarrier"));
					if(total_products == Float.parseFloat(getText(By.id("total_price")).replaceAll("\\$", ""))) {
						click(By.xpath("//a[@class='bankwire' and @title='Pay by bank wire']"));
						click(By.xpath("//*[@class='button btn btn-default button-medium' and @type='submit']"));
						if(isDisplayed(By.className("alert alert-success"))) {
							
						}
					}else {
						System.out.println("Los valores no coinciden");
					}
				}else {
					System.out.println("No se puede continuar con el Check");	
				}
			} else {
				System.err.println("No se encuentra la sección de Iniciar Sesión");
			}
		}else {
			System.out.println("Los valores no coinciden");
		}
	}
	
	public void checkOrder() {
		click(By.xpath("//*[@class='button-exclusive btn btn-default' and @title='Back to orders']"));
		if(isDisplayed(By.id("order-list"))) {
			click(By.xpath("//*[@class='link-button' and @title='Reorder']"));
			if(Float.parseFloat(getText(price).replaceAll("\\$", "")) !=  total_products) {
				System.out.println("Los valores no coinciden total de productos= " + total_products + " con Total= " + Float.parseFloat(getText(price).replaceAll("\\$", "")));
			}
		}
	}

}
