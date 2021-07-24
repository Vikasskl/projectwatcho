package com.watchoProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private WebDriver webDriver;

	public BaseClass() {
		init();
	}

	public WebDriver getWebDriver() {
		return this.webDriver;
	}

	private void init() {
		//if (webDriver == null) {
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver();
			webDriver.get("https://www.watcho.com/");
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			JavascriptExecutor jsDriver = (JavascriptExecutor) webDriver;
			NgWebDriver ngDriver = new NgWebDriver(jsDriver);

		//	webDriver.get("https://www.watcho.com/");
			webDriver.manage().window().maximize();
			webDriver.manage().deleteAllCookies();
			webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

			try {
				Thread.sleep(1000);
				doLogin();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	//}

//	@Test
	public void doLogin() throws InterruptedException {
		Thread.sleep(3000);
		getWebDriver().findElement(By.xpath("//button[@class=\"btn btn-pink\"]")).click();

		System.out.println("Open login dialog");

		System.out.println("Put value on that input control");
//	ByAngular.cssContainingText("form-control ng-dirty ng-touched ng-invalid", "form-control").name("email");
		getWebDriver().findElement(ByAngular.cssContainingText("form-control ng-dirty ng-touched ng-invalid", "form-control").name("email"))
				.clear();
		getWebDriver().findElement(ByAngular
				.cssContainingText("form-control ng-dirty ng-touched ng-invalid", "form-control").name("email"))
				.sendKeys("7048973251");
		getWebDriver().findElement(ByAngular.buttonText("Continue")).click();

		Thread.sleep(1000);
		getWebDriver().findElement(By.xpath("//a[normalize-space()='Login with Password']")).click();
		getWebDriver().findElement(By.name("password")).sendKeys("Anju@123");
		// driver.findElement(ByAngular.buttonText("Sign In")).click();
//	driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Sign In']")).click();
		Thread.sleep(1000);
		getWebDriver().findElement(By.xpath("//button[@type='button'][normalize-space()='Sign In']")).click();
		Thread.sleep(3000);
		getWebDriver().findElement(By.xpath("//button[normalize-space()='Continue']")).click();

		Thread.sleep(2000);
		getWebDriver().findElement(ByAngular.cssContainingText("ugc-upload-icon", "ugc-upload-icon").tagName("span")).click();

		// driver.findElement(ByAngular.bu)

	}

/*	@AfterClass(timeOut = 3000)
	public void tearDown() {
		getWebDriver().quit();
	} */

}
