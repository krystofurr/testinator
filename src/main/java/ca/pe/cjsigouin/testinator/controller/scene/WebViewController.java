/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.controller.scene;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

/**
 *
 * @author krystofurr
 */
public class WebViewController implements Initializable {
    
    @FXML private AnchorPane anchorPane; // Root container
    @FXML private WebView webView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
}
