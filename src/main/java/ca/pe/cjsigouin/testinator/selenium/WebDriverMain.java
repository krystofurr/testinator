/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverMain {

	public static void main(String[] args) {

	  System.setProperty("webdriver.gecko.driver", "/home/krystofurr/Programs/selenium/geckodriver");
	  System.setProperty("webdriver.chrome.driver", "/home/krystofurr/Programs/selenium/chromedriver");

//	  WebDriver driver = new FirefoxDriver();
	  WebDriver driver = new ChromeDriver();
//	  WebDriver driver = new InternetExplorerDriver();
	  
	  //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  //Launch website
	  driver.navigate().to(CommonConstants.HOST + CommonConstants.URL_LOGIN);
	  
	  driver.findElement(By.id("emailAddress")).sendKeys("cjsigouin@gov.pe.ca");
	  driver.findElement(By.id("password")).sendKeys("Test12345!");
	  driver.findElement(By.id("loginButton")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='serviceWellSection']/div[2]/div/a/b")));
	  
	  driver.get(CommonConstants.HOST + CommonConstants.URL_RESERVE_NAME_INTRO);
	  WebDriverWait wait2 = new WebDriverWait(driver, 5);

	  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(ReserveNameElement.INTRO_BUTTON_CANCEL)));
	  driver.findElement(By.xpath(ReserveNameElement.INTRO_RADIO_RESERVE_NAME)).click();
//	  driver.findElement(By.xpath(ReserveNameElement.INTRO_SELECT_COMPANY_TYPE)).sendKeys("Incorp");
	  
	  Select dropdown = new Select(driver.findElement(By.xpath(ReserveNameElement.INTRO_SELECT_COMPANY_TYPE)));
	  dropdown.selectByVisibleText("Incorporated");
	  driver.findElement(By.xpath(ReserveNameElement.INTRO_BUTTON_NEXT)).click();
	  
	  
//	  WebDriver driver = new FirefoxDriver();
//	  LoginTester login = new LoginTester(driver);
//	  IncorporatedTester tester = new IncorporatedTester(driver);
//
//	  login.start();
	  
	  
	  
	  
	  
//	  //Maximize the browser
//	  driver.manage().window().maximize();
//	  tester.start();
//	  tester.stop();
	  
//	  // Click on Math Calculators
//	  driver.findElement(By.xpath(".//*[@id='hcalc']/table/tbody/tr/td[2]/div[3]/a")).click();
//	  
//	  // Click on Percent Calculators
//	  driver.findElement(By.xpath(".//*[@id='content']/ul[1]/li[3]/a")).click();
//	  
//	  // Enter value 10 in the first number of the percent Calculator
//	  driver.findElement(By.id("cpar1")).sendKeys(data.getNumberText(2));
//	  
//	  // Enter value 50 in the second number of the percent Calculator
//	  driver.findElement(By.id("cpar2")).sendKeys(data.getNumberText(2));
//	  
//	  // Click Calculate Button
//	  driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();
//	
//	  
//	  // Get the Result Text based on its xpath
//	  String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
//	
//	  
//	  // Print a Log In message to the screen
//	  System.out.println(" The Result is " + result);
	  
	  //Close the Browser.
	  driver.close();
	}

}

