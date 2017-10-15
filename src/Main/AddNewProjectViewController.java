/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sun.util.calendar.BaseCalendar.Date;
import models.Project;

/**
 *
 * @author DimanshaW
 */
public class AddNewProjectViewController {
    @FXML 
    private javafx.scene.control.Button CancelBtn;
    
    public void Cancel(){
        Stage stage = (Stage) CancelBtn.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private TextField projectName;
    @FXML
    private DatePicker projectStartDate;
    @FXML
    private DatePicker projectEndDate;
    @FXML
    private TextArea projectDescription;
    @FXML 
    private javafx.scene.control.Button AddBtn;
    
    public void AddNewProject(){
        String ProjectName = projectName.getText();
        LocalDate sDate = projectStartDate.getValue();
        java.sql.Date ProjectStartDate = java.sql.Date.valueOf(sDate);
        LocalDate eDate = projectEndDate.getValue();
        java.sql.Date ProjectEndDate = java.sql.Date.valueOf(eDate);
        String ProjectDescription = projectDescription.getText();
        Project p = new Project(ProjectName, ProjectStartDate, ProjectEndDate,
                ProjectDescription);
        Stage stage = (Stage) AddBtn.getScene().getWindow();
        stage.close();
    }
}
