
package es.javiergarciaescobedo.tresenraya.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class TableroView {
    
    GridPane gridTablero = new GridPane();
    
    public GridPane getGridTablero() {
        return gridTablero;
    }
    
    public void ponerFicha(int x, int y, char jugador) {
        if(jugador == '1') {
            Circle circleFicha = new Circle(20, Color.RED);
            gridTablero.add(circleFicha, x, y);
        } else {
            Circle circleFicha = new Circle(20, Color.BLUE);
            gridTablero.add(circleFicha, x, y);
        }
    }
    
    public void rellenarCasilla(int x, int y) {
        Rectangle r = new Rectangle(40, 40, Color.LIGHTGRAY);
        r.setStroke(Color.BLACK);
        gridTablero.add(r, x, y);
        r.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("clic");
            }
        });
    }
    
    public void mostrarFondoTablero() {
        for(int y=0; y<3; y++) {
            for(int x=0; x<3; x++) {
                rellenarCasilla(x, y);
            }
        }
    }
    
}
