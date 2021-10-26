/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Morvic
 */
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private void exitScreen(ActionEvent event){
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.close();
       
    }
    
    @FXML
    private void registration(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchregister.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.show();
    }
    @FXML
    private void Finance(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchfinance.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.show();
    }
    @FXML
    private void recordsSafe(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchtablerecords.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.setResizable(true);
       stage.show(); 
    }
    
        @FXML
    private void changefin(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchfinance.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
