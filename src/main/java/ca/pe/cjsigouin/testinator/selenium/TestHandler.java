/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.selenium;

import ca.pe.cjsigouin.testinator.bean.SeleniumTestBean;

/**
 *
 * @author krystofurr
 */
public interface TestHandler {
    public void setup();
    public void execute(SeleniumTestBean test);    
}
