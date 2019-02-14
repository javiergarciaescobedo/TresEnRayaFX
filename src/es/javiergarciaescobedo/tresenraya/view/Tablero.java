
package es.javiergarciaescobedo.tresenraya.view;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Tablero {
    
    GridPane gridTablero = new GridPane();
    
    public GridPane getGridTablero() {
        return gridTablero;
    }
    
    public void ponerFicha() {
        Circle circleFicha = new Circle(20, Color.RED);
        gridTablero.add(circleFicha, 0, 0);
    }
    
}
