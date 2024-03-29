package Main;

import java.util.ArrayList;
import java.util.Date;
import models.Sprint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import models.Task;

public class SprintViewController {
    
//    boolean isNavigatorVisible;
//    Sprint currentSprint;
//    Node componentsPane;
//
//    @FXML
//    public Button btnNewSprint;
//    @FXML
//    public Button btnDelete;
//    @FXML
//    public Button btnEditSprint;
//    @FXML
//    public Button btnHamburger;
//    @FXML
//    public Button btnNotes;
//    @FXML
//    public SplitPane mainSplitPlane;
//    @FXML
//    public Label sprintCount;
//    @FXML
//    public Label sprintNumber;
//    @FXML
//    public Label sprintDuration;
//    @FXML
//    public Label sprintStartEnd;
//    @FXML
//    public ListView navigatorListView;
//    @FXML
//    public TableView newTable;
//    @FXML
//    public TableView inProgressTable;
//    @FXML
//    public TableView doneTable;
//
//    ArrayList<Sprint> sprints = new ArrayList<>();
//    
//    public static final ObservableList data = FXCollections.observableArrayList();
//
//    public static final ObservableList newTasks = FXCollections.observableArrayList();
//
//    public static final ObservableList tasksInProgress = FXCollections.observableArrayList();
//
//    public static final ObservableList tasksDone = FXCollections.observableArrayList();
//    
//    public void InitializeGraphics() {
//        btnHamburger.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/menu.png"),25,25,false,false)));
//        btnNotes.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/notes.png"),100,100,false,false)));
//        btnDelete.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/delete.png"),30,30,false,false)));
//        btnNewSprint.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/add.png"),30,30,false,false)));
//        btnEditSprint.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/img/edit.png"),30,30,false,false)));
//        
//        componentsPane=mainSplitPlane.getItems().get(0); 
//        mainSplitPlane.getItems().remove(componentsPane);
//        isNavigatorVisible = false;
//    }
//    
//    public void RefreshCurrent() {
//        ShowSprint(currentSprint.name);
//    }
//    
//    public void NewSprint(){
//        dlgNewSprint dialog = new dlgNewSprint(null,true);
//        dialog.setVisible(true);
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
//    }
//    
//    public void EditSprint() {
//        dlgEditSprint dialog = new dlgEditSprint(null,true,currentSprint);
//        dialog.setVisible(true);
////        if(dialog.isAdded)
////        {
////            Sprint sprint = dialog.sprint;
////            sprints.add(sprint);
////            data.add(sprint.name);
////            
////            Alert alert = new Alert(AlertType.INFORMATION);
////            alert.setTitle("Information");
////            alert.setHeaderText("Sprint Added");
////            alert.setContentText("Add tasks to sprint to make it more interesting");
////
////            alert.showAndWait();
////
////        }
//    }
//    
//    public void DeleteSprint() {
//        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this sprint?");
//        if(result == 0)
//        {
//            for(Sprint sprint : sprints)
//            {
//                if(sprint.name.equals(currentSprint.name))
//                {
//                    sprints.remove(sprint);
//                    LoadData();
//                }
//            }
//        }
//        
//    }
//
//    public void changeSprint() {
//        String item = navigatorListView.getSelectionModel().getSelectedItem().toString();
//        ShowSprint(item);
//
//    }
//
//    public void ShowSprint(String sprint) {
//        
//        for (Sprint s : sprints) {
//            if (s.name.equals(sprint)) {
//                sprintNumber.setText(s.name);
//                sprintDuration.setText(Long.toString(s.duration)+" Days");
//                sprintStartEnd.setText(s.startEnd());
//
//                newTasks.clear();
//                tasksInProgress.clear();
//                tasksDone.clear();
//
//                for (Task task : s.tasks) {
//                    if (task != null) {
//                        if (task.getStatus().equals("New")) {
//                            newTasks.add(task);
//                        } else if (task.getStatus().equals("In Progress")) {
//                            tasksInProgress.add(task);
//                        } else if (task.getStatus().equals("Done")) {
//                            tasksDone.add(task);
//                        }
//                    }
//
//                }
//                currentSprint = s;
//                return;
//            }
//        }
//
//    }
//
//    public void initialize() {
//
//        InitializeGraphics();
//
//        ArrayList<Task> tasks = new ArrayList<Task>();
//
//        tasks.add(new Task("1", "Task 1", "First Task", "origin", "US", 5, 34, "Release1", "New", "Mfin", "1") );
//        tasks.add(new Task("2", "Task 2", "Second Task", "origin", "US", 5, 34, "Release2", "New", "Mfin", "1") );
//        tasks.add(new Task("3", "Task 3", "Third Task", "origin", "US", 5, 34, "Release2", "In Progress", "Mfin", "1") );
//        tasks.add(new Task("4", "Task 4", "Fourth Task", "origin", "US", 5, 34, "Release3", "Done", "Mfin", "1") );
//        tasks.add(new Task("5", "Task 5", "Five Task", "origin", "US", 5, 34, "Release4", "Done", "Mfin", "1") );
//
//        sprints.add(new Sprint("Sprint 1", new Date(117,8,24), new Date(117,11,24), tasks, ""));
//        sprints.add(new Sprint("Sprint 2", new Date(117,2,12), new Date(117,5,12), tasks, ""));
//        sprints.add(new Sprint("Sprint 3", new Date(117,7,3), new Date(117,8,2), tasks, ""));
//        sprints.add(new Sprint("Sprint 4", new Date(117,5,5), new Date(117,6,21), tasks, ""));
//        sprints.add(new Sprint("Sprint 5", new Date(117,2,4), new Date(117,7,4), tasks, ""));
//        sprints.add(new Sprint("Sprint 6", new Date(117,1,12), new Date(117,3,7), tasks, ""));
//        sprints.add(new Sprint("Sprint 7", new Date(117,3,28), new Date(117,6,30), tasks, ""));
//        sprints.add(new Sprint("Sprint 8", new Date(117,7,12), new Date(117,8,2), tasks, ""));
//        
//        
//        LoadData();
//    }
//    
//    public void LoadData() {
//        data.clear();
//        
//        for (Sprint sprint : sprints) {
//            data.add(sprint.name);
//        }
//        navigatorListView.setItems(data);
//
//        newTable.setItems(newTasks);
//        inProgressTable.setItems(tasksInProgress);
//        doneTable.setItems(tasksDone);
//
//        ShowSprint(sprints.get(0).name);
//    }
//    
//    public void Note() {
//        dlgSprintNotes sn = new dlgSprintNotes(null,true);
//        sn.setVisible(true);
//    }
//    
//    public void ToggleNavigatorPane() {
//        if(isNavigatorVisible){
//            mainSplitPlane.getItems().remove(componentsPane);
//            isNavigatorVisible = false;
//        }
//        else
//        {
//            mainSplitPlane.getItems().add(0, componentsPane); 
//            mainSplitPlane.setDividerPosition(0, 0.2); 
//            isNavigatorVisible = true;
//        }
//    }
//
//    public void AddTask() {
//        dlgAddTask dialog = new dlgAddTask(null,true);
//        dialog.setVisible(true);
//        if(dialog.isAdded)
//        {
//            Task task = dialog.task;
//            task.setStatus("New");
//            currentSprint.tasks.add(task);
//            
//            RefreshCurrent();
//            
//            //sprints.add(sprint);
//            //data.add(sprint.name);
//            
//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Information");
//            alert.setHeaderText("Sprint Added");
//            alert.setContentText("Add tasks to sprint to make it more interesting");
//
//            alert.showAndWait();
//
//        }
//    }
//    
//    public void EditTask() {
//        System.out.println("Edit");
//    }
//    
//    public void RemoveTask() { 
//        
//    }
}
