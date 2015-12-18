
package firsttestngpackage;

import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestNGFile {
	public String baseURL = "http://newtours.demoaut.com/";
	public WebDriver driver = new FirefoxDriver();
	String expected = null;
	String actual = null;

	@BeforeTest
	public void launchBrowser() {
		driver.get(baseURL);
	}
	
	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Test(priority = 10, enabled = true)
	public void register(){
		driver.findElement(By.linkText("REGISTER")).click();
		String expected = "Register: Mercury Tours";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		
	}
	@Test(priority = 20, enabled = true)
	public void support(){
		driver.findElement(By.linkText("SUPPORT")).click();
		String expected = "Under Construction: Mercury Tours";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 100, enabled = true)
	public void skip() {
		throw new SkipException("skipping f test");
	}
	
	
	@Test(priority = 110, enabled = true)
	public void pass() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 120, enabled = true)
	public void fail() {
		Assert.fail("failed on purpose");;
	}

	@AfterTest
	public void killBrowser() {
		driver.quit();
	}
	@AfterMethod
	public void backtoHomepage() {
		driver.findElement(By.linkText("Home")).click();
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
}
