/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.memberDetails;

/**
 *
 * @author Apisajan
 */
public class memberController {
     @FXML
    private TextField txtMobileNumber;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnAdd;

    @FXML
    private ComboBox<?> comboStatus;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtInternalPhone;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TextField txtNickName;

        public static final ObservableList newMember
            = FXCollections.observableArrayList();
        
    public void initialize(){
        List<String> comboBoxList = new ArrayList<String>();
        comboBoxList.add("Available");
        comboBoxList.add("Not Available");
        
        ObservableList observerList = FXCollections.observableList(comboBoxList);
        comboStatus.getItems().clear();
        comboStatus.setItems(observerList);
        
        ArrayList<memberDetails> memberDetail = new ArrayList<memberDetails>();
        memberDetail.add(new memberDetails ("Ronnie","Apisajan",1,011,"Avaialble"));
        memberDetail.add(new memberDetails ("YoungBlood","Usama",2,012,"Not Avaialble"));
        newMember.clear();
        newMember.add(memberDetail);
        tableView.setItems(newMember);
        }
    @FXML
    private void add(ActionEvent event) {
        
        if(     txtMobileNumber.getText()!=null 
                &&txtFullName.getText()!=null&&
                txtNickName.getText()!=null
                &&txtInternalPhone.getText()!=null){
            
             Stage dialogBox = new Stage();
        dialogBox.initStyle(StageStyle.UTILITY);
        Scene scene = new Scene(new Group(new Text(25,25,"Added Successfully!")));
        dialogBox.setScene(scene);
        dialogBox.show();
            
            
        }
        Stage dialogBox = new Stage();
        dialogBox.initStyle(StageStyle.UTILITY);
        Scene scene = new Scene(new Group(new Text(25,25,"Fill Every Field")));
        dialogBox.setScene(scene);
        dialogBox.show();
    }

    @FXML
    private void update(ActionEvent event) {
        Stage dialogBox = new Stage();
        dialogBox.initStyle(StageStyle.UTILITY);
        Scene scene = new Scene(new Group(new Text(25,25,"Updated Successfully!")));
        dialogBox.setScene(scene);
        dialogBox.show();
    }

    @FXML
    private void delete(ActionEvent event) {
        Stage dialogBox = new Stage();
        dialogBox.initStyle(StageStyle.UTILITY);
        Scene scene = new Scene(new Group(new Text(25,25,"Deleted Successfully!")));
        dialogBox.setScene(scene);
        dialogBox.show();
    }
    
}
