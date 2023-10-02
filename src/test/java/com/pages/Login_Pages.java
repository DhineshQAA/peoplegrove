package com.pages;

import com.driver.Driver;
import com.utilities.Log;
import com.utilities.ReadPropertiesFile;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Login_Pages extends Driver{
	public static final String filename = null;
	public ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	public Properties prop = readPropertiesFile.readPropertiesFile(filename);

	@FindBy(xpath = "//*[@id='main']/div/nav/div[2]/button[1]")
	WebElement singIn_button;

	@FindBy(xpath = "//input[@placeholder='Enter your email']")
	WebElement email_input;

	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	WebElement password_input;

	@FindBy(xpath = "//*[@id='main']/div/div/section/div/div[4]/button")
	WebElement login_button;

	public Login_Pages(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_SignInPage() {
		Log.info("Method to navigate to Application URL");
		driver.get(prop.getProperty("URL"));
	}

	public void scrollDown() {
		Log.info("Method to scroll down");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
	}

	public void loginToTheApp(String email, String password) throws Exception {
		Log.info("Method to login to the people groove career app");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(singIn_button));
		singIn_button.click();
		wait.until(ExpectedConditions.elementToBeClickable(email_input));
		email_input.sendKeys(email);
		password_input.sendKeys(password);
		scrollDown();
		login_button.click();
	}
}
