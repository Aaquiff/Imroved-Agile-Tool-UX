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
//import sun.util.calendar.BaseCalendar.Date;
import models.Project;
import java.util.Date;
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
    
    
    public void AddNewProject(){
        
        String ProjectName = projectName.getText();
        LocalDate ProjectStartDate = projectStartDate.getValue();
        LocalDate ProjectEndDate = projectEndDate.getValue();
        String ProjectDescription = projectDescription.getText();
        Project p = new Project(ProjectName, ProjectStartDate, ProjectEndDate,
                ProjectDescription);
        if(ProjectName != null && ProjectStartDate != null && ProjectEndDate != null && ProjectDescription != null ){
            projectName.clear();
            projectStartDate.setValue(null);
            projectEndDate.setValue(null);
            projectDescription.clear();
            Cancel(); 
        }
        else{
            JOptionPane.showMessageDialog(null, "Fill all the fields");
        }
        
        // need to close the window
    }
}