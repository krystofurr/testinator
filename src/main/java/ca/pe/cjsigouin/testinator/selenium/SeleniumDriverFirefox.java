/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.selenium;

import ca.pe.cjsigouin.testinator.manager.SeleniumManager;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author krystofurr
 */
public class SeleniumDriverFirefox implements Runnable {

    @Override
    public void run() {
        SeleniumManager.setDriver(new FirefoxDriver());
    }
    
}
