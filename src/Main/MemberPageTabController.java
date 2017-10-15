/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    public ComboBox<?> statusCombo;

    @FXML
    public TableView<?> tableMember;

    @FXML
    public Button btnUPDATE;

    @FXML
    public Button buttonADD;

 @FXML
    public void addingMember(ActionEvent event) {

    }
    
}
