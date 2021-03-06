package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.driverFactory.*;
import com.pageFactory.*;


public class DriverTest {

	DriverManager driverManager;
	WebDriver driver;
	String browser = "Chrome";
    String url = "https://www.darty.com";
    String product = "LENOVO LEGION Y520-15IKBM 80YY003RFR";
    String search = "lenovo";
/*
	@BeforeTest
	public void beforeTest() {
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		//driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = driverManager.getDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driverManager.quitDriver();
	}*/
	
	
    @BeforeTest
    public void setBrowserConfig(){
		
		if(browser.contains("Firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\SeleniumGecko\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browser.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumGecko\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

    @BeforeMethod
    public void runTest(){
		//maximize the browser 
		driver.manage().window().maximize();  
		//if can't find the element with in 10 sec, throw exception  
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		driver.getTitle();
	}

	@AfterMethod
	public void closeTest(){
		//driver.quit();		
	}
	
	

	@Test
	public void launchTest() {
		driver.get(url);

		HomePage hp = new HomePage(driver);

		hp.typeSearch(search);
    	hp.clickOnSearch();
    	
		SearchPage sp = new SearchPage(driver);
		Assert.assertTrue(sp.isAt());
		System.out.println("SearchPage was successfully loaded :"+driver.getTitle());
		sp.displayAllArticles();
		sp.clickOnSpecificArticle(product); // goToNextLink included
		
		ProductPage pp = new ProductPage(driver);
    	Assert.assertTrue(pp.isAt());
    	System.out.println("ProductPage was successfully loaded :"+driver.getTitle());
    	pp.clickOnAddToCart();
    	pp.clickOnAccessToCart();   //have to fix the pop-in
    	
    	CartPage cp = new CartPage(driver);
    	Assert.assertTrue(cp.isAt());
    	System.out.println("CartPage was successfully loaded :"+driver.getTitle());

	}

}
