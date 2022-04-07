package test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class NewTest {
	public static WebDriver driver;
	
  @Test
  public void f() {
	
	  WebElement city = driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[1]/div/div/input"));
	  city.sendKeys("mumbai");
	  driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[2]/ul/li[1]/div/div/img")).click();
	  WebElement m = driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[2]/div/div/div/div[1]/div/a[1]"));
		m.click();
		//WebElement h = driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[2]/div/div/div/div[1]/div/a[1]"));
		//h.click();
		
	  //WebElement rrr = driver.findElement(By.xpath("//*[@id=\'super-container\']/div[2]/div[4]/div[2]/div[4]/div/div/div[2]/a[1]/div/div[2]/div/img"));
	  //rrr.click();
	  //WebElement l = driver.findElement(By.xpath("//*[@id=\"component-1\"]/section/span/h4"));
	  
	  
	  
	  		//WebElement rrr = driver.findElement(By.cssSelector("img[alt='RRR']"));
		    //rrr.click();
		  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","F:\\Driver\\chromedriver_win32\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  driver = new ChromeDriver(options);
	  driver.get("http://www.bookmyshow.com");
	  driver.manage().window().maximize();
	  
	  
	  
	    }

  @AfterTest
  public void afterTest() {
  }

}

