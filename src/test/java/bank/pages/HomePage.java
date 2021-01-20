package bank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{
	WebDriver dr;
	//page elements
	private By logoutButton = By.linkText("Log out");
	
	public HomePage(WebDriver driver) {
		this.dr = driver;
		if (!driver.getTitle().contains("HomePage")) {
			throw new IllegalStateException("Login error");
		}
	}
	
	public void logout() {
		this.dr.findElement(logoutButton).click();
	}
}
