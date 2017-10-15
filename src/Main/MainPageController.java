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
import java.io.IOException;
import java.util.Date;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Project;
import models.Sprint;
import models.Task;
/**
 * FXML Controller class
 *
 * @author lathlk
 */
public class MainPageController implements Initializable {

    
    //Search Start
    boolean isTarget = false;
    
    
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
    private Button SearchBtnReleaseNotes;
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
    
    public void AdvanceSearch(){
        dlgAdvanceSearch dialog = new dlgAdvanceSearch(null, true);
        dialog.setVisible(true);
        
        if(dialog.isTarget)
        {
            SearchBtnReleaseNotes.setDisable(false);
        }
    }
    
    public void InitilizeSearch()
    {
        if(isTarget = false)
        {
            SearchBtnReleaseNotes.setDisable(true);
        }
    }
    //Search End
    
    @FXML
    private ListView<String> Targets_ProjectsList;
    @FXML
    private Text Targets_TargetLabel;
    ObservableList<String> projectsList = FXCollections.observableArrayList();
    @FXML
    private Button Targets_Delete1;
    @FXML
    private Button Targets_Delete2;
    @FXML
    private Button Targets_Delete3;
    @FXML
    private Button Targets_BtnAdd;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Targets Screen
        InitializeTargetScreenData();
        // Targets Screen
        initializeSprint();
        InitilizeSearch();
    }    

    private void InitializeTargetScreenData() {
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
        
        Targets_Delete1.setOnAction(e-> JOptionPane.showMessageDialog(null, "Are you sure?", "Delete !", JOptionPane.OK_CANCEL_OPTION));
        Targets_Delete2.setOnAction(e-> JOptionPane.showMessageDialog(null, "Are you sure?", "Delete !", JOptionPane.OK_CANCEL_OPTION));
        Targets_Delete3.setOnAction(e-> JOptionPane.showMessageDialog(null, "Are you sure?", "Delete !", JOptionPane.OK_CANCEL_OPTION));
        Targets_BtnAdd.setOnAction(e-> {
            dlgAddTarget d = new dlgAddTarget();
            d.setVisible(true);
        });
    }
    
    private final ChangeListener<String> projectListItemSelected = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue != null)
            {
                Targets_TargetLabel.setText(newValue);
            }
        }
    };
    
    
    //Sprint Start

    boolean isNavigatorVisible;
    Sprint currentSprint;
    Node componentsPane;

    @FXML
    public Button btnNewSprint;
    @FXML
    public Button btnDelete;
    @FXML
    public Button btnEditSprint;
    @FXML
    public Button btnHamburger;
    @FXML
    public Button btnNotes;
    @FXML
    public SplitPane mainSplitPlane;
    @FXML
    public Label sprintCount;
    @FXML
    public Label sprintNumber;
    @FXML
    public Label sprintDuration;
    @FXML
    public Label sprintStartEnd;
    @FXML
    public ListView navigatorListView;
    @FXML
    public TableView newTable;
    @FXML
    public TableView inProgressTable;
    @FXML
    public TableView doneTable;

    ArrayList<Sprint> sprints = new ArrayList<>();
    
    public static final ObservableList data = FXCollections.observableArrayList();

    public static final ObservableList newTasks = FXCollections.observableArrayList();

    public static final ObservableList tasksInProgress = FXCollections.observableArrayList();

    public static final ObservableList tasksDone = FXCollections.observableArrayList();
    
    public void InitializeGraphics() {
        btnHamburger.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/menu.png"),25,25,false,false)));
        btnNotes.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/notes.png"),100,100,false,false)));
        btnDelete.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/delete.png"),30,30,false,false)));
        btnNewSprint.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/add.png"),30,30,false,false)));
        btnEditSprint.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/edit.png"),30,30,false,false)));
        
        componentsPane=mainSplitPlane.getItems().get(0); 
        mainSplitPlane.getItems().remove(componentsPane);
        isNavigatorVisible = false;
    }
    
    public void RefreshCurrent() {
        ShowSprint(currentSprint.name);
    }
    
    public void NewSprint(){
        dlgNewSprint dialog = new dlgNewSprint(null,true);
        dialog.setVisible(true);
        if(dialog.isAdded)
        {
            Sprint sprint = dialog.sprint;
            sprints.add(sprint);
            data.add(sprint.name);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Sprint Added");
            alert.setContentText("Add tasks to sprint to make it more interesting");

            alert.showAndWait();

        }
    }
    
    public void EditSprint() {
        dlgEditSprint dialog = new dlgEditSprint(null,true,currentSprint);
        dialog.setVisible(true);
//        if(dialog.isAdded)
//        {
//            Sprint sprint = dialog.sprint;
//            sprints.add(sprint);
//            data.add(sprint.name);
//            
//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Information");
//            alert.setHeaderText("Sprint Added");
//            alert.setContentText("Add tasks to sprint to make it more interesting");
//
//            alert.showAndWait();
//
//        }
    }
    
    public void DeleteSprint() {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this sprint?");
        if(result == 0)
        {
            for(Sprint sprint : sprints)
            {
                if(sprint.name.equals(currentSprint.name))
                {
                    sprints.remove(sprint);
                    LoadData();
                }
            }
        }
        
    }

    public void changeSprint() {
        String item = navigatorListView.getSelectionModel().getSelectedItem().toString();
        ShowSprint(item);

    }

    public void ShowSprint(String sprint) {
        
        for (Sprint s : sprints) {
            if (s.name.equals(sprint)) {
                sprintNumber.setText(s.name);
                sprintDuration.setText(Long.toString(s.duration)+" Days");
                sprintStartEnd.setText(s.startEnd());

                newTasks.clear();
                tasksInProgress.clear();
                tasksDone.clear();

                for (Task task : s.tasks) {
                    if (task != null) {
                        if (task.getStatus().equals("New")) {
                            newTasks.add(task);
                        } else if (task.getStatus().equals("In Progress")) {
                            tasksInProgress.add(task);
                        } else if (task.getStatus().equals("Done")) {
                            tasksDone.add(task);
                        }
                    }

                }
                currentSprint = s;
                return;
            }
        }

    }

    public void initializeSprint() {

        InitializeGraphics();

        ArrayList<Task> tasks = new ArrayList<Task>();

        tasks.add(new Task("1", "Task 1", "First Task", "origin", "US", 5, 34, "Release1", "New", "Mfin", "1") );
        tasks.add(new Task("2", "Task 2", "Second Task", "origin", "US", 5, 34, "Release2", "New", "Mfin", "1") );
        tasks.add(new Task("3", "Task 3", "Third Task", "origin", "US", 5, 34, "Release2", "In Progress", "Mfin", "1") );
        tasks.add(new Task("4", "Task 4", "Fourth Task", "origin", "US", 5, 34, "Release3", "Done", "Mfin", "1") );
        tasks.add(new Task("5", "Task 5", "Five Task", "origin", "US", 5, 34, "Release4", "Done", "Mfin", "1") );

        sprints.add(new Sprint("Sprint 1", new Date(117,8,24), new Date(117,11,24), tasks, ""));
        sprints.add(new Sprint("Sprint 2", new Date(117,2,12), new Date(117,5,12), tasks, ""));
        sprints.add(new Sprint("Sprint 3", new Date(117,7,3), new Date(117,8,2), tasks, ""));
        sprints.add(new Sprint("Sprint 4", new Date(117,5,5), new Date(117,6,21), tasks, ""));
        sprints.add(new Sprint("Sprint 5", new Date(117,2,4), new Date(117,7,4), tasks, ""));
        sprints.add(new Sprint("Sprint 6", new Date(117,1,12), new Date(117,3,7), tasks, ""));
        sprints.add(new Sprint("Sprint 7", new Date(117,3,28), new Date(117,6,30), tasks, ""));
        sprints.add(new Sprint("Sprint 8", new Date(117,7,12), new Date(117,8,2), tasks, ""));
        
        
        LoadData();
    }
    
    public void LoadData() {
        data.clear();
        
        for (Sprint sprint : sprints) {
            data.add(sprint.name);
        }
        navigatorListView.setItems(data);

        newTable.setItems(newTasks);
        inProgressTable.setItems(tasksInProgress);
        doneTable.setItems(tasksDone);

        ShowSprint(sprints.get(0).name);
    }
    
    public void Note() {
        dlgSprintNotes sn = new dlgSprintNotes(null,true,currentSprint.note);
        
        sn.setVisible(true);
        currentSprint.note = sn.getNote();
    }
    
    public void ToggleNavigatorPane() {
        if(isNavigatorVisible){
            mainSplitPlane.getItems().remove(componentsPane);
            isNavigatorVisible = false;
        }
        else
        {
            mainSplitPlane.getItems().add(0, componentsPane); 
            mainSplitPlane.setDividerPosition(0, 0.2); 
            isNavigatorVisible = true;
        }
    }

    public void AddTask() {
        dlgAddTask dialog = new dlgAddTask(null,true);
        dialog.setVisible(true);
        if(dialog.isAdded)
        {
            Task task = dialog.task;
            task.setStatus("New");
            currentSprint.tasks.add(task);
            
            RefreshCurrent();
            
            //sprints.add(sprint);
            //data.add(sprint.name);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Sprint Added");
            alert.setContentText("Add tasks to sprint to make it more interesting");

            alert.showAndWait();

        }
    }
    
    public void EditTask() {
        System.out.println("Edit");
    }
    
    public void RemoveTask() { 
        
    }

//Sprint end
    
    // Project start
    public void AddWork() throws IOException{
        
        String mainpage = "addNewProject.fxml";
        Stage primaryStage = new Stage();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);
        Parent root = FXMLLoader.load(getClass().getResource(mainpage));
        dialogVbox.getChildren().add(new Text("This is a Dialog"));
        Scene dialogScene = new Scene(root);
        dialog.setResizable(false);
        dialog.setScene(dialogScene);
        dialog.show();

    }
    @FXML
    private ListView projectListView;
    public void AddNewProject(Project p){
        ListView<String> projectListView = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList (
            p.name);
        projectListView.setItems(items);
                
    }
    // Project end
            
}
