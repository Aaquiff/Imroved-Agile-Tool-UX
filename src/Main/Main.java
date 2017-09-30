/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author aaralk
 */
public class Main extends Application implements EventHandler<ActionEvent> {
    Button button;
    @Override
    public void start(Stage primaryStage) {
      
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            
            Scene scene = new Scene(root);
            
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==button)
        {
            System.out.println("I love it");
        }
    }
    
}
