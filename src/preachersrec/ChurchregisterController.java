/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Morvic
 */
public class ChurchregisterController implements Initializable {
    @FXML private RadioButton male;
    @FXML private RadioButton female;
    @FXML private TextField Fn;
    @FXML private TextField otn;
    @FXML private TextField age;        
    @FXML private TextField twn;
    @FXML private TextField tel;
    @FXML private TextField email;
    @FXML private JFXComboBox<String> fellows;
    /**
     * Initializes the controller class.
     */
    
     @FXML private void insertRegister(ActionEvent event){
         String dbs="jdbc:ucanaccess://preacherfinance.accdb";
         if(!(Fn.getText().isEmpty() || otn.getText().isEmpty() || age.getText().isEmpty() || twn.getText().isEmpty() || tel.getText().isEmpty() || email.getText().isEmpty()|| fellows.getSelectionModel().isEmpty())){
             if(!(male.isSelected()==false && female.isSelected()==false)){
                 try{    
      // Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
                String gendersex;
                if(male.isSelected()==true){
                    gendersex="Male";
                }else{
                    gendersex="Female";
                }
                    
       Connection conn=DriverManager.getConnection(dbs);
           System.out.println("Connected to Db");
           String qr="INSERT INTO RegisterTable(FirstName,Othername,Age,Town,Telephone,email,Fellowship,Gender) VALUES ('"+Fn.getText()+"','"+otn.getText()+"','"+age.getText()
                  +"','"+twn.getText()+"','"+tel.getText()+"','"+email.getText()+"','"+fellows.getSelectionModel().getSelectedItem()+"','"+gendersex+"')";
             Statement st=conn.createStatement();
       int rows= st.executeUpdate(qr);
       if (rows>0){
          Alert al=new Alert(Alert.AlertType.CONFIRMATION);
           al.setContentText("Successful");
            Optional<ButtonType>acr=al.showAndWait();
           if(acr.get()==ButtonType.OK){
               Fn.setText("");
        otn.setText("");
        age.setText("");
        twn.setText("");
        tel.setText("");
        email.setText("");
        fellows.setValue("");
        male.setSelected(false);
        female.setSelected(false);
           }
       } 
       conn.close();
          }catch(SQLException ex){
              Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(ex.toString());
           tr.show();
              ex.printStackTrace();
          }
             }else{
                  Alert al2 =new Alert(Alert.AlertType.ERROR);
         al2.setTitle("Warning ! ! !");
         al2.setHeaderText(null);
         al2.setContentText("Gender is empty");
         al2.showAndWait();
             }
         
         }else{
         Alert al2 =new Alert(Alert.AlertType.WARNING);
         al2.setTitle("Values Needed");
         al2.setHeaderText(null);
         al2.setContentText("Manually Insert Values");
         al2.showAndWait();
         }
    }
     
    @FXML
    private void backScreen(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("dashboard.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.setResizable(false);
       stage.show();
       
    }
    
    @FXML
    private void registration(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchregister.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.setResizable(false);
       stage.show();
    }
    @FXML
    private void Finance(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchfinance.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.setResizable(false);
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fellows.setItems(observableArrayList("Pastors and Elders","Womens Fellowship","Youth"));
    }    
    
}
