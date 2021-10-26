/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXComboBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Morvic
 */
public class SignupController implements Initializable {
    @FXML private TextField user;    
    @FXML private PasswordField pass;
    @FXML private TextField name;
    @FXML private TextField othername;
    @FXML private TextField phone;
    @FXML private Button sign;



    @FXML 
    public void indivdualSign(ActionEvent event){
        if(user.getText().isEmpty() || pass.getText().isEmpty() || name.getText().isEmpty() || othername.getText().isEmpty() || phone.getText().isEmpty()){
            Alert al=new Alert(Alert.AlertType.ERROR, "Data Submitted is not complete.....");
            al.show();
        }
        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
        try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           String qr="INSERT INTO UserTable(ID,Password,FirstName,OtherNames,Phone) values('"+user.getText()+"','"+pass.getText()+"','"+name.getText()+"','"+othername.getText()+"','"+ phone.getText()+"')";
           
       Statement sti=conn.createStatement();
       int rows= sti.executeUpdate(qr);
       if (rows>0){
           System.out.println("Recod success");
           Alert ar=new Alert(Alert.AlertType.INFORMATION, "Successful");
           ar.setTitle("Sign UP");
           ar.showAndWait();
       } 
       conn.close();
        
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    } 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
