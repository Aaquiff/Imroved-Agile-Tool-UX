/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Sprint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Task;

/**
 *
 * @author aaralk
 */
public class SprintViewController {
    boolean isNavigatorVisible;
    
    Sprint currentSprint;
    
    Node componentsPane;

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

    ArrayList<Sprint> sprints = new ArrayList<Sprint>();
    Task[] tasks = new Task[10];

    public static final ObservableList data
            = FXCollections.observableArrayList();

    public static final ObservableList newTasks
            = FXCollections.observableArrayList();

    public static final ObservableList tasksInProgress
            = FXCollections.observableArrayList();

    public static final ObservableList tasksDone
            = FXCollections.observableArrayList();
    
    public void NewSprint(){
        dlgNewSprint dialog = new dlgNewSprint(null,true);
        dialog.setVisible(true);
        if(dialog.isAdded)
        {
            Sprint sprint = new Sprint(dialog.name, dialog.duration, "", null, "");
            sprints.add(sprint);
            data.add(sprint.name);
        }
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
                sprintDuration.setText(Integer.toString(s.duration));
                sprintStartEnd.setText(s.startEnd);

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

    public void initialize() {

        componentsPane=mainSplitPlane.getItems().get(0); 
        
        mainSplitPlane.getItems().remove(componentsPane);
        isNavigatorVisible = false;
        
        tasks[0] = new Task("1", "Task 1", "First Task", "origin", "US", 5, 34, "Release1", "New", "Mfin", "1");
        tasks[1] = new Task("2", "Task 2", "Second Task", "origin", "US", 5, 34, "Release2", "New", "Mfin", "1");
        tasks[2] = new Task("3", "Task 3", "Third Task", "origin", "US", 5, 34, "Release2", "In Progress", "Mfin", "1");
        tasks[3] = new Task("4", "Task 4", "Fourth Task", "origin", "US", 5, 34, "Release3", "Done", "Mfin", "1");
        tasks[4] = new Task("5", "Task 5", "Five Task", "origin", "US", 5, 34, "Release4", "Done", "Mfin", "1");

        sprints.add(new Sprint("Sprint 1", 10, "22nd August - 4th September", tasks, ""));
        sprints.add(new Sprint("Sprint 2", 12, "23 February - 4th March", tasks, ""));
        sprints.add(new Sprint("Sprint 3", 5, "2nd March - 4th May", tasks, ""));
        sprints.add(new Sprint("Sprint 4", 11, "12th May - 4th September", tasks, ""));
        sprints.add(new Sprint("Sprint 5", 12, "22nd September - 4th December", tasks, ""));
        sprints.add(new Sprint("Sprint 6", 40, "1st August - 4th September", tasks, ""));
        sprints.add(new Sprint("Sprint 7", 20, "4th June - 4th July", tasks, ""));
        sprints.add(new Sprint("Sprint 8", 10, "24th January - 4th November", tasks, ""));
        sprints.add(new Sprint("Sprint 9", 21, "12th November - 4th January", tasks, ""));
        sprints.add(new Sprint("Sprint 10", 43, "7th March - 4th September", tasks, ""));
        
        
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
        dlgSprintNotes sn = new dlgSprintNotes(null,true);
        sn.setVisible(true);
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

    public void Add() {
       
                
//        Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getResource("SprintPage.fxml"));
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root, 450, 450));
//            // Hide this current window (if this is what you want)
//            //((Node)(event.getSource())).getScene().getWindow().hide();
//
//            System.out.println(root.getId());
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText("Look, an Information Dialog");
//        alert.setContentText("I have a great message for you!");
//
//        alert.showAndWait();

    }
}
