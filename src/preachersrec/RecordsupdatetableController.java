/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Morvic
 */
public class RecordsupdatetableController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private TableView<financesub> financetbl;
    @FXML private TableView<expenseSub> expensetbl;
    @FXML private TableView<registrationSub> registertbl; 
    
    @FXML private JFXTextField memdues;
    @FXML private JFXTextField thkgiv;
    @FXML private JFXTextField tite;
    @FXML private JFXTextField otherdues;
    @FXML private JFXTextField spoff;
    @FXML private JFXTextField collection;
    @FXML private JFXTextField funDues;
    @FXML private JFXTextField PEs;
    @FXML private JFXTextField titbook;
    @FXML private JFXTextField BapCard;
    @FXML private JFXTextField AnnHarv;
    @FXML private JFXTextField refund;
    @FXML private JFXDatePicker dateP;
    @FXML private Label datel;
    public String usd;
    //register
    @FXML private JFXTextField Fn;
    @FXML private JFXTextField otn;
    @FXML private JFXTextField age;        
    @FXML private JFXTextField twn;
    @FXML private JFXTextField tel;
    @FXML private JFXTextField email;
    @FXML private ComboBox<String> fellows;
    @FXML private ComboBox<String> gender;
    //expense
     @FXML private JFXTextField utilities;
    @FXML private JFXTextField allowance;
    @FXML private JFXTextField charity;
    @FXML private JFXTextField tithe;
    @FXML private JFXTextField transport;
    @FXML private JFXTextField others;
    @FXML private JFXDatePicker datePx;
    @FXML private Label datele;
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

    @FXML private AnchorPane registerAnchor;
    @FXML private AnchorPane expenseanchor;
    @FXML private AnchorPane financeanchor;

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
    updateclass upd=updateclass.getupdateInstance();
    int index=upd.getIndex();
    String UserId;
    Date Dateid;
    
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
    void getselectedfinanceitem(MouseEvent event) throws IOException {
        index=financetbl.getSelectionModel().getSelectedIndex();
        UserId=financeid.getCellData(index);
        Dateid=financeDate.getCellData(index);
        if(index<=-1){
            return;
        }
        
        memdues.setText(""+financememdues.getCellData(index));
            thkgiv.setText(financethkgiving.getCellData(index)+"");
            tite.setText(financetithe.getCellData(index)+"");
            spoff.setText(financespecoff.getCellData(index)+"");
            otherdues.setText(financeotherdues.getCellData(index)+"");
            collection.setText(financecollect.getCellData(index)+"");
            funDues.setText(financefnndues.getCellData(index)+"");
            PEs.setText(financepe.getCellData(index)+"");
            titbook.setText(financetithbk.getCellData(index)+"");
            BapCard.setText(financebapcard.getCellData(index)+"");
            AnnHarv.setText(financeharvest.getCellData(index)+"");
            refund.setText(financerefund.getCellData(index)+"");
    }
    
    @FXML
    void getselectedexpenseitem(MouseEvent event) throws IOException {
        index=expensetbl.getSelectionModel().getSelectedIndex();
        UserId=tableid.getCellData(index);
        Dateid=tableDate.getCellData(index);
        if(index<=-1){
            return;
        }
                 System.out.println(tableutilities.getCellData(index)+"");
                 utilities.setText(tableutilities.getCellData(index)+"");
                 allowance.setText(tableallowance.getCellData(index)+"");
                 charity.setText(tablecharity.getCellData(index)+"");
                 tithe.setText(tabletitbook.getCellData(index)+"");
                 transport.setText(tabletransport.getCellData(index)+"");
                 others.setText(tableothers.getCellData(index)+"");
    }
    
    @FXML
    void getselectedregisteritem(MouseEvent event) throws IOException {
        index=registertbl.getSelectionModel().getSelectedIndex();

        if(index<=-1){
            return;
        }
        fellows.setItems(observableArrayList("Pastors and Elders","Womens Fellowship","Youth"));
        gender.setItems(observableArrayList("Male","Female"));
        Fn.setText(registerfname.getCellData(index));
        otn.setText(registerothname.getCellData(index));
        age.setText(registerage.getCellData(index));
        twn.setText(registertwn.getCellData(index));
        tel.setText(registerphne.getCellData(index));
        email.setText(registeremail.getCellData(index));
        fellows.setValue(registerfellow.getCellData(index));
        gender.setValue(registergender.getCellData(index));
    }
    
    
    @FXML
    public void updatedatabase(ActionEvent evt){
        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
                try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           String qry="update Expensce set utilities="+utilities.getText()+",allowance="+allowance.getText()+",charity="+charity.getText()+",titheBook="+
                   tithe.getText()+",transport="+transport.getText()+",others="+others.getText()+" where Date='"+Dateid+"'";
          int rows= st.executeUpdate(qry);
       if (rows>0){
           System.out.println("Recod success");
       } 
       conn.close();
          
           }catch(SQLException sq){
                    Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(sq.toString());
           tr.show();
                }
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
            
            upd.setBtnpressed(true);
            expensetbl.setItems(upd.getPassexpense());
        
        } catch (SQLException ex) {
            Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(ex.toString());
           tr.show();
        }
    }
    
    @FXML
    public void updatedatabasefinance(ActionEvent evt){
        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
                try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           String qry="update financeTable set MembershipDues="+memdues.getText()+",ThanksGive="+thkgiv.getText()+",Tithe="+tite.getText()+
                   ",SpecialOffering="+spoff.getText()+",OtherDues="+otherdues.getText()+",Collections="+collection.getText()+ 
                   ",FuneralDues="+funDues.getText()+",PastorsElders="+PEs.getText()+",TitheBook="+titbook.getText()+
                   ",BaptismalCard="+BapCard.getText()+",AnnualHarvest="+AnnHarv.getText()+",Refund="+refund.getText()+" where Date='"+Dateid+"'";
          int rows= st.executeUpdate(qry);
       if (rows>0){
           System.out.println("Recod success");
       } 
       conn.close();
          
           }catch(SQLException sq){
                    Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(sq.toString());
           tr.show();
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
            upd.setBtnpressed(true);
        financetbl.setItems(data);
        
        } catch (SQLException ex) {
                    Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(ex.toString());
           tr.show();
        }
    }
    
    @FXML
    public void updatedatabaseregister(ActionEvent evt){
        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
                try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           String qry="update RegisterTable set FirstName='"+Fn.getText()+"',Othername='"+otn.getText()+"',Age="+age.getText()+",Town='"+twn.getText()+"',Telephone="+tel.getText()+
                   ",email='"+email.getText()+"',Fellowship='"+fellows.getSelectionModel().getSelectedItem()+
                   "',Gender='"+gender.getSelectionModel().getSelectedItem()+"' where FirstName='"+Fn.getText()+"' and Othername='"+otn.getText()+"'";
          int rows= st.executeUpdate(qry);
       if (rows>0){
           System.out.println("Recod success");
       } 
       conn.close();
          
           }catch(SQLException sq){
                   Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(sq.toString());
           tr.show();
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
            upd.setBtnpressed(true);
        registertbl.setItems(data2);
        
        } catch (SQLException ex) {
            Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(ex.toString());
           tr.show();
        }
    }
    
    @FXML
    public void deleterowexpense(ActionEvent evt){
        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
                try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           String qry="delete from Expensce where ID='"+UserId+"'";
           int rows= st.executeUpdate(qry);
       if (rows>0){
           System.out.println("Recod success");
       } 
       upd.setBtnpressed(true);
       conn.close();
                }catch(SQLException sq){
                    Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(sq.toString());
           tr.show();
                }
                
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
            
            upd.setBtnpressed(true);
            expensetbl.setItems(upd.getPassexpense());
        
        } catch (SQLException ex) {
            Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(ex.toString());
           tr.show();
        }
    }
    @FXML
    public void deleterowfinance(ActionEvent evt){
         String dbs="jdbc:ucanaccess://preacherfinance.accdb";
        try {
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
                String qry="delete from financeTable where ID='"+UserId+"'";
           int rows= st.executeUpdate(qry);
       if (rows>0){
           System.out.println("Recod success");
       } 
       upd.setBtnpressed(true);
       conn.close();
                }catch(SQLException sq){
                    Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(sq.toString());
           tr.show();
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
                    Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(ex.toString());
           tr.show();
        }
    }
    @FXML
    public void deleterowregister(ActionEvent evt){
        String dbs="jdbc:ucanaccess://preacherfinance.accdb";
        try {
             
            Connection conn=DriverManager.getConnection(dbs);
        
           System.out.println("Connected to Db");
           Statement st=conn.createStatement();
           String qry="delete from RegisterTable where FirstName='"+Fn.getText()+"' and Othername='"+otn.getText()+"'";
           int rows= st.executeUpdate(qry);
       if (rows>0){
           System.out.println("Recod success");
       } 
       upd.setBtnpressed(true);
       conn.close();
                }catch(SQLException sq){
                    Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(sq.toString());
           tr.show();
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
            Alert tr=new Alert(Alert.AlertType.ERROR);
              tr.setTitle("Server Error");
           tr.setContentText(ex.toString());
           tr.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        if(upd.isAnchorexphide()){
            expenseanchor.setVisible(upd.isAnchorexphide());
            financeanchor.setVisible(upd.isAnchorfinhide());
            registerAnchor.setVisible(upd.isAnchorreghide());
        }
        if(upd.isAnchorfinhide()){
           expenseanchor.setVisible(upd.isAnchorexphide());
            financeanchor.setVisible(upd.isAnchorfinhide());
            registerAnchor.setVisible(upd.isAnchorreghide());
        }
        if(upd.isAnchorreghide()){
           expenseanchor.setVisible(upd.isAnchorexphide());
            financeanchor.setVisible(upd.isAnchorfinhide());
            registerAnchor.setVisible(upd.isAnchorreghide());
        }
        
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

            financetbl.setItems(upd.getPassfinance());
            
            
            registerfname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            registerothname.setCellValueFactory(new PropertyValueFactory<>("otherName"));
            registerage.setCellValueFactory(new PropertyValueFactory<>("Age"));
            registertwn.setCellValueFactory(new PropertyValueFactory<>("town"));
            registerphne.setCellValueFactory(new PropertyValueFactory<>("telnumber"));
            registeremail.setCellValueFactory(new PropertyValueFactory<>("email"));
            registerfellow.setCellValueFactory(new PropertyValueFactory<>("fellowship"));
            registergender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            
            registertbl.setItems(upd.getPassregister());
            
            tableid.setCellValueFactory(new PropertyValueFactory<>("ID"));
            tableDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            tableutilities.setCellValueFactory(new PropertyValueFactory<>("utilities"));
            tableallowance.setCellValueFactory(new PropertyValueFactory<>("allow"));
            tablecharity.setCellValueFactory(new PropertyValueFactory<>("charity"));
            tabletitbook.setCellValueFactory(new PropertyValueFactory<>("tithebook"));
            tabletransport.setCellValueFactory(new PropertyValueFactory<>("transportation"));
            tableothers.setCellValueFactory(new PropertyValueFactory<>("others"));
            
            expensetbl.setItems(upd.getPassexpense());
            
            //System.out.println(upd.getFieldFinance().get(0));
            if(upd.getFieldFinance()!=null){
                 UserId=upd.getFieldFinance().get(0).getId();
                 Dateid=upd.getFieldFinance().get(0).getDate();
           memdues.setText(""+upd.getFieldFinance().get(0).getMembershipDues());
            thkgiv.setText(upd.getFieldFinance().get(0).getTithe()+"");
            tite.setText(upd.getFieldFinance().get(0).getThanksgiving()+"");
            spoff.setText(upd.getFieldFinance().get(0).getSpecOffering()+"");
            otherdues.setText(upd.getFieldFinance().get(0).getOtherdues()+"");
            collection.setText(upd.getFieldFinance().get(0).getCollections()+"");
            funDues.setText(upd.getFieldFinance().get(0).getFuneraldues()+"");
            PEs.setText(upd.getFieldFinance().get(0).getPe()+"");
            titbook.setText(upd.getFieldFinance().get(0).getTithebook()+"");
            BapCard.setText(upd.getFieldFinance().get(0).getBapcard()+"");
            AnnHarv.setText(upd.getFieldFinance().get(0).getAnnualharvest()+"");
            refund.setText(upd.getFieldFinance().get(0).getRefund()+"");

            }
            if(upd.getFieldexpense()!=null){
                UserId=upd.getFieldexpense().get(0).getID();
                Dateid=upd.getFieldexpense().get(0).getDate();
            utilities.setText(upd.getFieldexpense().get(0).getUtilities()+"");
                 allowance.setText(upd.getFieldexpense().get(0).getAllow()+"");
                 charity.setText(upd.getFieldexpense().get(0).getCharity()+"");
                 tithe.setText(upd.getFieldexpense().get(0).getTithebook()+"");
                 transport.setText(upd.getFieldexpense().get(0).getTransportation()+"");
                 others.setText(upd.getFieldexpense().get(0).getOthers()+"");

            }
            if(upd.getFieldregister()!=null){  
                 UserId=upd.getFieldregister().get(0).getFirstName();
                 //Dateid=upd.getFieldregister().get(0).getDate();
        fellows.setItems(observableArrayList("Pastors and Elders","Womens Fellowship","Youth"));
        gender.setItems(observableArrayList("Male","Female"));
        Fn.setText(upd.getFieldregister().get(0).getFirstName());
        otn.setText(upd.getFieldregister().get(0).getOtherName());
        age.setText(upd.getFieldregister().get(0).getAge());
        twn.setText(upd.getFieldregister().get(0).getTown());
        tel.setText(upd.getFieldregister().get(0).getTelnumber());
        email.setText(upd.getFieldregister().get(0).getEmail());
        fellows.setValue(upd.getFieldregister().get(0).getFellowship());
        gender.setValue(upd.getFieldregister().get(0).getGender());

            }
       
    }    
    
}
