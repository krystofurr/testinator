/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.manager;

import ca.pe.cjsigouin.testinator.SceneConfig;
import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author krystofurr
 */
public class SceneManager {
    
    private static final Logger log = LoggerFactory.getLogger(SceneManager.class);

    public static Stage stage;
    private static HashMap<String, Scene> scenes;
    public Parent splash, intro, main, preferences;

    public SceneManager(Stage stage) {
        SceneManager.stage = stage;
    }
    
    public void loadScenes() {
        
        if(scenes == null) {
            scenes = new HashMap<>();
        
            try {
                splash      = FXMLLoader.load(getClass().getResource(SceneConfig.SCENE_PATH_SPLASH));
                intro       = FXMLLoader.load(getClass().getResource(SceneConfig.SCENE_PATH_INTRO));
                main        = FXMLLoader.load(getClass().getResource(SceneConfig.SCENE_PATH_MAIN));
                preferences = FXMLLoader.load(getClass().getResource(SceneConfig.SCENE_PATH_PREFERENCES));

    //        Parent reportScene = FXMLLoader.load(getClass().getResource(SCREEN_PATH_REPORT));
    //        Parent testCreationScene = FXMLLoader.load(getClass().getResource(SCREEN_PATH_TEST_CREATION));

                scenes.put(SceneConfig.SCENE_INTRO,       new Scene(intro));
                scenes.put(SceneConfig.SCENE_SPLASH,      new Scene(splash));
                scenes.put(SceneConfig.SCENE_MAIN,        new Scene(main));
                scenes.put(SceneConfig.SCENE_PREFERENCES, new Scene(preferences));

//                scenes.put("report", new Scene(report));
//                scenes.put("testCreation", new Scene(testCreation));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static HashMap<String, Scene> getScenes() {
        return scenes;
    }

    public static Stage getStage() {
        return stage;
    }
}
