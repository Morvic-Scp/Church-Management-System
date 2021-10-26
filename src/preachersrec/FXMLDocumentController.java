/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Morvic
 */
public class FXMLDocumentController implements Initializable {
    @FXML private TextField txtuser;
    @FXML private PasswordField txtpass;
    

    @FXML
    public String myUsernameDetails;
    
    @FXML
    private void changescene(ActionEvent event) throws IOException{
        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
        try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           
           ResultSet rs=st.executeQuery("Select * from UserTable where ID like '"+txtuser.getText()+"'and Password like '"+txtpass.getText()+"'");
           
           if(rs.next()){
            User us=User.getINSTANCE1();
            us.setUsername(txtuser.getText());
            Parent homepage=FXMLLoader.load(getClass().getResource("dashboard.fxml"));
           Scene scene=new Scene(homepage);
           Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
           stage.setOpacity(1);
           stage.setScene(scene);
           stage.show();   
           }else{
               Alert yb=new Alert(Alert.AlertType.WARNING);
               yb.setTitle("Invalid Username or Password");
               yb.setContentText("Invalid Username or Password.");
               yb.show();
               txtpass.setText("");
               txtuser.setText("");
           }
        }catch(SQLException sq){
            
        }
        
       
    }
    
    @FXML
    private void userform(ActionEvent event) throws IOException{
        Parent preloa=FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene scene=new Scene(preloa);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.showAndWait();
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
