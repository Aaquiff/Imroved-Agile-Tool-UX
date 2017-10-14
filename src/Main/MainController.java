/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class MainController implements Initializable {
    
//Search start
    @FXML
    public Pane SearchPnButtonPane;
    
    @FXML
    public Button SearchBtnAffectToSprint;
    
    @FXML
    public Button SearchBtnDuplicate;
    
    @FXML
    public Button SearchBtnSort;
    
    @FXML
    public Button SearchBtnExport;
    
    @FXML
    public Button SearchBtnSearch;
    
    @FXML
    public Button SearchBtnAdvSearch;
    
    @FXML
    public Label SearchLblSearchKey;
    
    @FXML
    public TextField SearchTxtSearchKey;
    
    @FXML
    public TableView SearchTblResults;
    
    @FXML
    public TableColumn SearchColId;
    
    @FXML
    public TableColumn SearchColTitle;
    
    @FXML
    public TableColumn SearchColDescription;
    
    @FXML
    public TableColumn SearchColOrigin;
    
    @FXML
    public TableColumn SearchColType;
    
    @FXML
    public TableColumn SearchColBV;
    
    @FXML
    public TableColumn SearchColWeight;
    
    @FXML
    public TableColumn SearchColTarget;
    
    @FXML
    public TableColumn SearchColStatus;
    
    @FXML
    public TableColumn SearchColSprint;
    
    @FXML
    public TableColumn SearchColProject;
//Search End
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

//Search start
public void tblResultsColWidth()
{
    SearchColId.prefWidthProperty().bind(SearchTblResults.widthProperty().multiply(7.3));
    SearchColDescription.prefWidthProperty().bind(SearchTblResults.widthProperty().multiply(18.5));
    SearchColTitle.prefWidthProperty().bind(SearchTblResults.widthProperty().multiply(9.74));
    SearchColBV.prefWidthProperty().bind(SearchTblResults.widthProperty().multiply(7.3));
    
    SearchColId.setResizable(false);
    SearchColDescription.setResizable(false);
    SearchColTitle.setResizable(false);
    SearchColBV.setResizable(false);
}
//Search End    
    
}