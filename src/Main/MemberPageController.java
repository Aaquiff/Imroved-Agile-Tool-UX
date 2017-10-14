package Main;

import static Main.memberController.newMember;
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
import javax.swing.JOptionPane;
import models.memberDetails;

public class MemberPageController {

    @FXML
    private TextField txtInternalNumber;

    @FXML
    private Button updateBtn;

    @FXML
    private TextField txtMobileName;

    @FXML
    private ComboBox<?> statusComboBox;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField textFieldNickName;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<?> memberTableView;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    public static final ObservableList newMember
            = FXCollections.observableArrayList();
    
    @FXML
    public void searchMember(ActionEvent event) {
        
    }
    public void initalize(){
         List<String> comboBoxList = new ArrayList<String>();
        comboBoxList.add("Available");
        comboBoxList.add("Not Available");
        
        ObservableList observerList = FXCollections.observableList(comboBoxList);
        statusComboBox.getItems().clear();
        statusComboBox.setItems(observerList);
        
        ArrayList<memberDetails> memberDetail = new ArrayList<memberDetails>();
        memberDetail.add(new memberDetails ("Ronnie","Apisajan",1,011,"Avaialble"));
        memberDetail.add(new memberDetails ("YoungBlood","Usama",2,012,"Not Avaialble"));
        newMember.clear();
        newMember.add(memberDetail);
        memberTableView.setItems(newMember);
    }
    @FXML
    public void addMember(ActionEvent event) {
if(     txtInternalNumber.getText()!=null 
                &&txtMobileName.getText()!=null&&
                txtFullName.getText()!=null
                &&textFieldNickName.getText()!=null){
            
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
    public void updateMember(ActionEvent event) {
        
         int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this Member");
         if(result == 0){
         Stage dialogBox = new Stage();
        dialogBox.initStyle(StageStyle.UTILITY);
        Scene scene = new Scene(new Group(new Text(25,25,"Updated Successfully")));
        dialogBox.setScene(scene);
        dialogBox.show();
         }
    }

    @FXML
    public void deleteMember(ActionEvent event) {
         int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Member");
         if(result ==0){
              Stage dialogBox = new Stage();
            dialogBox.initStyle(StageStyle.UTILITY);
            Scene scene = new Scene(new Group(new Text(25,25,"Deleted Successfully")));
             dialogBox.setScene(scene);
             dialogBox.show();
         }
       
    }

}