package com.java_selenium.com.java_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseTest{
	
	@Test
	public void openBrowser() throws InterruptedException {
		
	String Path = System.getProperty("user.dir");
	System.out.println(Path);
	System.setProperty("webdriver.chrome.driver",Path+"\\src\\main\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	System.out.println("Hello");
	driver.get("https://www.google.com/");
	Page_Objects1 ob = new Page_Objects1(driver);
	ob.search_box.sendKeys("Football");
	ob.search_box.sendKeys(Keys.ENTER);
	System.out.println(driver.getTitle());
	Thread.sleep(5000);
	//driver.close();
	driver.quit();

}
}