package bank.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBankPage {
	WebDriver dr;
	String url = "http://www.demo.guru99.com/V4/";
	
	//Page elements
	private By userField = By.name("uid");
	private By passwordField = By.name("password");
	private By loginButton = By.name("btnLogin");
	
	public LoginBankPage(WebDriver driver) {
		this.dr = driver;
	}
	
	public void init() throws IllegalStateException{
		dr.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.get(url);
		if (!dr.getTitle().contains("Guru99 Bank Home Page")) {
			throw new IllegalStateException("Page not loaded");
		}
	}
	
	public void setUser(String user) {
		dr.findElement(this.userField).sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		dr.findElement(passwordField).sendKeys(pwd);
	}
	
	public void login(String user,String pwd) {
		this.setUser(user);
		this.setPassword(pwd);
		this.submit();
	}
	
	public void submit() {
		dr.findElement(loginButton).click();
	}
}
