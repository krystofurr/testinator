/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.manager;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author krystofurr
 */
public class SeleniumManager implements Runnable {
  
    private static final Logger log = LoggerFactory.getLogger(SeleniumManager.class);

    private static WebDriver driver; // Currently used
    
    public static void loadDriver(String browser, String path) {

        System.setProperty(browser, path);

//        System.setProperty(SeleniumConfig.DRIVER_FIREFOX, "/home/krystofurr/Programs/selenium/geckodriver");
//        System.setProperty(SeleniumConfig.DRIVER_CHROME,  "/home/krystofurr/Programs/selenium/chromedriver");
        
//        drivers.put(SeleniumConfig.DRIVER_FIREFOX, new FirefoxDriver());
//        drivers.put("ie", new InternetExplorerDriver());

//        SeleniumManager.driver = drivers.get(SeleniumConfig.DRIVER_CHROME); // Default: Chrome
        
        
    }  

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        SeleniumManager.driver = driver;
    }

    @Override
    public void run() {
          driver = new ChromeDriver();
        
          //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  //Launch website
	  driver.navigate().to("http://www.google.ca");
          log.info("Thread should be terminated now");
    }
    
    
}
