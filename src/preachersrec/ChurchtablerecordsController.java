/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Morvic
 */
public class ChurchtablerecordsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private TableView<financesub> financetbl;
    @FXML private TableView<expenseSub> expensetbl;
    @FXML private TableView<registrationSub> registertbl;   
    @FXML private TableView<ObservableList<String>> usertbl;
    //Expense Table
     @FXML private TableColumn<expenseSub,String> tableid;
    @FXML private TableColumn<expenseSub, Integer> tableutilities;
    @FXML private TableColumn<expenseSub, Integer> tableallowance;
    @FXML private TableColumn<expenseSub, Integer> tablecharity;
    @FXML private TableColumn<expenseSub, Integer> tabletitbook;
    @FXML private TableColumn<expenseSub, Integer> tabletransport;
    @FXML private TableColumn<expenseSub, Integer> tableothers;
    @FXML private TableColumn<expenseSub, Date> tableDate;
    
    //Register Table
    @FXML private TableColumn<registrationSub, String> registerfname;
    @FXML private TableColumn<registrationSub, String> registerothname;
    @FXML private TableColumn<registrationSub, String> registerage;
    @FXML private TableColumn<registrationSub, String> registertwn;
    @FXML private TableColumn<registrationSub, String> registerphne;
    @FXML private TableColumn<registrationSub, String> registeremail;
    @FXML private TableColumn<registrationSub, String> registerfellow;
    @FXML private TableColumn<registrationSub, String> registergender;
    
    //Finance Table
    @FXML private TableColumn<financesub, String> financeid;
    @FXML private TableColumn<financesub, Integer> financememdues;
    @FXML private TableColumn<financesub, Integer> financethkgiving;
    @FXML private TableColumn<financesub, Integer> financetithe;
    @FXML private TableColumn<financesub, Integer>financespecoff;
    @FXML private TableColumn<financesub, Integer> financeotherdues;
    @FXML private TableColumn<financesub, Integer> financecollect;
    @FXML private TableColumn<financesub, Integer> financefnndues;
    @FXML private TableColumn<financesub, Integer> financepe;
    @FXML private TableColumn<financesub, Integer> financetithbk;
    @FXML private TableColumn<financesub, Integer> financebapcard;
    @FXML private TableColumn<financesub, Integer> financeharvest;
    @FXML private TableColumn<financesub, Integer> financerefund;
    @FXML private TableColumn<financesub, Date> financeDate;


    @FXML private ComboBox<String> tablename;
    @FXML private Button financebtn;
    @FXML private Button expensebtn;
    @FXML private Button userbtn;
    @FXML private Button deletebtn;
    @FXML private Button updatebtn;
    @FXML private Button searchbtn;    
    @FXML private Button registerbtn;
    @FXML private MenuBar mdmenu;
    @FXML private TextField searchfield;
    

    ObservableList row;
    ObservableList<financesub> data;
    ObservableList row2;
    ObservableList<registrationSub> data2;
    ObservableList row1;
    ObservableList<expenseSub> data1;
    ObservableList row3;
    ObservableList data3;
    int index=-1;
    int index1=-1;
    int index2=-1;
     updateclass upd=updateclass.getupdateInstance();
    
    @FXML
    public void showexpenstbl(ActionEvent event){
        expensetbl.setVisible(true);
        registertbl.setVisible(false);
        financetbl.setVisible(false);
        usertbl.setVisible(false);
        expensebtn.setDisable(true);
        expensebtn.setCursor(Cursor.DISAPPEAR);
        financebtn.setDisable(false);
        financebtn.setCursor(Cursor.HAND);
        userbtn.setDisable(false);
        userbtn.setCursor(Cursor.HAND);
        registerbtn.setDisable(false);
        registerbtn.setCursor(Cursor.HAND);        

    }
    
    @FXML
    public void showusertbl(ActionEvent event){
        expensetbl.setVisible(false);
        registertbl.setVisible(false);
        financetbl.setVisible(false);
        usertbl.setVisible(true);
        expensebtn.setDisable(false);
        expensebtn.setCursor(Cursor.HAND);
        financebtn.setDisable(false);
        financebtn.setCursor(Cursor.HAND);
        userbtn.setDisable(true);
        userbtn.setCursor(Cursor.DISAPPEAR);
        registerbtn.setDisable(false);
        registerbtn.setCursor(Cursor.HAND);        

    }
    
    public void showfinancetbl(ActionEvent event){
        expensetbl.setVisible(false);
        registertbl.setVisible(false);
        financetbl.setVisible(true);
        usertbl.setVisible(false);
        expensebtn.setDisable(false);
        expensebtn.setCursor(Cursor.HAND);
        financebtn.setDisable(true);
        financebtn.setCursor(Cursor.NONE);
        userbtn.setDisable(false);
        userbtn.setCursor(Cursor.HAND);
        registerbtn.setDisable(false);
        registerbtn.setCursor(Cursor.HAND);     
    }
    
    public void showregistertbl(ActionEvent event){
        expensetbl.setVisible(false);
        registertbl.setVisible(true);
        financetbl.setVisible(false);
        usertbl.setVisible(false);
        expensebtn.setDisable(false);
        expensebtn.setCursor(Cursor.HAND);
        financebtn.setDisable(false);
        financebtn.setCursor(Cursor.HAND);
        userbtn.setDisable(false);
        userbtn.setCursor(Cursor.HAND);
        registerbtn.setDisable(true);
        registerbtn.setCursor(Cursor.DISAPPEAR); 
        
    }
    @FXML
    public void combosty(ActionEvent evt){
        if(tablename.getSelectionModel().getSelectedItem()=="Finance"){
        expensetbl.setVisible(false);
        registertbl.setVisible(false);
        financetbl.setVisible(true);
        usertbl.setVisible(false);
        expensebtn.setDisable(false);
        expensebtn.setCursor(Cursor.HAND);
        financebtn.setDisable(true);
        financebtn.setCursor(Cursor.NONE);
        userbtn.setDisable(false);
        userbtn.setCursor(Cursor.HAND);
        registerbtn.setDisable(false);
        registerbtn.setCursor(Cursor.HAND);     
        }else if(tablename.getSelectionModel().getSelectedItem()=="Register"){
             expensetbl.setVisible(false);
        registertbl.setVisible(true);
        financetbl.setVisible(false);
        usertbl.setVisible(false);
        expensebtn.setDisable(false);
        expensebtn.setCursor(Cursor.HAND);
        financebtn.setDisable(false);
        financebtn.setCursor(Cursor.HAND);
        userbtn.setDisable(false);
        userbtn.setCursor(Cursor.HAND);
        registerbtn.setDisable(true);
        registerbtn.setCursor(Cursor.DISAPPEAR); 
        }else if(tablename.getSelectionModel().getSelectedItem()=="Expense"){
         expensetbl.setVisible(true);
        registertbl.setVisible(false);
        financetbl.setVisible(false);
        usertbl.setVisible(false);
        expensebtn.setDisable(true);
        expensebtn.setCursor(Cursor.DISAPPEAR);
        financebtn.setDisable(false);
        financebtn.setCursor(Cursor.HAND);
        userbtn.setDisable(false);
        userbtn.setCursor(Cursor.HAND);
        registerbtn.setDisable(false);
        registerbtn.setCursor(Cursor.HAND);     
        }else if(tablename.getSelectionModel().getSelectedItem()=="User"){
        expensetbl.setVisible(false);
        registertbl.setVisible(false);
        financetbl.setVisible(false);
        usertbl.setVisible(true);
        expensebtn.setDisable(false);
        expensebtn.setCursor(Cursor.HAND);
        financebtn.setDisable(false);
        financebtn.setCursor(Cursor.HAND);
        userbtn.setDisable(true);
        userbtn.setCursor(Cursor.DISAPPEAR);
        registerbtn.setDisable(false);
        registerbtn.setCursor(Cursor.HAND);  
        }
    }
    
    void refresh(){
        
        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
                try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery("Select * from Expensce");
           
            data1 = FXCollections.observableArrayList();
            SimpleDateFormat frmtter=new SimpleDateFormat("dd/mm/yyyy");
            
            while(rs.next()){
                //Iterate Row
                data1.add(new expenseSub(rs.getString("ID"), rs.getDate("Date"),rs.getInt("utilities"), rs.getInt("allowance"), rs.getInt("charity"), rs.getInt("titheBook"), rs.getInt("transport"), rs.getInt("others")));
            }
            upd.setPassexpense(data1);
            tableid.setCellValueFactory(new PropertyValueFactory<>("ID"));
            tableDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            tableutilities.setCellValueFactory(new PropertyValueFactory<>("utilities"));
            tableallowance.setCellValueFactory(new PropertyValueFactory<>("allow"));
            tablecharity.setCellValueFactory(new PropertyValueFactory<>("charity"));
            tabletitbook.setCellValueFactory(new PropertyValueFactory<>("tithebook"));
            tabletransport.setCellValueFactory(new PropertyValueFactory<>("transportation"));
            tableothers.setCellValueFactory(new PropertyValueFactory<>("others"));
            
             
            //FINALLY ADDED TO TableView
        expensetbl.setItems(data1);
        
        } catch (SQLException ex) {
            
        }
                
        try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery("Select * from RegisterTable");
           
            data2 = FXCollections.observableArrayList();
            

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
               data2.add(new registrationSub(rs.getString("Firstname"), rs.getString("Othername"), rs.getString("Age"), rs.getString("Town"), rs.getString("Telephone"), rs.getString("email"), rs.getString("Fellowship"), rs.getString("Gender")));
            }
            upd.setPassregister(data2);
            registerfname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            registerothname.setCellValueFactory(new PropertyValueFactory<>("otherName"));
            registerage.setCellValueFactory(new PropertyValueFactory<>("Age"));
            registertwn.setCellValueFactory(new PropertyValueFactory<>("town"));
            registerphne.setCellValueFactory(new PropertyValueFactory<>("telnumber"));
            registeremail.setCellValueFactory(new PropertyValueFactory<>("email"));
            registerfellow.setCellValueFactory(new PropertyValueFactory<>("fellowship"));
            registergender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            

            //FINALLY ADDED TO TableView
        registertbl.setItems(data2);
        
        } catch (SQLException ex) {
            
        }
        try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery("Select * from financeTable");
           
            data = FXCollections.observableArrayList();
            
            while(rs.next()){
                //Iterate Row
               data.add(new financesub(rs.getString("ID"),rs.getDate("Date"), rs.getInt("MembershipDues"), rs.getInt("ThanksGive"), rs.getInt("Tithe"), rs.getInt("SpecialOffering"), rs.getInt("OtherDues"), rs.getInt("Collections"), rs.getInt("FuneralDues"), rs.getInt("PastorsElders"), rs.getInt("TitheBook"), rs.getInt("BaptismalCard"), rs.getInt("AnnualHarvest"), rs.getInt("Refund")));
            }
            upd.setPassfinance(data);
            financeid.setCellValueFactory(new PropertyValueFactory<>("Id"));
            financeDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            financememdues.setCellValueFactory(new PropertyValueFactory<>("membershipDues"));
            financethkgiving.setCellValueFactory(new PropertyValueFactory<>("thanksgiving"));
            financetithe.setCellValueFactory(new PropertyValueFactory<>("tithe"));
            financespecoff.setCellValueFactory(new PropertyValueFactory<>("specOffering"));
            financeotherdues.setCellValueFactory(new PropertyValueFactory<>("otherdues"));
            financecollect.setCellValueFactory(new PropertyValueFactory<>("Collections"));
            financefnndues.setCellValueFactory(new PropertyValueFactory<>("funeraldues"));
            financepe.setCellValueFactory(new PropertyValueFactory<>("pe"));
            financetithbk.setCellValueFactory(new PropertyValueFactory<>("tithebook"));
            financebapcard.setCellValueFactory(new PropertyValueFactory<>("bapcard"));
            financeharvest.setCellValueFactory(new PropertyValueFactory<>("annualharvest"));
            financerefund.setCellValueFactory(new PropertyValueFactory<>("refund"));
            

            //FINALLY ADDED TO TableView
        financetbl.setItems(data);
        
        } catch (SQLException ex) {
            
        }
        
        try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery("Select * from UserTable");
           
            data3 = FXCollections.observableArrayList();
            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
                for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col1 = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col1.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                usertbl.getColumns().addAll(col1);
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList row3 = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row3.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row3);
                data3.add(row3);
            }

            //FINALLY ADDED TO TableView
        usertbl.setItems(data3);
        
        } catch (SQLException ex) {
            
        }
        
        searchbar();
    }
    
    @FXML
    void getselectedfinanceitem(MouseEvent event) throws IOException {
        index=financetbl.getSelectionModel().getSelectedIndex();
        upd.setIndex(index);
        ObservableList<financesub> finfield=FXCollections.observableArrayList();
        finfield.add(new financesub(financeid.getCellData(index), financeDate.getCellData(index), financememdues.getCellData(index), financethkgiving.getCellData(index),
                financetithe.getCellData(index), financespecoff.getCellData(index), financeotherdues.getCellData(index), financecollect.getCellData(index), 
                financefnndues.getCellData(index), financepe.getCellData(index), financetithbk.getCellData(index), financebapcard.getCellData(index), 
                financeharvest.getCellData(index), financerefund.getCellData(index)));
        
        if(index<=-1){
            return;
        }
        if(event.getClickCount()==2){
        System.out.println(finfield.toString());
        
        upd.setFieldFinance(finfield);
        upd.setAnchorexphide(false);
        upd.setAnchorfinhide(true);
        upd.setAnchorreghide(false);
        
        Parent preloa=FXMLLoader.load(getClass().getResource("Recordsupdatetable.fxml"));
        Scene scene=new Scene(preloa);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.showAndWait();
        if(upd.isBtnpressed()){
            refresh();
            upd.setBtnpressed(false);
        }
        }
    }
    
    @FXML
    void getselectedexpenseitem(MouseEvent event) throws IOException {
        index=expensetbl.getSelectionModel().getSelectedIndex();
        upd.setIndex(index);
        ObservableList<expenseSub> expfield=FXCollections.observableArrayList();
        expfield.add(new expenseSub(tableid.getCellData(index), tableDate.getCellData(index), tableutilities.getCellData(index), 
                tableallowance.getCellData(index), tablecharity.getCellData(index), tabletitbook.getCellData(index), tabletransport.getCellData(index), 
                tableothers.getCellData(index)));
        
        if(index<=-1){
            return;
        }
        if(event.getClickCount()==2){
       // System.out.println(expfield.toString());
        
        upd.setFieldexpense(expfield);
        upd.setAnchorexphide(true);
        upd.setAnchorfinhide(false);
        upd.setAnchorreghide(false);
        
        Parent preloa=FXMLLoader.load(getClass().getResource("Recordsupdatetable.fxml"));
        Scene scene=new Scene(preloa);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.showAndWait();
        if(upd.isBtnpressed()){
            refresh();
            upd.setBtnpressed(false);
        }
        }
    }
    
    @FXML
    void getselectedregisteritem(MouseEvent event) throws IOException {
        index=registertbl.getSelectionModel().getSelectedIndex();
        upd.setIndex(index);
        ObservableList<registrationSub> regfield=FXCollections.observableArrayList();
        regfield.add(new registrationSub(registerfname.getCellData(index), registerothname.getCellData(index), registerage.getCellData(index), 
                registertwn.getCellData(index), registerphne.getCellData(index), registeremail.getCellData(index), registerfellow.getCellData(index), 
                registergender.getCellData(index)));
        
        
        if(index<=-1){
            return;
        }
        if(event.getClickCount()==2){
       // System.out.println(expfield.toString());
        
        upd.setFieldregister(regfield);
        upd.setAnchorexphide(false);
        upd.setAnchorfinhide(false);
        upd.setAnchorreghide(true);
        
        Parent preloa=FXMLLoader.load(getClass().getResource("Recordsupdatetable.fxml"));
        Scene scene=new Scene(preloa);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.showAndWait();
        if(upd.isBtnpressed()){
            refresh();
            upd.setBtnpressed(false);
        }
        }
    }
    
    
    
    
    @FXML
    private void updatetblx(ActionEvent event) throws IOException{
        upd.setFieldFinance(null);
        upd.setFieldexpense(null);
        upd.setFieldregister(null);        
        Parent preloa=FXMLLoader.load(getClass().getResource("Recordsupdatetable.fxml"));
        Scene scene=new Scene(preloa);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.showAndWait();
       if(upd.isBtnpressed()){
            refresh();
            upd.setBtnpressed(false);
        }
    }
    
    @FXML
    private void exitScreen(ActionEvent event){
       Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
       stage.close();
       
    }
    @FXML
    private void backScreen(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("dashboard.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)mdmenu.getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.setResizable(false);
       stage.show();
       
    }
    
    @FXML
    private void registration(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchregister.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)mdmenu.getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.setResizable(false);
       stage.show();
    }
    @FXML
    private void Finance(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchfinance.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)mdmenu.getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.setResizable(false);
       stage.show();
    }
    @FXML
    private void recordsSafe(ActionEvent event) throws IOException{
       Parent preloa=FXMLLoader.load(getClass().getResource("churchtablerecords.fxml"));
       Scene scene=new Scene(preloa);
       Stage stage=(Stage)mdmenu.getScene().getWindow();
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.setResizable(true);
       stage.show();
    }
    @FXML
    private void searchbar(){
         // TODO

        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
                try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery("Select * from Expensce");
           
            data1 = FXCollections.observableArrayList();
            SimpleDateFormat frmtter=new SimpleDateFormat("dd/mm/yyyy");
            
            while(rs.next()){
                //Iterate Row
                data1.add(new expenseSub(rs.getString("ID"), rs.getDate("Date"),rs.getInt("utilities"), rs.getInt("allowance"), rs.getInt("charity"), rs.getInt("titheBook"), rs.getInt("transport"), rs.getInt("others")));
            }
            upd.setPassexpense(data1);
            tableid.setCellValueFactory(new PropertyValueFactory<>("ID"));
            tableDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            tableutilities.setCellValueFactory(new PropertyValueFactory<>("utilities"));
            tableallowance.setCellValueFactory(new PropertyValueFactory<>("allow"));
            tablecharity.setCellValueFactory(new PropertyValueFactory<>("charity"));
            tabletitbook.setCellValueFactory(new PropertyValueFactory<>("tithebook"));
            tabletransport.setCellValueFactory(new PropertyValueFactory<>("transportation"));
            tableothers.setCellValueFactory(new PropertyValueFactory<>("others"));
            
                
             FilteredList<expenseSub> filterdata1=new FilteredList(data1, b->true);
            searchfield.textProperty().addListener((observable,oldValue, newValue)->{
                    filterdata1.setPredicate(valuett1 ->{
                        
                        if(newValue==null || newValue.isEmpty()){
                            return true;
                        } else if(valuett1.getID().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }else if(valuett1.getDate().toString().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }                       
                        else 
                        return false;
    
                        
                    });
                });
            SortedList<expenseSub> sorteddata=new SortedList<>(filterdata1);
            sorteddata.comparatorProperty().bind(expensetbl.comparatorProperty());
             
            //FINALLY ADDED TO TableView
        expensetbl.setItems(sorteddata);
        
        } catch (SQLException ex) {
            
        }
                
        try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery("Select * from RegisterTable");
           
            data2 = FXCollections.observableArrayList();
            

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
               data2.add(new registrationSub(rs.getString("Firstname"), rs.getString("Othername"), rs.getString("Age"), rs.getString("Town"), rs.getString("Telephone"), rs.getString("email"), rs.getString("Fellowship"), rs.getString("Gender")));
            }
            upd.setPassregister(data2);
            registerfname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            registerothname.setCellValueFactory(new PropertyValueFactory<>("otherName"));
            registerage.setCellValueFactory(new PropertyValueFactory<>("Age"));
            registertwn.setCellValueFactory(new PropertyValueFactory<>("town"));
            registerphne.setCellValueFactory(new PropertyValueFactory<>("telnumber"));
            registeremail.setCellValueFactory(new PropertyValueFactory<>("email"));
            registerfellow.setCellValueFactory(new PropertyValueFactory<>("fellowship"));
            registergender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            
            FilteredList<registrationSub> filterdata2=new FilteredList(data2, s->true);
            searchfield.textProperty().addListener((observable,oldValue, newValue)->{
                    filterdata2.setPredicate(valuett2 ->{
                        
                        if(newValue==null || newValue.isEmpty()){
                            return true;
                        } else if(valuett2.getFirstName().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }else if(valuett2.getOtherName().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }else if(valuett2.getFirstName().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }else if(valuett2.getTelnumber().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }else if(valuett2.getEmail().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }else if(valuett2.getTown().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }                       
                        else 
                        return false;
    
                        
                    });
                });
            SortedList<registrationSub> sorteddata2=new SortedList<>(filterdata2);
            sorteddata2.comparatorProperty().bind(registertbl.comparatorProperty());

            //FINALLY ADDED TO TableView
        registertbl.setItems(sorteddata2);
        
        } catch (SQLException ex) {
            
        }
        try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery("Select * from financeTable");
           
            data = FXCollections.observableArrayList();
            
            while(rs.next()){
                //Iterate Row
               data.add(new financesub(rs.getString("ID"),rs.getDate("Date"), rs.getInt("MembershipDues"), rs.getInt("ThanksGive"), rs.getInt("Tithe"), rs.getInt("SpecialOffering"), rs.getInt("OtherDues"), rs.getInt("Collections"), rs.getInt("FuneralDues"), rs.getInt("PastorsElders"), rs.getInt("TitheBook"), rs.getInt("BaptismalCard"), rs.getInt("AnnualHarvest"), rs.getInt("Refund")));
            }
            upd.setPassfinance(data);
            financeid.setCellValueFactory(new PropertyValueFactory<>("Id"));
            financeDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            financememdues.setCellValueFactory(new PropertyValueFactory<>("membershipDues"));
            financethkgiving.setCellValueFactory(new PropertyValueFactory<>("thanksgiving"));
            financetithe.setCellValueFactory(new PropertyValueFactory<>("tithe"));
            financespecoff.setCellValueFactory(new PropertyValueFactory<>("specOffering"));
            financeotherdues.setCellValueFactory(new PropertyValueFactory<>("otherdues"));
            financecollect.setCellValueFactory(new PropertyValueFactory<>("Collections"));
            financefnndues.setCellValueFactory(new PropertyValueFactory<>("funeraldues"));
            financepe.setCellValueFactory(new PropertyValueFactory<>("pe"));
            financetithbk.setCellValueFactory(new PropertyValueFactory<>("tithebook"));
            financebapcard.setCellValueFactory(new PropertyValueFactory<>("bapcard"));
            financeharvest.setCellValueFactory(new PropertyValueFactory<>("annualharvest"));
            financerefund.setCellValueFactory(new PropertyValueFactory<>("refund"));
            
            
             FilteredList<financesub> filterdata=new FilteredList(data, c->true);
            searchfield.textProperty().addListener((observable,oldValue, newValue)->{
                    filterdata.setPredicate(valuett ->{
                        
                        if(newValue==null || newValue.isEmpty()){
                            return true;
                        } else if(valuett.getId().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }else if(valuett.getDate().toString().toLowerCase().indexOf(searchfield.getText().toLowerCase()) !=-1){
                            return true;
                        }                       
                        else 
                        return false;   
                    });
                });
            SortedList<financesub> sorteddata=new SortedList<>(filterdata);
            sorteddata.comparatorProperty().bind(financetbl.comparatorProperty());
            //FINALLY ADDED TO TableView
        financetbl.setItems(sorteddata);
        
        } catch (SQLException ex) {
            
        }
        
        try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery("Select * from UserTable");
           
            data3 = FXCollections.observableArrayList();
            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
                for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col1 = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col1.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                usertbl.getColumns().addAll(col1);
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList row3 = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row3.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row3);
                data3.add(row3);
            }

            //FINALLY ADDED TO TableView
        usertbl.setItems(data3);
        
        } catch (SQLException ex) {
            
        }
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        expensetbl.setVisible(false);
        registertbl.setVisible(false);
        financetbl.setVisible(true);
       expensebtn.setDisable(false);
        expensebtn.setCursor(Cursor.HAND);
        financebtn.setDisable(true);
        financebtn.setCursor(Cursor.DISAPPEAR);
        userbtn.setDisable(false);
        userbtn.setCursor(Cursor.HAND);
        tablename.setItems(observableArrayList("Finance","Register","Expense","User"));
        
        searchbar();
    }
}
