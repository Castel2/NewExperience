package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePOM {
	
	private WebDriver driver;
	
	
	public BasePOM(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver ConnectionChrome() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/USUARIO-PC/eclipse-workspace/newExperience/src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String getValue(By locator) {
		return driver.findElement(locator).getAttribute("value");
	}
	
	public void write(String inputText,By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void wait(int timeout, By locator) {
		WebDriverWait myWait = new WebDriverWait(driver, timeout);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void select(String text,By locator) {		
		Select selection = new Select(findElement(locator));
		selection.selectByValue(text);
	}
	
	public void web(String url) {
		driver.get(url);
	}
	
}
