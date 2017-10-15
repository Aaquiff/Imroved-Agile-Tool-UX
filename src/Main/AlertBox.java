/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author lathlk
 */
public class AlertBox {
    public static void display(String title, String message)
    {
        Stage alertWindow = new Stage();
        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle(title);
        alertWindow.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        Button btnOk = new Button("OK");
        btnOk.setOnAction(e -> alertWindow.close());
        VBox view = new VBox(10);
        view.getChildren().addAll(label, btnOk);
        view.setAlignment(Pos.CENTER);
        Scene scene = new Scene(view);
        alertWindow.setScene(scene);
        alertWindow.showAndWait();
    }
}
