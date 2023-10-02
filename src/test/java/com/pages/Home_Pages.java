package com.pages;

import com.driver.Driver;
import com.utilities.Log;
import com.utilities.ReadPropertiesFile;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Home_Pages extends Driver{
	public static final String filename = null;
	public ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	public Properties prop = readPropertiesFile.readPropertiesFile(filename);
	@FindBy(xpath = "//*[@id='navlist-ele-1']/button")
	WebElement careerButton_Menu;
	
	@FindBy(id = "tab-option-1")
	WebElement jobs_submenu;

	@FindBy(id = "tab-option-0")
	WebElement careerPaths_submenu;
	
	@FindBy(xpath = "//*[@id='tabpanel-all']/div/div[1]/div[2]/div[1]")
	WebElement jobCard;

	@FindBy(xpath = "//button[text()='Ask a Question']")
	WebElement askAQuestion_Button;

	@FindBy(id = "connection")
	WebElement recommendedConnection;

	@FindBy(xpath = "//*[@id='message-widget-edit-container']/div[1]/div/div[1]/div/p")
	WebElement messageText;

	@FindBy(xpath = "//button[text()='Keep the Convo Going!']")
	WebElement keepConvoGoingButton;

	@FindBy(xpath = "//*[@id='message-widget-edit-container']/div[2]/button")
	WebElement sendButton;

	@FindBy(xpath = "//*[@id=\"inbox__msg-list\"]/ul/li[2]/div/div[2]/div[1]")
	WebElement TextMessage_verification;

	@FindBy(xpath = "//span[text()='View Profile']")
	WebElement viewProfileButton;

	@FindBy(xpath = "//h2[text()='Inspiration for you']/../../../div[2]/a[1]")
	WebElement inspirationForYou;

	@FindBy(xpath = "//span[text()='Career Paths']")
	WebElement careerPaths_breadCrumb;

	@FindBy(xpath = "//*[@id='main']/div/div/div[1]/div[1]/div/div[2]/span[2]")
	WebElement breadCrumb_inspire;

	public Home_Pages(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void scrollDown() {
		Log.info("Method to scroll down");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2500)", "");
	}

	public void navigateTo_JobCard() {
		Log.info("Method to navigate to career page and jobcard");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(careerButton_Menu));
		Actions actions = new Actions(driver);
		// Hover over the element
		actions.moveToElement(careerButton_Menu).perform();
		wait.until(ExpectedConditions.elementToBeClickable(jobs_submenu));
		jobs_submenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(jobCard));
		jobCard.click();
		wait.until(ExpectedConditions.elementToBeClickable(recommendedConnection));
		recommendedConnection.click();
		wait.until(ExpectedConditions.elementToBeClickable(askAQuestion_Button));
		askAQuestion_Button.click();
		wait.until(ExpectedConditions.elementToBeClickable(messageText));
		messageText.click();
		messageText.sendKeys("Dinesh");
		messageText.sendKeys(Keys.ENTER);
		messageText.sendKeys("5 years of exp");
		sendButton.click();
		keepConvoGoingButton.click();
		TextMessage_verification.isDisplayed();
	}

	public void navigateTo_CareerPath() throws InterruptedException {
		Log.info("Method to navigate to career page and jobcard");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(careerButton_Menu));
		Actions actions = new Actions(driver);
		// Hover over the element
		actions.moveToElement(careerButton_Menu).perform();
		wait.until(ExpectedConditions.elementToBeClickable(careerPaths_submenu));
		careerPaths_submenu.click();
		Thread.sleep(5000);
		scrollDown();
		for(int i=1; i<=3;i++) {
			System.out.println(i);
			driver.findElement(By.xpath("//h2[text()='Inspiration for you']/../../../div[2]/a["+i+"]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(careerPaths_breadCrumb));
			careerPaths_breadCrumb.click();
			wait.until(ExpectedConditions.elementToBeClickable(breadCrumb_inspire));
			String inspireForYouText = breadCrumb_inspire.getText();
			List<String> values  = new LinkedList<>();
			values.add(inspireForYouText);
		}
	}
}
