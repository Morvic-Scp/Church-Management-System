/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import com.jfoenix.controls.JFXDatePicker;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Morvic
 */
public class ChurchfinanceController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML private TextField memdues;
    @FXML private TextField thkgiv;
    @FXML private TextField tite;
    @FXML private TextField otherdues;
    @FXML private TextField spoff;
    @FXML private TextField collection;
    @FXML private TextField funDues;
    @FXML private TextField PEs;
    @FXML private TextField titbook;
    @FXML private TextField BapCard;
    @FXML private TextField AnnHarv;
    @FXML private TextField refund;
    @FXML private JFXDatePicker dateP;
    @FXML private Label datel;
    public String usd;
    
    @FXML public void calender(ActionEvent evt){
        dateP.setConverter(new StringConverter<LocalDate>()
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
    private void loadfinance(ActionEvent event){
        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
        User us=User.getINSTANCE1();
         System.out.println("Date is "+dateP.getValue());
     if(!(memdues.getText().isEmpty() || thkgiv.getText().isEmpty() || tite.getText().isEmpty() || spoff.getText().isEmpty() || otherdues.getText().isEmpty() || collection.getText().isEmpty() 
             || funDues.getText().isEmpty() || PEs.getText().isEmpty() || titbook.getText().isEmpty() || BapCard.getText().isEmpty() || AnnHarv.getText().isEmpty() || refund.getText().isEmpty()|| dateP.getValue()==null)){
          try{    
      // Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");    
       Connection conn=DriverManager.getConnection(dbs);
           System.out.println("Connected to Db");
          
           String qr="INSERT INTO financeTable(ID,Date,MembershipDues,ThanksGive,Tithe,SpecialOffering,OtherDues,Collections,FuneralDues,PastorsElders,TitheBook,BaptismalCard,AnnualHarvest,Refund) VALUES ('"+us.getUsername()+"','"+dateP.getValue()+"','"
                   +memdues.getText()+"','"+thkgiv.getText()+"','"+tite.getText()+"','"+spoff.getText()+"','"+otherdues.getText()+"','"
                   +collection.getText()+"','"+funDues.getText()+"','"+PEs.getText()+"','"+titbook.getText()+"','"+BapCard.getText()+"','"
                   +AnnHarv.getText()+"','"+refund.getText()+"')";
       Statement st=conn.createStatement();
       int rows= st.executeUpdate(qr);
       if (rows>0){
          Alert al=new Alert(Alert.AlertType.CONFIRMATION);
           al.setContentText("Successful");
           Optional<ButtonType>acr=al.showAndWait();
           if(acr.get()==ButtonType.OK){
               memdues.setText("");
            thkgiv.setText("");
            tite.setText("");
            spoff.setText("");
            otherdues.setText("");
            collection.setText("");
            funDues.setText("");
            PEs.setText("");
            titbook.setText("");
            BapCard.setText("");
            AnnHarv.setText("");
            refund.setText("");
           }
       } 
       conn.close();
          }
       catch(SQLException ex){
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
             if(memdues.getText().isEmpty()){
                 memdues.setText("0");
             }if(thkgiv.getText().isEmpty()){
              thkgiv.setText("0");
             } if(tite.getText().isEmpty()){
                 tite.setText("0");
             }if(spoff.getText().isEmpty()){
                 spoff.setText("0");
             }if(otherdues.getText().isEmpty()){
                 otherdues.setText("0");
             }if(collection.getText().isEmpty()){
                 collection.setText("0");
             }if(funDues.getText().isEmpty()){
                 funDues.setText("0");
             }if (PEs.getText().isEmpty()){
                 PEs.setText("0");
             }if(titbook.getText().isEmpty()){
                 titbook.setText("0");
             }if(BapCard.getText().isEmpty()){
                 BapCard.setText("0");
             }if(AnnHarv.getText().isEmpty()){
                 AnnHarv.setText("0");
             }if(refund.getText().isEmpty()){
                 refund.setText("0");
             }if(dateP.getValue()==null){
               Alert al2 =new Alert(Alert.AlertType.WARNING);
                al2.setTitle("Values Needed");
                al2.setHeaderText(null);
                al2.setContentText("Date Field Cannot be empty,Please insert Date");
                al2.show();
                datel.setStyle("-fx-background-color:#d0114a; -fx-text-fill:white;");
             }             
         }else{
         Alert al2 =new Alert(Alert.AlertType.WARNING);
         al2.setTitle("Values Needed");
         al2.setHeaderText(null);
         al2.setContentText("Manually Insert Values");
         al2.show();
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
    
     @FXML
    private void changeExpense(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchexpenses.fxml"));
       Scene scene=new Scene(preloa);
       /*preloa.translateXProperty().set(scene.getWidth());
       parentcontain.getChildren().add(preloa);
       Timeline time=new Timeline();*/
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.setResizable(false);
       stage.show();
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
