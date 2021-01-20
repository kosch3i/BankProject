package bank.tests;

//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import bank.pages.HomePage;
import bank.pages.LoginBankPage;

public class Login {
	WebDriver dr;
	String driverPath = "C:\\Selenium\\Drivers\\firefox.exe";
	String userId = "mngr304620";
	String password = "EmUryjA";
	LoginBankPage loginView;
	HomePage homeView;
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		dr = new FirefoxDriver();
		loginView = new LoginBankPage(dr);
		loginView.init();
		
	}
	
	@Test(priority=0)
	public void login() {
		loginView.login(userId, password);
		
		//Validate the login was successfully checking the title and a welcome message
		String titlePage = dr.getTitle();
		String welcomeMessage = dr.findElement(By.xpath("//marquee")).getText();
		
		if(titlePage.equalsIgnoreCase("Guru99 Bank Manager HomePage") && welcomeMessage.equalsIgnoreCase("Welcome To Manager's Page of Guru99 Bank")) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
	}
	
	@Test(priority=1, dependsOnMethods = {"login"})
	public void logout() {
		homeView = new HomePage(dr);
		homeView.logout();
		dr.switchTo().alert().accept();
	}
	
	@AfterTest
	public void closeBrowser() {
		dr.close();
	}

}

