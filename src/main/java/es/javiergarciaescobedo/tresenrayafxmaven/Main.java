/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.javiergarciaescobedo.tresenrayafxmaven;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author javier
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TableroView tableroView = new TableroView();        
        
        // Contenedor para alinear el tablero en centro horizontalmente
        HBox hBox = new HBox(tableroView.getGridTablero());
        hBox.setAlignment(Pos.CENTER);
        
        // Contenedor principal será de tipo VBox para centrar tablero verticalmente
        VBox root = new VBox();
        root.getChildren().add(hBox);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 250, 250);
        
        primaryStage.setTitle("Tres en raya");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
