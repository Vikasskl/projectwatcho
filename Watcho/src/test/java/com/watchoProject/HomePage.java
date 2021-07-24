package com.watchoProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularCssContainingText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage  {
	
	private WebDriver webDriver;
	
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		
		try {
			HomeDeeplink();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HomePage() {
	
	}
	
	@Test
	public void HomeDeeplink() throws InterruptedException
	{
		Thread.sleep(2000);
		System.err.println("Executing home stuff ");
		webDriver.findElement(ByAngularCssContainingText.className("nav-link premium-screen")).click();
//		webDriver.findElement(ByAngular.cssContainingText("ugc-upload-icon", "ugc-upload-icon").tagName("span")).click();

		
	}
	
//	@AfterClass
//	public void tearDown() {
//
//		getWebDriver().quit();
//
//	}






	
}