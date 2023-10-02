package com.tests;

import com.driver.Driver;
import com.pages.Home_Pages;
import com.pages.Login_Pages;
import com.utilities.Log;
import com.utilities.ReadPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.properties.PropertiesConfigurationBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class PeopleGrooveAssignmentTest extends Driver{

	public static final String filename = null;
	public ReadPropertiesFile readfile = new ReadPropertiesFile();
	public Properties prop = readfile.readPropertiesFile(filename);
	public Login_Pages login_pages;
	public Home_Pages  home_pages;

	@BeforeClass(alwaysRun=true)
	public void pageInstantiation() throws Exception {
		Log.info("Inside before class ");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd_HH_mm_ss");
		Date date= new Date();
		String reportDir = dateFormat.format(date);
		System.setProperty("log_dir",reportDir + "//logs//testlog.log");
		File file = new File(System.getProperty("user.dir") + "//properties//log4j.properties");
		Properties properties = new Properties();
		try (InputStream inputStream = new FileInputStream(file)) {
		properties.load(inputStream);
		}
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		Configuration config = new PropertiesConfigurationBuilder()
		.setConfigurationSource(ConfigurationSource.NULL_SOURCE).setRootProperties(properties)
		.setLoggerContext(context).build();
		context.setConfiguration(config);
		Configurator.initialize(config);
		login_pages = new Login_Pages(driver);
		home_pages = new Home_Pages(driver);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void init() throws InterruptedException {
		Log.info("Inside before method ");
		Driver.init(prop.getProperty("Browser"));
		login_pages.navigateTo_SignInPage();
	}
	
	@Test(priority = 1)
	public void assignment1Test() throws Exception {
		Log.info("Test Started ");
		login_pages = new Login_Pages(driver);
		home_pages = new Home_Pages(driver);
		login_pages.loginToTheApp("dhineshmqa@gmail.com","Automation@123");
		home_pages.navigateTo_JobCard();
		Log.info("Test Ended ");
	}

	@Test(priority = 1)
	public void assignment2Test() throws Exception {
		Log.info("Test Started ");
		login_pages = new Login_Pages(driver);
		home_pages = new Home_Pages(driver);
		login_pages.loginToTheApp("dhineshmqa@gmail.com","Automation@123");
		home_pages.navigateTo_CareerPath();
		Log.info("Test Ended ");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		Log.info("Inside After Method");
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
				System.out.println("Screenshot taken");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@AfterClass
	public void quit() {
		Log.info("Inside After Class");
		driver.quit();
	}
}