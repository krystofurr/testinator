/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author krystofurr
 */
@Configuration
@ComponentScan(basePackages = {"ca.pe.cjsigouin.testinator"})
@Import({SpringJpaConfig.class})
public class AppConfig {
    
    public final static String TITLE_APP   = "Testinator";
    public final static String APP_VERSION = "1.0";
    
    public final static int APP_SPLASH_SCREEN_PAUSE = 2500;
    
    // Window Titles
    public final static String TITLE_PREFERENCES = "Preferences";
 
    

}
