package com.watchoProject;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularCssContainingText;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LiveDeepLink {

WebDriver driver;
	
	
//NgWebDriver driver;
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		NgWebDriver ngDriver = new NgWebDriver(jsDriver);

		driver.get("https://www.watcho.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
	}
	
	@Test	
	public void signinpage() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class=\"btn btn-pink\"]")).click();
		
		System.out.println("Open login dialog");
	
	{
		System.out.println("Put value on that input control");
//		ByAngular.cssContainingText("form-control ng-dirty ng-touched ng-invalid", "form-control").name("email");
		driver.findElement(ByAngular.cssContainingText("form-control ng-dirty ng-touched ng-invalid", "form-control").name("email")).clear();
		driver.findElement(ByAngular.cssContainingText("form-control ng-dirty ng-touched ng-invalid", "form-control").name("email")).sendKeys("7048973251");
		driver.findElement(ByAngular.buttonText("Continue")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Login with Password']")).click();
		driver.findElement(By.name("password")).sendKeys("Anju@123");
		//driver.findElement(ByAngular.buttonText("Sign In")).click();
//		driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Sign In']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Sign In']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click(); }
		
		
		//driver.findElement(ByAngular.bu)
		
	}
	
	
	
	
	@AfterClass(timeOut = 3000)
	public void tearDown()
	{
		driver.quit();
	}

	
	
	
}
