/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.controller.scene.preferences;

import ca.pe.cjsigouin.testinator.manager.SeleniumManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller for the 'General' tab in Preferences
 * 
 * @author krystofurr
 */
public class GeneralController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(GeneralController.class);

    @FXML private ToggleGroup driverGroup;
    @FXML private RadioButton radioBtn_chrome;
    @FXML private RadioButton radioBtn_firefox;
    @FXML private RadioButton radioBtn_ie;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    @FXML
    private void handleRadioBtnChrome(ActionEvent event) {
        log.info("Current Selenium Web Driver: Google Chrome");

        SeleniumManager.getDriver().toString();
    }
    
    @FXML
    private void handleRadioBtnFirefox(ActionEvent event) {
        log.info("Current Selenium Web Driver: Firefox");

        SeleniumManager.getDriver().toString();
    }
    
    @FXML
    private void handleRadioBtnIE(ActionEvent event) {
        log.info("Current Selenium Web Driver: Internet Explorer");

        SeleniumManager.getDriver().toString();
    }
    
}
