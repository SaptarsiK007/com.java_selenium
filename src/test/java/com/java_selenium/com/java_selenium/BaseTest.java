package com.java_selenium.com.java_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	public static void main(String[] args) {
		
	String Path = System.getProperty("user.dir");
	System.out.println(Path);
	System.setProperty("webdriver.chrome.driver",Path+"\\src\\main\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	System.out.println("Hello");
	driver.get("https://www.google.com/");

}
}