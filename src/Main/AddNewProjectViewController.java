/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    public void AddNewProject(){
        String x = projectName.getText();
        
    }
}
