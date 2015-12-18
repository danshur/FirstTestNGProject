package firsttestngpackage;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestNGFile {
	public String baseURL = "http://newtours.demoaut.com/";
	public WebDriver driver = new FirefoxDriver();
	
  @Test
  public void f() {
  }
  
  @Test
  public void verifyHomepageTitle(){
	  driver.get(baseURL);
	  String expectedTitle = "Welcome: Mercury Tours";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(expectedTitle, actualTitle);
	  driver.quit();
  }
}
