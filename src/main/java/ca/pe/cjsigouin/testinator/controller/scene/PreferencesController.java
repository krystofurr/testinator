/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.controller.scene;

import ca.pe.cjsigouin.testinator.SceneConfig;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A tabbed interface that holds all settings for Testinator
 *
 * @author krystofurr
 */
public class PreferencesController implements Initializable {
    
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @FXML private TabPane tabPane; // Root container
    
    // Tabs
    @FXML private Tab tabGeneral;
    @FXML private Tab tabMisc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            tabGeneral.setContent((Node) FXMLLoader.load(getClass().getResource(SceneConfig.SCENE_PATH_PREFERENCES_GENERAL)));

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PreferencesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
// REF: http://stackoverflow.com/questions/14691138/how-can-i-do-some-action-when-one-specific-tab-is-selected-using-javafx
                    
//        // Tab 'General'
//        tabGeneral.setOnSelectionChanged(new EventHandler<Event>() {
//            @Override
//            public void handle(Event t) {
//                if (tabGeneral.isSelected()) {
//                    log.info("Tab [General] has been clicked");
//                }
//            }
//        });
//        
//        // Tab 'Miscellaneous
//        tabMisc.setOnSelectionChanged(new EventHandler<Event>() {
//            @Override
//            public void handle(Event t) {
//                if (tabMisc.isSelected()) {
//                    log.info("Tab [Miscellaneous] has been clicked");
//                }
//            }
//        });

    }

    @FXML
    private void handleTabGeneral(Event event) {
        if (tabGeneral.isSelected()) {
            log.info("Tab [General] has been clicked");
        }   
    }

    @FXML
    private void handleTabMisc(Event event) {
        if (tabMisc.isSelected()) {
            log.info("Tab [Miscellaneous] has been clicked");
        }
    }
}
