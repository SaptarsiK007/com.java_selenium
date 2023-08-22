package com.java_selenium.com.java_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Objects1 {
	
	WebDriver driver;
	//By Searhbox = By.xpath("//textarea[@id='APjFqb']");
	@FindBy(xpath = "//textarea[@id='APjFqb']")
	public WebElement search_box;

	public Page_Objects1(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
	}

}
