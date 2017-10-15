/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author lathlk
 */
public class MainPageController implements Initializable {

    @FXML
    private AnchorPane SearchPnButtonPane;
    @FXML
    private Button SearchBtnAffectToSprint;
    @FXML
    private Button SearchBtnDuplicate;
    @FXML
    private Button SearchBtnSort;
    @FXML
    private Button SearchBtnExport;
    @FXML
    private Label SearchLblSearchKey;
    @FXML
    private TextField SearchTxtSearchKey;
    @FXML
    private Button SearchBtnSearch;
    @FXML
    private Button SearchBtnAdvSearch;
    @FXML
    private TableView<?> SearchTblResults;
    @FXML
    private TableColumn<?, ?> SearchColId;
    @FXML
    private TableColumn<?, ?> SearchColTitle;
    @FXML
    private TableColumn<?, ?> SearchColDescription;
    @FXML
    private TableColumn<?, ?> SearchColOrigin;
    @FXML
    private TableColumn<?, ?> SearchColType;
    @FXML
    private TableColumn<?, ?> SearchColBV;
    @FXML
    private TableColumn<?, ?> SearchColWeight;
    @FXML
    private TableColumn<?, ?> SearchColTarget;
    @FXML
    private TableColumn<?, ?> SearchColStatus;
    @FXML
    private TableColumn<?, ?> SearchColProject;
    @FXML
    private TableColumn<?, ?> SearchColSprint;
    @FXML
    private ListView<?> Targets_ProjectsList;
    @FXML
    private Text Targets_TargetLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Targets Screen
        
        // Targets Screen
    }    
    
}
