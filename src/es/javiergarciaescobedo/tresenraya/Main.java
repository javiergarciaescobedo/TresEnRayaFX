/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.javiergarciaescobedo.tresenraya;

import es.javiergarciaescobedo.tresenraya.model.TresEnRaya;
import es.javiergarciaescobedo.tresenraya.view.TableroView;
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
        
        TableroView tableroView = new TableroView();
        
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.ponerFicha(0, 0, '2');
        tresEnRaya.ponerFicha(1, 2, '1');
        tresEnRaya.ponerFicha(0, 1, '2');
        tresEnRaya.ponerFicha(2, 2, '1');
        
        for(int y=0; y<3; y++) {
            for(int x=0; x<3; x++) {
                switch(tresEnRaya.matrizTablero[x][y]) {
                    case '1':
                        tableroView.ponerFicha(x, y, '1');
                        break;
                    case '2':
                        tableroView.ponerFicha(x, y, '2');
                        break;
                }
            }            
        }  
        
        StackPane root = new StackPane();
        root.getChildren().add(tableroView.getGridTablero());
         
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
