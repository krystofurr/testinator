/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.controller.scene;

import ca.pe.cjsigouin.testinator.SceneConfig;
import ca.pe.cjsigouin.testinator.manager.SceneManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author krystofurr
 */
public class IntroController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(IntroController.class);

//    IRestaurantsDAO dao = (IRestaurantsDAO) Main.getContext().getBean("restaurantsDao");
//    IRestaurantsService service = (IRestaurantsService) Main.getContext().getBean("restaurantsService");
    
    @FXML private AnchorPane anchorPane; // Root container
    @FXML private Button btnCreateTest;
    @FXML private Button btnOpenFile;
    @FXML private ListView listView;

    @FXML
    private void handleButtonCreateTest(ActionEvent event) {
        System.out.println("Create Test Clicked");
        SceneManager.getStage().setScene(SceneManager.getScenes().get(SceneConfig.SCENE_MAIN));
    }
    
    @FXML
    private void handleButtonOpenFile(ActionEvent event) {
        System.out.println("Open File Clicked");
        SceneManager.getStage().setScene(SceneManager.getScenes().get(SceneConfig.SCENE_MAIN));
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
}
