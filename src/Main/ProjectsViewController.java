/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import static java.lang.Compiler.disable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;



/**
 *
 * @author DimanshaW
 */

//public void AddWork() throws IOException{
//       String mainpage = "addNewProject.fxml";
//       Stage p = new Stage();
//       Parent root = FXMLLoader.load(getClass().getResource(mainpage));
//            p.initStyle(StageStyle.DECORATED);
//            //p.setMaximized(true);
//            p.setResizable(false);
//            Scene scene = new Scene(root);
//            p.setScene(scene);
//            p.show();
//    }
public class ProjectsViewController {
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
}
