/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.net.URL;
import java.util.ArrayList;
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
import DummyData.TargetsScreen_DummyData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Project;
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
    private ListView<String> Targets_ProjectsList;
    @FXML
    private Text Targets_TargetLabel;
    ObservableList<String> projectsList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Targets Screen
        getTargetScreenData();
        // Targets Screen
    }    

    private void getTargetScreenData() {
        TargetsScreen_DummyData dummy = new TargetsScreen_DummyData();        
        ArrayList<Project> projects = dummy.getDummyProjects();        
        projectsList.clear();
        ArrayList<String> projNames = new ArrayList<String>();
        for(Project p : projects)
        {
            projNames.add(p.name);
        }
        projectsList.addAll(projNames);
        Targets_ProjectsList.setItems(projectsList);
        Targets_ProjectsList.getSelectionModel().selectedItemProperty().addListener(projectListItemSelected);        
    }
    
    private final ChangeListener<String> projectListItemSelected = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue != null)
            {
                
            }
        }
    };
            
}
