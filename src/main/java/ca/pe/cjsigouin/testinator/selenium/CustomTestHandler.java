/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.selenium;

import ca.pe.cjsigouin.testinator.bean.SeleniumTestBean;
import ca.pe.cjsigouin.testinator.manager.SeleniumManager;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author krystofurr
 */
public class CustomTestHandler implements TestHandler {

    private String targetUrl;
    
    public CustomTestHandler(String targetUrl) {
        this.targetUrl = targetUrl;
    }
    
    @Override
    public void setup() {
        
    }

    @Override
    public void execute(SeleniumTestBean test) {
       //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        SeleniumManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        SeleniumManager.getDriver().navigate().to(targetUrl);

    }
    
}
