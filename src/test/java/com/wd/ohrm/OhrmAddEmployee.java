package com.wd.ohrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class OhrmAddEmployee {
	WebDriver driver;
	@BeforeClass
	public void OpenApplication() {
		System.out.println("first change");
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		
		// setup page load timeout
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		// element wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//open url
		driver.get("http://opensource.demo.orangehrmlive.com");
	}

	@Test
	public void login() {
		//enter text on username
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		
		//enter text on password
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		
		//click on login button
		driver.findElement(By.id("btnLogin")).click();

	}

	@Test(dependsOnMethods="login")
	public void addEmployee() {
		//click on pim link
		driver.findElement(By.linkText("PIM")).click();
		
		//click on AddEmployee Link
		driver.findElement(By.partialLinkText("Add Emp")).click();
		
		//enter text on firstname
		driver.findElement(By.id("firstName")).sendKeys("selenium");
		
		//enter text on last name
		driver.findElement(By.id("lastName")).sendKeys("hq");
		
		//click on save button
		driver.findElement(By.id("btnSave")).click();
		
	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
	}


}
