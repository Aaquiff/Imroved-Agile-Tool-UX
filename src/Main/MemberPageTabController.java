/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import models.Task;
import models.comboValues;
import models.memberDetails;

/**
 * FXML Controller class
 *
 * @author Apisajan
 */
public class MemberPageTabController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        MemberPageTab.setResizable(false);
        setNull();
        loadDate();
       
        
        
       
 
        
    }    
    
    @FXML
    public TextField textNickName;

    @FXML
    public TextField textMobileNumber;

    @FXML
    public TextField textFullName;

    @FXML
    public TextField textInternalPhone;

    @FXML
    public TextField textSearch;

    @FXML
    public Button btnDELETE;

    @FXML
    public ComboBox<comboValues> statusCombo;

    @FXML
    public TableView<memberDetails> tableMember;

    @FXML
    public Button btnUPDATE;

    @FXML
    public Button buttonADD;

        public static final ObservableList member = FXCollections.observableArrayList();
            public static  ObservableList<memberDetails> memberData=FXCollections.observableArrayList();
    
    @FXML
    public void addingMember() throws IOException{
//                  if(textNickName.getText()!=null && textMobileNumber!=null && textFullName!=null && textInternalPhone!=null ){
  
        if(textNickName.getText()!=null && textMobileNumber.getText()!=null && textFullName.getText()!=null && textInternalPhone.getText()!=null ){
             //Reference : http://code.makery.ch/blog/javafx-dialogs-official/
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                //Creating a object to add to the table 
                
//                memberData = FXCollections.observableArrayList(
//              new memberDetails(textNickName.getText(),textFullName.getText(),textInternalPhone.getText(),textMobileNumber.getText(),"Available"));
//                        loadDate();
                        
//                memberDetails addmember = new memberDetails(textNickName.getText(),textFullName.getText(),textInternalPhone.getText(),textMobileNumber.getText(),statusCombo.getSelectionModel().getSelectedItem().toString());
                
                alert.setContentText("SuccessFully Added!");
                alert.showAndWait();
                setNull();

        }
        else{
              Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Enter Every Fields");
                alert.showAndWait();
        }


    }
    
    @FXML
    public void updatingMember()throws IOException {
        
        models.memberDetails details = tableMember.getSelectionModel().getSelectedItem();
         tableMember.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<memberDetails>() {
            @Override
            public void changed(ObservableValue<? extends memberDetails> observable, memberDetails oldValue, memberDetails newValue) {
                models.memberDetails selectedDetail = tableMember.getSelectionModel().getSelectedItem();
                memberDetails select = new memberDetails(memberDetails.class);
                textFullName.setText(select.getFullName());
                textNickName.setText(select.getNickName());
                textInternalPhone.setText(select.getInternalPhone());
                textMobileNumber.setText(select.getMobileNumber());
            }
        });
        if(details!=null){
             int resultValue = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this Member");
         if(resultValue == 0){
            //Reference : http://code.makery.ch/blog/javafx-dialogs-official/
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Sucessfully Member Updated!");
                alert.showAndWait();
         }
        }
       
    }

     @FXML
    public void deleteingMember() throws IOException{
        int resultValue = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Member");
         if(resultValue == 0){
            //Reference : http://code.makery.ch/blog/javafx-dialogs-official/
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Deleted Member Successfully!");
                alert.showAndWait();
         }
    }
     @FXML
    public void searchBy() throws IOException {
//           textSearch.setText("");
    }
    public void setNull (){
                    textNickName.setText(null);
                    textMobileNumber.setText(null);
                    textFullName.setText(null);
                    textInternalPhone.setText(null);
    }
    public void loadDate(){
       
//        statusCombo = new ComboBox<comboValues>();
//        statusCombo.setItems(FXCollections.observableArrayList(
//        new comboValues("Available"),
//        new comboValues("Not Available")));
//       
 
        memberData = FXCollections.observableArrayList(
              new memberDetails("Ronnie8", "Apisajan","123","0750123456","Available"),
                new memberDetails("YoungBlood", "Usama","789","0777123456","Not Available"),
                new memberDetails("Quiff", "Aaquiff","456","0770123456","Available"),
                new memberDetails("Shipa", "Ashif","963","0710766785","Not Available"),
                new memberDetails("Kanji", "AG","147","0762145786","Available")
                );
        
         TableColumn nickName = new TableColumn("Nick Name");
         nickName.setMinWidth(150);
                nickName.setCellValueFactory(new PropertyValueFactory<memberDetails,String>("nickName"));

        TableColumn fullName = new TableColumn("Full Name");
        fullName.setMinWidth(200);
                fullName.setCellValueFactory(new PropertyValueFactory<memberDetails,String>("fullName"));

        TableColumn internal = new TableColumn("Internal Phone");
          internal.setMinWidth(150);
                internal.setCellValueFactory(new PropertyValueFactory<memberDetails,String>("internalPhone"));

        TableColumn mobile = new TableColumn("Mobile No");
          mobile.setMinWidth(150);
                mobile.setCellValueFactory(new PropertyValueFactory<memberDetails,String>("mobileNumber"));

        TableColumn status = new TableColumn("Status");
          status.setMinWidth(100);
                status.setCellValueFactory(new PropertyValueFactory<memberDetails,String>("status"));

             tableMember.setItems(memberData);
                     tableMember.getColumns().addAll(nickName,fullName,internal,mobile,status);



    }
}
