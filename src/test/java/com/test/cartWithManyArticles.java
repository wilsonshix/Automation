package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pageFactory.HomePage;
import com.pageFactory.SearchPage;
import com.pageFactory.CommonOnPage;
import com.pageFactory.LoginPage;
import com.pageFactory.ProductPage;

public class cartWithManyArticles {

	static WebDriver driver;
	static String browser = "Chrome";
	static String url = "https://www.darty.com";
	static String produit = "Lenovo IDEAPAD 320S-14IKBR 81BN004LFR"; //"Lenovo IDEACENTRE 310S-08IAP 90GA000XFR";  //
	static boolean rep = false;
	static String sortingBy ="Prix décroissant";
	static String search ="Lenovo";

	public static void main(String[] args) throws Exception{

		setBrowserConfig();	
		runTest();



		SearchPage sd = new SearchPage(driver);
		ProductPage pp = new ProductPage(driver);

		int i=0;

		do{



			sd.typeSearch(search);
			sd.clickOnSearch();


			//sd.isCorrectResultTitle(search);

			sd.displayAllArticles();

			sd.displayAllSortingValue(); 
			sd.selectRandomCBoxValue();  

			sd.clickOnRandomArticle();


			pp.clickOnAddToCart();		
			//pp.isCorrectResultTitle();

			i++;

		}while (i<3);


		pp.clickOnAccessToCart();



		System.out.println("toto le chef de gang");

		//closeTest();

	}



	static void setBrowserConfig(){

		if(browser.contains("Firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\SeleniumGecko\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		if(browser.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumGecko\\chromedriver.exe");
			driver = new ChromeDriver();
		}

	}

	static void runTest(){
		//maximize the browser 
		driver.manage().window().maximize();  
		//if can't find the element with in 10 sec, throw exception  
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		driver.get(url);
		driver.getTitle();
	}

	static void closeTest(){
		driver.quit();		
	}






}
