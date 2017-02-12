/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.selenium;

import ca.pe.cjsigouin.testinator.bean.SeleniumTestBean;
import ca.pe.cjsigouin.testinator.manager.SeleniumManager;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author krystofurr
 */
public class SeleniumDriverChrome implements Runnable {

    private TestHandler handler;
    private SeleniumTestBean test;
    
    public SeleniumDriverChrome(TestHandler handler) {
        this.handler = handler;
    }
    
    @Override
    public void run() {
        SeleniumManager.setDriver(new ChromeDriver());
        handler.execute(test);
        SeleniumManager.getDriver().close();
    }
    
}
