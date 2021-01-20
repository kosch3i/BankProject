package bank.tests;

//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebElement;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;

import bank.pages.HomePageFactory;
import bank.pages.LoginBankPageFactory;
import static bank.tests.Utils.*;

public class LoginTestFactory {
	WebDriver dr;
	LoginBankPageFactory loginView;
	HomePageFactory homeView;
	//commments
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", DRIVERPATH);
		
		FirefoxProfile myProfile = new FirefoxProfile(new File("C:\\Users\\ITStark\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\102bpfx8.testing"));
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(myProfile);
		
		dr = new FirefoxDriver(options);
		loginView = new LoginBankPageFactory(dr);
		loginView.init();
		
	}
	
	@Test(priority=0)
	public void login() {
		loginView.login(USERID, PASSWORD);
		
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
		homeView = new HomePageFactory(dr);
		homeView.logout();
		dr.switchTo().alert().accept();
	}
	
	@AfterTest
	public void closeBrowser() {
		dr.close();
	}

}

