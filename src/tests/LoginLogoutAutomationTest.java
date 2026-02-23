/*
 Project: Login & Logout Automation Test 
 Description: Automated login, forgot password, and logout flows 
 using Selenium WebDriver (Java) with TestNG assertions.

 Source: Based on Rahul Shetty Academy Selenium course
 Enhancements: Customized locators, assertions, and execution flow

 Author: Vidhya Subburaj
*/
package tests;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class LoginLogoutAutomationTest {

	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//implicit wait - 2 seconds time out

		String name = "Vdya";

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys("Vdya");

		driver.findElement(By.name("inputPassword")).sendKeys("practice123");

		driver.findElement(By.className("signInBtn")).click();

		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);//

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Vdya");

		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("vdya@rsa.com");

		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("vdya@gmail.com");

		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210");

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Vdya");

		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.id("chkboxOne")).click();

		driver.findElement(By.id("chkboxTwo")).click();

		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		Thread.sleep(2000);

		System.out.println(driver.findElement(By.tagName("p")).getText());

		String successText = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(successText, "You are successfully logged in.");

		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");

		driver.findElement(By.xpath("//*[text()='Log Out']")).click();

		driver.close();

	}

}
