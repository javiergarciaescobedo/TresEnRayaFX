
package es.javiergarciaescobedo.tresenrayafxmaven;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class TableroView {
    
    private GridPane gridTablero = new GridPane();
    private TresEnRaya tresEnRaya;
    
    private final double TAM_CASILLA = 60;
    private final double TAM_FICHA = 40;

    public TableroView() {
        this.nuevaPartida();
    }
    
    public GridPane getGridTablero() {
        return gridTablero;
    }
        
    public void nuevaPartida() {
        this.tresEnRaya = new TresEnRaya();
        this.mostrarCasillasTablero();
    }
    
    public void mostrarCasillasTablero() {
        for(int y=0; y<3; y++) {
            for(int x=0; x<3; x++) {
                rellenarCasilla(x, y);
            }
        }
    }

    private void mostrarFicha(int x, int y) {        
        Circle circleFicha = new Circle(TAM_FICHA / 2);
        // Centrar ficha en la casilla
        GridPane.setHalignment(circleFicha, HPos.CENTER);
        GridPane.setValignment(circleFicha, VPos.CENTER);
        // Colorear ficha según qué jugador ha colocado ficha en x, y
        char jugador = tresEnRaya.getJugadorEnCelda(x, y);
        switch (jugador) {
            case TresEnRaya.JUGADOR_1:
                circleFicha.setFill(Color.RED);
                break;
            case TresEnRaya.JUGADOR_2:
                circleFicha.setFill(Color.BLUE);
                break;
            default:
                System.out.println("ERROR: Se ha intentado mostrar ficha  "
                        + "de jugador inexistente: " + jugador);
                break;
        }
        // Mostrar la ficha en pantalla
        gridTablero.add(circleFicha, x, y);        
    }
    
    private void rellenarCasilla(int x, int y) {
        // Dibujar casillas como un cuadrado 
        Rectangle r = new Rectangle(TAM_CASILLA, TAM_CASILLA, Color.LIGHTGRAY);
        r.setStroke(Color.BLACK);
        gridTablero.add(r, x, y);
        // Detección de clics de ratón en la casilla
        r.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clicCasilla(x, y);
            }
        });
    }
    
    private void clicCasilla(int x, int y) {
        System.out.println("Se ha pulsado la celda: " + x + ", " + y);
        // Comprobar si la casilla está libre
        if(tresEnRaya.estaLibreCelda(x, y)) {
            System.out.println("   La celda está libre. Colocando ficha");
            // Intentar colocar la ficha sin no hay otra previamente
            if(tresEnRaya.ponerFicha(x, y)) {
                mostrarFicha(x, y);
                // Comprobar si ha ganado algún jugador
                if(tresEnRaya.getGanador() != TresEnRaya.JUGADOR_NO) {
                    mostrarGanador(tresEnRaya.getGanador());
                    this.nuevaPartida();
                } else { // No hay ganador
                    if(tresEnRaya.getContFichasRestan()[0] == 0 &&
                            tresEnRaya.getContFichasRestan()[1] == 0) {
                        // Ya no quedan fichas que poner
                        mostrarFinSinGanador();
                        this.nuevaPartida();
                    }
                }
            }
        } else {
            System.out.println("   La celda está ocupada");
        }
    }
    
    private void mostrarGanador(char jugadorGanador) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Fin de partida");
        alert.setHeaderText(null);
        alert.setContentText("Ha ganado el jugador: " + jugadorGanador);
        alert.showAndWait();
    }
    
    private void mostrarFinSinGanador() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Fin de partida");
        alert.setHeaderText(null);
        alert.setContentText("No hay ningún ganador");
        alert.showAndWait();
    }
    
}
