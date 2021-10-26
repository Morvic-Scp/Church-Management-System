/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Morvic
 */
public class ChurchexpensesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TextField utilities;
    @FXML private TextField allowance;
    @FXML private TextField charity;
    @FXML private TextField tithe;
    @FXML private TextField transport;
    @FXML private TextField others;
    @FXML private JFXDatePicker datePx;
    @FXML private Label datele;
    
    @FXML public void calender(ActionEvent evt){
        datePx.setConverter(new StringConverter<LocalDate>()
{
    private DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString(LocalDate localDate)
    {
        if(localDate==null)
            return "";
        return dateTimeFormatter.format(localDate);
    }

    @Override
    public LocalDate fromString(String dateString)
    {
        if(dateString==null || dateString.trim().isEmpty())
        {
            return null;
        }
        return LocalDate.parse(dateString,dateTimeFormatter);
    }
});
    }
    
        @FXML
    private void changefin22(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchfinance.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
    }
         
    @FXML private void Expensescount(ActionEvent event){
         User us=User.getINSTANCE1();
     String dbs="jdbc:ucanaccess://preacherfinance.accdb";
     if(!(utilities.getText().isEmpty() || allowance.getText().isEmpty() || charity.getText().isEmpty() || tithe.getText().isEmpty() || transport.getText().isEmpty() || others.getText().isEmpty()|| datePx.getValue()==null)){
          try{   
         Connection conn=DriverManager.getConnection(dbs);
           System.out.println("Connected to Db");
           String qr="INSERT INTO Expensce(ID,Date,utilities,allowance,charity,titheBook,transport,others) VALUES ('"+us.getUsername()+"','"+datePx.getValue()+"','"+utilities.getText()+"','"+allowance.getText()+"','"+charity.getText()
                  +"','"+tithe.getText()+"','"+transport.getText()+"','"+others.getText()+"')";
             Statement st=conn.createStatement();
       int rows= st.executeUpdate(qr);
       if (rows>0){
           Alert al=new Alert(Alert.AlertType.CONFIRMATION);
           al.setContentText("Successful");
           Optional<ButtonType>acr=al.showAndWait();
           if(acr.get()==ButtonType.OK){
               utilities.setText("");
                 allowance.setText("");
                 charity.setText("");
                 tithe.setText("");
                 transport.setText("");
                 others.setText("");
           }
       } 
       conn.close();
       
          }catch(SQLException ex){
          Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(ex.toString());
           tr.show();
          }
     }else{
         Alert al =new Alert(Alert.AlertType.CONFIRMATION);
         al.setTitle("Missing Values");
         al.setHeaderText(null);
         al.setContentText("Values Missing, Would you Like the Program to Insert Missing Values..?");
         Optional<ButtonType> actm= al.showAndWait();
         
         if(actm.get()==ButtonType.OK){
             if(utilities.getText().isEmpty()){
                 utilities.setText("0");
             }
             if(allowance.getText().isEmpty()){
                 allowance.setText("0");
             }
             if(charity.getText().isEmpty()){
                 charity.setText("0");
             }
             if(tithe.getText().isEmpty()){
                 tithe.setText("0");
             }
             if(transport.getText().isEmpty()){
                 transport.setText("0");
             }
             if(others.getText().isEmpty()){
                 others.setText("0");
             }if(datePx.getValue()==null){
               Alert al2 =new Alert(Alert.AlertType.WARNING);
                al2.setTitle("Values Needed");
                al2.setHeaderText(null);
                al2.setContentText("Date Field Cannot be empty,Please insert Date");
                al2.show();
                datele.setStyle("-fx-background-color:#d0114a; -fx-text-fill:white;");
             }
         }
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
    }    
    
}
