/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.javiergarciaescobedo.tresenraya;

import es.javiergarciaescobedo.tresenraya.model.TresEnRaya;
import es.javiergarciaescobedo.tresenraya.view.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author javier
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Tablero tablero = new Tablero();
        tablero.ponerFicha();
        
        StackPane root = new StackPane();
        root.getChildren().add(tablero.getGridTablero());
         
        Scene scene = new Scene(root, 300, 250);
        
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
