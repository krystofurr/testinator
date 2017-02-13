/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.controller.scene;

import ca.pe.cjsigouin.testinator.Main;
import ca.pe.cjsigouin.testinator.SceneConfig;
import ca.pe.cjsigouin.testinator.bean.RestaurantsBean;
import ca.pe.cjsigouin.testinator.dao.IRestaurantsDAO;
import ca.pe.cjsigouin.testinator.exception.BaseServiceException;
import ca.pe.cjsigouin.testinator.manager.SceneManager;
import ca.pe.cjsigouin.testinator.service.IRestaurantsService;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
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

    IRestaurantsDAO dao = (IRestaurantsDAO) Main.getContext().getBean("restaurantsDao");
    IRestaurantsService service = (IRestaurantsService) Main.getContext().getBean("restaurantsService");
    
    @FXML private AnchorPane anchorPane; // Root container
    @FXML private Button btnCreateTest;
    @FXML private Button btnOpenFile;

    @FXML
    private void handleButtonCreateTest(ActionEvent event) {
        System.out.println("Create Test Clicked");
        SceneManager.getStage().setScene(SceneManager.getScenes().get(SceneConfig.SCENE_MAIN));
        
        RestaurantsBean bean = new RestaurantsBean();
//        bean.setId(2);
        bean.setCityName("blah123666");
        bean.setRestName("blah321666");
        try {
            log.info(service.findAll().toString());
            service.create(bean);
            log.info(service.findAll().toString());
        } catch (BaseServiceException ex) {
            java.util.logging.Logger.getLogger(IntroController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
