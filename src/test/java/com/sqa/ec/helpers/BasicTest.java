package com.sqa.ec.helpers;

import java.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

import com.sqa.ec.auto.*;

public class BasicTest extends Core
{

	public BasicTest(String baseUrl)
	{
		super(baseUrl);
	}

	@BeforeClass(enabled = true)
	public void setUpChrome()
	{
		// Set system property to use Chrome driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		// Setup the driver to use Chrome
		System.out.println("Before Setting Chrome Driver");
		setDriver(new ChromeDriver());
		System.out.println("After setting Chrome Driver");
		// Set the base URL for this test
		// this.baseUrl = "https://www.amazon.com/";
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		getDriver().get(getBaseURL());
	}

	@BeforeClass(enabled = false)
	public void setUpFirefox()
	{
		// Setup the driver to use Firefox
		System.out.println("Before Setting FF Driver");
		setDriver(new FirefoxDriver());
		System.out.println("After setting FF Driver");
		// Set the base URL for this test
		// this.baseUrl = "https://www.amazon.com/";
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		getDriver().get(getBaseURL());
	}

	@BeforeClass(enabled = false)
	public void setUpSafari()
	{
		// Setup the driver to use Safari
		System.out.println("Before Setting Safari Driver");
		setDriver(new SafariDriver());
		System.out.println("After setting Safari Driver");
		// Set the base URL for this test
		// this.baseUrl = "https://www.amazon.com/";
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		getDriver().get(getBaseURL());
	}

	/*
	 * @BeforeClass(enabled = false) public void setUpIE() throws Exception {
	 * System.out.println("Setup IE"); // Set system property to use IE driver
	 * System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
	 * // Setup the driver to use IE setDriver(new InternetExplorerDriver()); //
	 * Set an implicit wait of up to 30 seconds
	 * getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //
	 * Maximize the window getDriver().manage().window().maximize(); }
	 */
	@AfterClass
	public void tearDown()
	{
		// quit closes all instances of the browser.
		getDriver().quit();
		// close method would close current instance only.
		// ex: driver.close();
	}
}
