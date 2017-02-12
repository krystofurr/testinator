/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.controller.scene;

import ca.pe.cjsigouin.testinator.AppConfig;
import ca.pe.cjsigouin.testinator.SceneConfig;
import ca.pe.cjsigouin.testinator.manager.SceneManager;
import ca.pe.cjsigouin.testinator.selenium.CustomTestHandler;
import ca.pe.cjsigouin.testinator.selenium.SeleniumDriverChrome;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author krystofurr
 */
public class MainController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @FXML private VBox vBox; // Root container
    @FXML private AnchorPane masterAnchorPane, detailsAnchorPane;
    @FXML private ScrollPane viewScrollPane;
    
    // Menu Bar
    @FXML private MenuBar menuBar;
    // Under 'File'
    @FXML private MenuItem menuItem_preferences;
    @FXML private MenuItem menuItem_quit;
    // Under 'Help'
    @FXML private MenuItem menuItem_about;
    
    @FXML private Button btnChrome;
    @FXML private Button btnFirefox;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    
    @FXML
    private void handleMenuItemPreferences(ActionEvent event) {
       log.info("Menu Item [Preferences] has been clicked");
       
       // Open the 'Preferences' window

        Stage stage = new Stage();
        stage.initOwner(SceneManager.getStage()); // Child of 'Parent' stage
        stage.setTitle(AppConfig.TITLE_PREFERENCES);
        stage.setScene(SceneManager.getScenes().get(SceneConfig.SCENE_PREFERENCES));
        stage.show();
            // Hide this current window (if this is what you want)
//            ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    @Transactional(value = "transactionManager")
    private void handleMenuItemQuit(ActionEvent event) {

        log.info("Menu Item [Quit] has been clicked");
        System.exit(0);
    }
    
    @FXML
    private void handleButtonChrome(ActionEvent event) {
        log.info("Running Chrome Driver");
        Thread selenium = new Thread(new SeleniumDriverChrome(new CustomTestHandler("http://www.google.ca")));
        selenium.start();
    }
    
    @FXML
    private void handleButtonFirefox(ActionEvent event) {
        log.info("Running Firefox Driver");
        
    }
    
}
