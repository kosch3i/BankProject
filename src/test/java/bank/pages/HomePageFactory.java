package bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageFactory{
	WebDriver dr;
	//page elements
	
	@FindBy(linkText="Log out")
	WebElement logoutButton;
	
	public HomePageFactory(WebDriver driver) {
		this.dr = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.dr, 40);
		PageFactory.initElements(factory, this);
		
		if (!driver.getTitle().contains("HomePage")) {
			throw new IllegalStateException("Login error");
		}
	}
	
	public void logout() {
		logoutButton.click();
	}
}
