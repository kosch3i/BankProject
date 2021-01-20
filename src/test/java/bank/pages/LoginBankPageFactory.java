package bank.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginBankPageFactory {
	WebDriver dr;
	String url = "http://www.demo.guru99.com/V4/";
	
	//Page elements
	@FindBy(name="uid")
	WebElement userField;
	
	@FindBy(name="password")
	WebElement passwordField;

	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	public LoginBankPageFactory(WebDriver driver) {
		this.dr = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.dr, 40);
		PageFactory.initElements(factory, this);
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
		userField.sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		passwordField.sendKeys(pwd);
	}
	
	public void login(String user,String pwd) {
		this.setUser(user);
		this.setPassword(pwd);
		this.submit();
	}
	
	public void submit() {
		loginButton.click();
	}
}
