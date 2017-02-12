/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.controller.scene;

import ca.pe.cjsigouin.testinator.Main;
import ca.pe.cjsigouin.testinator.SceneConfig;
import ca.pe.cjsigouin.testinator.manager.SceneManager;
import ca.pe.cjsigouin.testinator.model.Restaurants;
import ca.pe.cjsigouin.testinator.service.IRestaurantsService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author krystofurr
 */
public class IntroController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(IntroController.class);

    IRestaurantsService service = (IRestaurantsService) Main.getContext().getBean("restaurantsService");
    
    @FXML private AnchorPane anchorPane; // Root container
    @FXML private Button btnCreateTest;
    @FXML private Button btnOpenFile;

    @FXML
    private void handleButtonCreateTest(ActionEvent event) {
        System.out.println("Create Test Clicked");
        SceneManager.getStage().setScene(SceneManager.getScenes().get(SceneConfig.SCENE_MAIN));
        
        Restaurants restaurant = new Restaurants();
        restaurant.setCityName("testing123");
        restaurant.setRestName("testing321");
        service.create(restaurant);
        log.info(service.findAll().toString());
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
